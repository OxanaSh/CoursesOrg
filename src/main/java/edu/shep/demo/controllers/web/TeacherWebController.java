package edu.shep.demo.controllers.web;


import edu.shep.demo.forms.StudentForm;
import edu.shep.demo.forms.TeacherForm;
import edu.shep.demo.model.*;
import edu.shep.demo.services.config.UserService;
import edu.shep.demo.services.person.impls.PersonServiceImpl;
import edu.shep.demo.services.subject.impls.SubjectServiceImpl;
import edu.shep.demo.services.teacher.impls.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.EnumSyntax;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/admin/teacher")
@CrossOrigin("*")
@Controller
public class TeacherWebController {
    @Autowired
    TeacherServiceImpl service;
    @Autowired
    PersonServiceImpl personService;
    @Autowired
    UserService userService;
    @Autowired
    SubjectServiceImpl subjectService;

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("teachers", service.getAll());
        return "administrator/teacher/teacherList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        TeacherForm teacherForm = new TeacherForm();
        List degrees = Arrays.asList(Degree.values());

        Map<String, String> subjects = subjectService.getAll().stream()
                .collect(Collectors.toMap(Subject::getId, Subject::getName));

        model.addAttribute("subjects", subjects);
        model.addAttribute("degrees", degrees);
        model.addAttribute("teacherForm", teacherForm);
        return "administrator/teacher/teacherAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("teacherForm") TeacherForm teacherForm){
        List<Subject> newSubjects = new ArrayList<>();
        for (String id:teacherForm.getSubjects()
             ) {
            newSubjects.add(subjectService.get(id));
        }

        Person newPerson = new Person(teacherForm.getName(), teacherForm.getSurname(),
                teacherForm.getPatronymic(), LocalDate.parse(teacherForm.getDateOfBirth(),
                DateTimeFormatter.ofPattern("MM/dd/yyyy")), teacherForm.getPhoneNumber());
        User newUser = new User (teacherForm.getUsername(),
                new BCryptPasswordEncoder().encode(teacherForm.getPassword()),
                new ArrayList<>(Arrays.asList(Role.USER_TEACHER)));
        Teacher newTeacher = new Teacher(newPerson, newUser, teacherForm.getDegree(),
               LocalDate.parse(teacherForm.getExperience(), DateTimeFormatter.ofPattern("MM/dd/yyyy")),
               newSubjects);

        personService.create(newPerson);
        userService.create(newUser);
        service.create(newTeacher);
        return "redirect:/admin/teacher/list";
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") String id){
        Teacher teacherToUpdate = service.get(id);
        List<String> subList=new ArrayList<>();
        for(int i=0; i<teacherToUpdate.getSubjects().size(); i++){subList.add(teacherToUpdate.getSubjects().get(i).getId());}

        TeacherForm teacherForm = new TeacherForm(teacherToUpdate.getPerson().getName(), teacherToUpdate.getPerson().getSurname(),
                teacherToUpdate.getPerson().getPatronymic(), teacherToUpdate.getPerson().getDateOfBirth().toString(),
                teacherToUpdate.getPerson().getPhoneNumber(), teacherToUpdate.getUser().getUsername(), teacherToUpdate.getUser().getPassword(),
                teacherToUpdate.isEnabled(), teacherToUpdate.getDegree(), teacherToUpdate.getExperience().toString(), subList);
        List degrees = Arrays.asList(Degree.values());

        Map<String, String> subjects = subjectService.getAll().stream()
                .collect(Collectors.toMap(Subject::getId, Subject::getName));

        model.addAttribute("subjects", subjects);
        model.addAttribute("degrees", degrees);
        model.addAttribute("teacherForm", teacherForm);
        return "administrator/teacher/teacherUpdate";
    }

    @RequestMapping(value="/update/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute("teacherForm") TeacherForm teacherForm, @PathVariable("id") String id){
        List<Subject> newSubjects = new ArrayList<>();
        for (String subjectId:teacherForm.getSubjects()
        ) {
            newSubjects.add(subjectService.get(subjectId));
        }

        LocalDate newDateOfBirth;
        LocalDate newExperience;

        try{
            newDateOfBirth = LocalDate.parse(teacherForm.getDateOfBirth(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        }
        catch(DateTimeParseException e){
            newDateOfBirth = LocalDate.parse(teacherForm.getDateOfBirth(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        try{
            newExperience = LocalDate.parse(teacherForm.getExperience(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        }
        catch(DateTimeParseException e){
            newExperience = LocalDate.parse(teacherForm.getExperience(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        Person newPerson = new Person(service.get(id).getPerson().getId(), teacherForm.getName(), teacherForm.getSurname(),
                teacherForm.getPatronymic(), newDateOfBirth, teacherForm.getPhoneNumber(), service.get(id).getPerson().isEnabled());
        User newUser = new User (service.get(id).getUser().getId(),teacherForm.getUsername(),
                new BCryptPasswordEncoder().encode(teacherForm.getPassword()),
                new ArrayList<>(Arrays.asList(Role.USER_TEACHER)), service.get(id).getUser().isEnabled());
        Teacher newTeacher = new Teacher(id, newPerson, newUser, teacherForm.getDegree(),
                newExperience, newSubjects, service.get(id).isEnabled());

        personService.update(newPerson);
        userService.update(newUser);
        service.update(newTeacher);
        return "redirect:/admin/teacher/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") String id){
        boolean isTeacherEnabled;
        if(service.get(id).getPerson().isEnabled() ) {
            isTeacherEnabled = service.get(id).isEnabled()?false:true;
        }
        else {isTeacherEnabled = false;}

        Teacher updTeacher = service.get(id);
        updTeacher.setEnabled(isTeacherEnabled);
        service.update(updTeacher);

        //checking if some student/teacher object containing exact person is enabled
        // and disable the person if both teacher and student is disabled
        if(!isTeacherEnabled && !personService.isEnabledAnywhereById(service.get(id).getPerson().getId())) {
            Person newPerson = personService.get(service.get(id).getPerson().getId());
            newPerson.setEnabled(false);
            User newUser = userService.get(service.get(id).getUser().getId());
            if(!newUser.getAuthorities().contains(Role.ADMIN)) {newUser.setEnabled(false);}

            userService.update(newUser);
            personService.update(newPerson);
        }

        return "redirect:/admin/student/list";
    }


}
