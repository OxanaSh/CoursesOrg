package edu.shep.demo.controllers.web;


import edu.shep.demo.forms.ApplicationForm;
import edu.shep.demo.forms.StudentForm;
import edu.shep.demo.forms.StudentGroupForm;
import edu.shep.demo.forms.TeacherForm;
import edu.shep.demo.model.*;
import edu.shep.demo.services.application.impls.ApplicationServiceImpl;
import edu.shep.demo.services.config.UserService;
import edu.shep.demo.services.person.impls.PersonServiceImpl;
import edu.shep.demo.services.speciality.impls.SpecialityServiceImpl;
import edu.shep.demo.services.student.impls.StudentServiceImpl;
import edu.shep.demo.services.studentGroup.impls.StudentGroupServiceImpl;
import edu.shep.demo.services.subject.impls.SubjectServiceImpl;
import edu.shep.demo.services.teacher.impls.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


@CrossOrigin("*")
@Controller
public class ApplicationWebController {
    @Autowired
    ApplicationServiceImpl applicationService;
    @Autowired
    SpecialityServiceImpl specialityService;
    @Autowired
    StudentGroupServiceImpl studentGroupService;
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    UserService userService;
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    PersonServiceImpl personService;
    @Autowired
    SubjectServiceImpl subjectService;


    /*CREATE APPLICATION*/

    @RequestMapping(value = "/application/", method = RequestMethod.GET)
    public String application(Model model){
        ApplicationForm applicationForm = new ApplicationForm();
        Map<String, String> lessonForms = Arrays.stream(LessonForm.values()).collect(Collectors.toMap(LessonForm::getLessonForm, LessonForm::getLessonForm));
        Map<String, String> occupations = Arrays.stream(Occupation.values()).collect(Collectors.toMap(Occupation::getOccupation, Occupation::getOccupation));
        Map<String, String> degrees = Arrays.stream(Degree.values()).collect(Collectors.toMap(Degree::getDegree, Degree::getDegree));

        Map<String, String> specialities = specialityService.findAllByEnabledIsTrue().stream()
                .collect(Collectors.toMap(Speciality::getId, Speciality::getName));



        model.addAttribute("degrees", degrees);
        model.addAttribute("occupations", occupations);
        model.addAttribute("specialities", specialities);
        model.addAttribute("lessonForms", lessonForms);
        model.addAttribute("applicationForm", applicationForm);
        return "application";
    }

    @RequestMapping(value = "/application/", method = RequestMethod.POST)
    public String application(@ModelAttribute("applicationForm") ApplicationForm applicationForm){
        Person newPerson =  new Person(applicationForm.getName(), applicationForm.getSurname(),
                applicationForm.getPatronymic(), LocalDate.parse(applicationForm.getDateOfBirth(),
                DateTimeFormatter.ofPattern("MM/dd/yyyy")), applicationForm.getPhoneNumber());

        Application newApplication = new Application(newPerson, applicationForm.getUsername(), applicationForm.getSpeciality(), applicationForm.getFormOfStudying(),
                                           applicationForm.getDegree(), false, LocalDate.now(), applicationForm.getWhomWantToBe());
        applicationService.create(newApplication);
        return "redirect:/";
    }

    /*SHOW APPLICATION LIST*/

    @RequestMapping("/admin/teacher/application")
    public String teacherApplication(Model model){
        List<Application> teachers = applicationService.getAllTeachers();
        teachers.sort(Comparator.comparing(Application::getDateOfFilling).reversed());
        model.addAttribute("teachers", teachers);
        return "/administrator/application/teacherApplicationList";
    }

    @RequestMapping("/admin/student/application")
    public String studentApplication(Model model){
        List<Application> students = applicationService.getAllStudents();
        students.sort(Comparator.comparing(Application::getDateOfFilling));
        model.addAttribute("students", students);
        return "/administrator/application/studentApplicationList";
    }

    @RequestMapping("/admin/changeApproved/{id}/true")
    public String changeApprovedTrue(@PathVariable("id") String id) {
        Application newApplication = applicationService.get(id);
        if (newApplication.getWhomWantToBe() == Occupation.TEACHER) return "redirect:/admin/teacher/application/"+id+"/createTeacher";
        else return "redirect:/admin/student/application/"+id+"/createStudent";
    }

    /*CREATE STUDENT FROM APPLICATION*/

    @RequestMapping(value="/admin/student/application/{id}/createStudent", method = RequestMethod.GET)
    public String createStudent(Model model, @PathVariable("id") String applicationId){
        Application application = applicationService.get(applicationId);
        StudentForm studentForm = new StudentForm(application.getPerson(), application.getEmail(),"");

        Map<String,String> groups = studentGroupService.findAllBySpeciality_Name(application.getSpeciality().getName(), application.getFormOfStudying()).stream()
                .collect(Collectors.toMap(StudentGroup::getId, StudentGroup::getGroupNumber));

        StudentGroupForm groupForm = new StudentGroupForm();
        System.out.println("StudentForm in GET " + studentForm.toString());
        model.addAttribute("groupForm", groupForm);
        model.addAttribute("groups",groups);
        model.addAttribute("studentForm", studentForm);
        return "administrator/application/createStudent";
    }

    @RequestMapping(value="/admin/student/application/{id}/createStudent", method = RequestMethod.POST)
    public String createStudent(@ModelAttribute("studentForm") StudentForm studentForm,
                                @ModelAttribute("groupForm") StudentGroupForm groupForm, @PathVariable("id") String applicationId){

        Application newApplication = applicationService.get(applicationId);

        Person newPerson = newApplication.getPerson();


        User newUser = new User (newApplication.getEmail(),
                new BCryptPasswordEncoder().encode(studentForm.getPassword()),
                new ArrayList<>(Arrays.asList(Role.USER_STUDENT)));

        Student newStudent = new Student(newPerson, newUser, true);

        StudentGroup newGroup = studentGroupService.get(groupForm.getGroupNumber());
        newGroup.getStudents().add(newStudent);

        personService.create(newPerson);
        userService.create(newUser);
        studentService.create(newStudent);
        studentGroupService.update(newGroup);


        boolean approved = true;
        newApplication.setApproval(approved);
        newApplication.setEnabled(false);
        applicationService.update(newApplication);
    return "redirect:/admin/student/application";
    }

    /*CREATE TEACHER FROM APPLICATION*/

    @RequestMapping(value="/admin/teacher/application/{id}/createTeacher", method = RequestMethod.GET)
    public String createTeacher(Model model, @PathVariable("id") String applicationId){
        Application application = applicationService.get(applicationId);
        TeacherForm teacherForm = new TeacherForm(application.getPerson(), application.getEmail(),"");

        List degrees = Arrays.asList(Degree.values());

        Map<String, String> subjects = subjectService.getAll().stream()
                .collect(Collectors.toMap(Subject::getId, Subject::getName));

        model.addAttribute("subjects", subjects);
        model.addAttribute("degrees", degrees);
        model.addAttribute("teacherForm", teacherForm);
        return "administrator/application/createTeacher";
    }

    @RequestMapping(value = "/admin/teacher/application/{id}/createTeacher", method = RequestMethod.POST)
    public String create(@PathVariable("id") String applicationId, @ModelAttribute("teacherForm") TeacherForm teacherForm){
        Application newApplication = applicationService.get(applicationId);
        List<Subject> newSubjects = new ArrayList<>();
        for (String id:teacherForm.getSubjects()) {
            newSubjects.add(subjectService.get(id));
        }

        Person newPerson = applicationService.get(applicationId).getPerson();
        User newUser = new User (applicationService.get(applicationId).getEmail(),
                new BCryptPasswordEncoder().encode(teacherForm.getPassword()),
                new ArrayList<>(Arrays.asList(Role.USER_TEACHER)));
        Teacher newTeacher = new Teacher(newPerson, newUser, teacherForm.getDegree(),
                LocalDate.parse(teacherForm.getExperience(), DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                newSubjects);

        personService.create(newPerson);
        userService.create(newUser);
        teacherService.create(newTeacher);

        boolean approved = true;
        newApplication.setApproval(approved);
        newApplication.setEnabled(false);
        applicationService.update(newApplication);
        return "redirect:/admin/teacher/application";
    }


    @RequestMapping("/admin/changeApproved/{id}/false")
    public String changeApprovedFalse(@PathVariable("id") String id) {
        Application newApplication = applicationService.get(id);
        boolean approved = false;
        newApplication.setApproval(approved);
        newApplication.setEnabled(false);
        applicationService.update(newApplication);

        if (newApplication.getWhomWantToBe() == Occupation.TEACHER) return "redirect:/admin/teacher/application";
        else return "redirect:/admin/student/application";
    }

}
