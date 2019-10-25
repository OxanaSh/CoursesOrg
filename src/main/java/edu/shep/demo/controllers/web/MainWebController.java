package edu.shep.demo.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("*")
@Controller
public class MainWebController {

    @RequestMapping ("/")
    String mainPage(){
        return "index";
    }

    @RequestMapping (value = "/login", method = RequestMethod.GET)
    String login(Model model,
                 @RequestParam(value="error", required = false) String error,
                 @RequestParam(value="logout", required = false) String logout){

        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);

        return "login";
    }

    @RequestMapping ("/admin")
    String mainAdmin(){
        return "administrator/mainAdmin";
    }


}
