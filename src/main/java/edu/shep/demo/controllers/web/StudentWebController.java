package edu.shep.demo.controllers.web;


import edu.shep.demo.forms.PersonForm;
import edu.shep.demo.forms.StudentForm;
import edu.shep.demo.model.Person;
import edu.shep.demo.model.Student;
import edu.shep.demo.repository.StudentRepository;
import edu.shep.demo.services.person.impls.PersonServiceImpl;
import edu.shep.demo.services.student.impls.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/admin/student")
@CrossOrigin("*")
@Controller
public class StudentWebController {
    @Autowired
    StudentServiceImpl service;

    @Autowired
    PersonServiceImpl personService;

    @RequestMapping ("/list")
    public String list(Model model){
        List<Student> list = service.getAll();
        model.addAttribute("students", list);
        return "administrator/student/studentList";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") String id){
        service.delete(id);
        return  "redirect:/admin/student/list";
    }

    @RequestMapping(value="/create", method = RequestMethod.GET)
    public String create(Model model){

        StudentForm studentForm = new StudentForm();
        PersonForm personForm = new PersonForm();

        model.addAttribute("studentForm", studentForm);
        model.addAttribute("personForm", personForm);
        return  "administrator/student/studentAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("studentForm") StudentForm studentForm, @ModelAttribute("personForm") PersonForm personForm){

       Person newPerson = new Person(personForm.getName(), personForm.getSurname(), personForm.getPatronymic(),
                LocalDate.parse(personForm.getDateOfBirth(), DateTimeFormatter.ofPattern("MM/dd/yyyy")), personForm.getPhoneNumber());

       Student newStudent = new Student(newPerson, studentForm.getEmail(), studentForm.getPassword());

       personService.create(newPerson);
       service.create(newStudent);
       return "redirect:/admin/student/list";
    }


   // @RequestMapping(value = )
  //  String updateWorker

}
