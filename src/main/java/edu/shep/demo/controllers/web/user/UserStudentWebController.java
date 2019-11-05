package edu.shep.demo.controllers.web.user;

import edu.shep.demo.model.Student;
import edu.shep.demo.model.StudentGroup;
import edu.shep.demo.model.Subject;
import edu.shep.demo.model.User;
import edu.shep.demo.services.config.UserService;
import edu.shep.demo.services.student.impls.StudentServiceImpl;
import edu.shep.demo.services.studentGroup.impls.StudentGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/student/user")
@CrossOrigin("*")
@Controller
public class UserStudentWebController {
    @Autowired
    UserService userService;
    @Autowired
    StudentGroupServiceImpl studentGroupService;
    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping("/")
    public String main(){

        return"student/mainStudent";
    }

    @RequestMapping("/classmates")
    public String classmates(Model model){
        boolean isAuthenticated;
        // checking if someone is logged in
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails) isAuthenticated = true;
        else isAuthenticated = false;

        if(isAuthenticated){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = (User) authentication.getPrincipal();
            Student student = studentService.findByUserId(user.getId());
            StudentGroup group = studentGroupService.findByStudentId(student.getId());

            model.addAttribute("username", user.getUsername());
            model.addAttribute("group", group);
        }


        return"student/classmates";
    }


    @RequestMapping("/subjects")
    public String subjects(Model model){
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Student student = studentService.findByUserId(user.getId());
            StudentGroup group = studentGroupService.findByStudentId(student.getId());

            model.addAttribute("username", user.getUsername());
            model.addAttribute("speciality", group.getSpeciality());


        return"student/subjects";
    }

}
