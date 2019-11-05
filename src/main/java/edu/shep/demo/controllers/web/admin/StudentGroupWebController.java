package edu.shep.demo.controllers.web.admin;

import edu.shep.demo.forms.StudentForm;
import edu.shep.demo.forms.StudentGroupForm;
import edu.shep.demo.model.*;
import edu.shep.demo.services.speciality.impls.SpecialityServiceImpl;
import edu.shep.demo.services.student.impls.StudentServiceImpl;
import edu.shep.demo.services.studentGroup.impls.StudentGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RequestMapping("/admin/studentGroup")
@CrossOrigin("*")
@Controller
public class StudentGroupWebController {
    @Autowired
    StudentGroupServiceImpl service;
    @Autowired
    SpecialityServiceImpl specialityService;
    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping("/list")
    public String list(Model model){
        List<StudentGroup> list = service.getAll();
        list.sort(Comparator.comparing(StudentGroup::getGroupNumber));
        model.addAttribute("groups", list);
        return "administrator/studentGroup/groupList";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") String id){
        boolean isGroupEnabled=!service.get(id).isEnabled();
        StudentGroup newGroup=service.get(id);
        newGroup.setEnabled(isGroupEnabled);
        service.update(newGroup);
        return "redirect:/admin/studentGroup/list";
    }

    @RequestMapping(value ="/create", method = RequestMethod.GET)
    public String create(Model model){
        StudentGroupForm studentGroupForm = new StudentGroupForm();
        Map<String, String> lessonForms = Arrays.stream(LessonForm.values()).collect(Collectors.toMap(LessonForm::getLessonForm, LessonForm::getLessonForm));

      Map<String, String> specialities = specialityService.findAllByEnabledIsTrue().stream()
                .collect(Collectors.toMap(Speciality::getId, Speciality::getName));
    /*
        List<String> specialities = new ArrayList<>();
        List<Speciality> spec = specialityService.findAllByEnabledIsTrue();
        for(int i=0; i<spec.size(); i++){
            specialities.add(spec.get(i).getName());}
        System.out.println(specialities);
        specialities.sort(Comparator.comparing(String::toString));
 */

        model.addAttribute("specialities", specialities);
        model.addAttribute("lessonForms", lessonForms);
        model.addAttribute("groupForm", studentGroupForm);
        return "administrator/studentGroup/studentGroupAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("groupForm") StudentGroupForm groupForm){
        StudentGroup newGroup = new StudentGroup(groupForm.getGroupNumber(),groupForm.getFormOfStudying(), groupForm.getSpeciality(),
                                             Integer.parseInt(groupForm.getMaxStudentsNumber()));
        service.create(newGroup);
        return "redirect:/admin/studentGroup/list";
    }


    @RequestMapping(value ="/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") String id){
        StudentGroup studentGroupToUpdate = service.get(id);
        StudentGroupForm studentGroupForm = new StudentGroupForm(studentGroupToUpdate.getGroupNumber(),
                studentGroupToUpdate.getFormOfStudying(), studentGroupToUpdate.getSpeciality(),
                studentGroupToUpdate.getSchedule(), studentGroupToUpdate.isEnabled(), Integer.toString(studentGroupToUpdate.getMaxStudentsNumber()));

        Map<String, String> lessonForms = Arrays.stream(LessonForm.values()).collect(Collectors.toMap(LessonForm::getLessonForm, LessonForm::getLessonForm));
      //  Map<String, String> specialities = specialityService.findAllByEnabledIsTrue().stream()
      //          .collect(Collectors.toMap(Speciality::getId, Speciality::getName));
    /*
        List<String> specialities = new ArrayList<>();
        List<Speciality> spec = specialityService.findAllByEnabledIsTrue();
        for(int i=0; i<spec.size(); i++){
            specialities.add(spec.get(i).getName());}
        System.out.println(specialities);
        specialities.sort(Comparator.comparing(String::toString));
 */

        //model.addAttribute("specialities", specialities);
        model.addAttribute("lessonForms", lessonForms);
        model.addAttribute("groupForm", studentGroupForm);
        return "administrator/studentGroup/studentGroupUpdate";
    }



    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute("groupForm") StudentGroupForm groupForm, @PathVariable("id") String id){

        StudentGroup newGroup = new StudentGroup(id, groupForm.getGroupNumber(), groupForm.getFormOfStudying(), service.get(id).getSpeciality(),
                service.get(id).getStudents(), service.get(id).getSchedule(), Integer.parseInt(groupForm.getMaxStudentsNumber()), service.get(id).isEnabled());

        service.update(newGroup);
        return "redirect:/admin/studentGroup/list";
    }

    @RequestMapping("/{id}/studentsList")
    public String studentsList(Model model, @PathVariable("id")String id){
        model.addAttribute("students", service.get(id).getStudents());
        model.addAttribute("studentGroup", service.get(id));
        return "administrator/studentGroup/studentsList";
    }

/*
    @RequestMapping("/deleteFromGroup/{id}")
    public String deleteStudentFormGroup(@PathVariable("id") String id){
        StudentGroup newGroup = new StudentGroup();//service.findStudentGroupByStudentId(studentService.get(id));
        List<Student> newStudents = new ArrayList<>();
        for (Student student:newGroup.getStudents()
             ) {
            if(student!=studentService.get(id)){newStudents.add(student);}
        }
        newGroup.setStudents(newStudents);
        service.update(newGroup);
        return "redirect:/admin/studentGroup/"+newGroup.getId()+"/studentsList";
    }

*/
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public String addStudents(Model model, @PathVariable("id") String id){
        StudentGroupForm groupForm = new StudentGroupForm();
        groupForm.setId(id);


        List<String> studentsList = new ArrayList<>();
        if(service.get(id).getStudents()!=null){
                for(int i=0; i<service.get(id).getStudents().size(); i++){
            studentsList.add(studentService.getAll().get(i).getId());
                }
        }
        else studentsList = null;
        groupForm.setStudents(studentsList);

        Map<String, String> students = studentService.getAllByEnabledIsTrue().stream()
                .collect(Collectors.toMap(Student::getId, Student::getFullName));

        model.addAttribute("groupForm", groupForm);
        model.addAttribute("students", students);
        model.addAttribute("groupId", id);
        return "/administrator/studentGroup/addStudents";
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.POST)
    public String addStudents(@ModelAttribute("groupForm") StudentGroupForm groupForm, @PathVariable("id") String id
                              ){
        System.out.println(groupForm.getId());

        List <Student> newStudents = new ArrayList<>();
        for(int i=0; i<groupForm.getStudents().size(); i++)
        {
            newStudents.add(studentService.get(groupForm.getStudents().get(i)));
        }


        System.out.println(groupForm.getId());
        StudentGroup newGroup = service.get(groupForm.getId());
        newGroup.setStudents(newStudents);
        System.out.println(newGroup);
        service.update(newGroup);
        return "redirect:/admin/studentGroup/list";
    }


    @RequestMapping(value="/deleteStudent/{studentId}/fromGroup/{studentGroupId}")
    public  String deleteStudentFormGroup(@PathVariable("studentId") String studentId, @PathVariable("studentGroupId") String studentGroupId){
        List<Student> newStudents = new ArrayList<>();
        //System.out.println(studentId);
        for (Student student:service.get(studentGroupId).getStudents()
             ) {
            //System.out.println(student);
            //System.out.println(student.getId() + "-------" + studentId);
            if(!student.getId().equals(studentId)){
                newStudents.add(student);
               // System.out.println("ADDED student ----"+student);
            }
        }

        StudentGroup newGroup = service.get(studentGroupId);
        newGroup.setStudents(newStudents);
        System.out.println(newStudents);
        service.update(newGroup);
        return "redirect:/admin/studentGroup/"+studentGroupId+"/studentsList";
    }


}
