package edu.shep.demo.controllers.web;


import edu.shep.demo.forms.PersonForm;
import edu.shep.demo.forms.StudentForm;
import edu.shep.demo.model.Person;
import edu.shep.demo.model.Role;
import edu.shep.demo.model.Student;
import edu.shep.demo.model.User;
import edu.shep.demo.repository.StudentRepository;
import edu.shep.demo.services.config.UserService;
import edu.shep.demo.services.person.impls.PersonServiceImpl;
import edu.shep.demo.services.student.impls.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
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
    @Autowired
    UserService userService;


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
        model.addAttribute("studentForm", studentForm);
        return  "administrator/student/studentAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("studentForm") StudentForm studentForm){

       Person newPerson = new Person(studentForm.getName(), studentForm.getSurname(),
               studentForm.getPatronymic(), LocalDate.parse(studentForm.getDateOfBirth(),
               DateTimeFormatter.ofPattern("MM/dd/yyyy")), studentForm.getPhoneNumber());

       User newUser = new User (studentForm.getUsername(),
               new BCryptPasswordEncoder().encode(studentForm.getPassword()),
               new ArrayList<>(Arrays.asList(Role.USER_STUDENT)));

       Student newStudent = new Student(newPerson, newUser, true);

       personService.create(newPerson);
       userService.create(newUser);
       service.create(newStudent);
       return "redirect:/admin/student/list";
    }


   @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
   public String update(Model model, @PathVariable("id") String id){
        Student studentToUpdate = service.get(id);
        StudentForm studentForm = new StudentForm(studentToUpdate.getPerson().getName(), studentToUpdate.getPerson().getSurname(),
                studentToUpdate.getPerson().getPatronymic(), studentToUpdate.getPerson().getDateOfBirth().toString(),
                studentToUpdate.getPerson().getPhoneNumber(), studentToUpdate.getUser().getUsername(), studentToUpdate.getUser().getPassword(), studentToUpdate.isActive());
        studentForm.setId(id);
        model.addAttribute("studentForm", studentForm);
       return "/administrator/student/studentUpdate";
   }

   @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
   public String update(@ModelAttribute("studentForm") StudentForm studentForm, @PathVariable("id") String id){
       LocalDate newDate;
       try{
           newDate = LocalDate.parse(studentForm.getDateOfBirth(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
       }
       catch(DateTimeParseException e){
           newDate = LocalDate.parse(studentForm.getDateOfBirth(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
       }

        Person newPerson = new Person(studentForm.getName(), studentForm.getSurname(), studentForm.getPatronymic(),
                newDate,studentForm.getPhoneNumber());

        User newUser = new User(studentForm.getUsername(), studentForm.getPassword(), new ArrayList<>(Arrays.asList(Role.USER_STUDENT)));

        Student newStudent = new Student(newPerson, newUser, studentForm.isEnabled());

       personService.update(newPerson);
       userService.update(newUser);
       service.update(newStudent);

        return "redirect:/admin/student/list";
   }


}
