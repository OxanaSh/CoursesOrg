package edu.shep.demo.controllers.web;


import edu.shep.demo.model.Student;
import edu.shep.demo.repository.StudentRepository;
import edu.shep.demo.services.student.impls.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/student")
@CrossOrigin("*")
@Controller
public class StudentWebController {
    @Autowired
    StudentServiceImpl service;

    @RequestMapping ("/list")
    String showAll(Model model){
        List<Student> list = service.getAll();
        model.addAttribute("students", list);
        return "studentsList";
    }



}
