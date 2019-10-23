package edu.shep.demo.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


@CrossOrigin("*")
@Controller
public class MainWebController {

    @RequestMapping ("/")
    String mainPage(){


        return "index";
    }

    @RequestMapping ("/login")
    String login(){


        return "loginPanel";
    }

}
