package edu.shep.demo.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@CrossOrigin("*")
@Controller
public class MainWebController {

    @RequestMapping ("/")
    String mainPage(){


        return "index";
    }

    @RequestMapping (value = "/login", method = RequestMethod.GET)
    String login(Model model, String error, String logout){


        return "login";
    }

}
