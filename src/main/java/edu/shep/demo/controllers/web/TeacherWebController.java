package edu.shep.demo.controllers.web;


import edu.shep.demo.services.config.UserService;
import edu.shep.demo.services.person.impls.PersonServiceImpl;
import edu.shep.demo.services.teacher.impls.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

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





}
