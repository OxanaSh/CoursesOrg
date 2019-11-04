package edu.shep.demo.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/student/lesson")
@CrossOrigin("*")
@Controller
public class LessonWebController {

    @RequestMapping("/list")
    public String schedule(){


        return "";
    }

}
