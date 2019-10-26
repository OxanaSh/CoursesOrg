package edu.shep.demo.controllers.web;

import edu.shep.demo.model.Role;
import edu.shep.demo.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static java.util.stream.Collectors.joining;


@CrossOrigin("*")
@Controller
public class MainWebController {

    @RequestMapping ("/")
    String mainPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        model.addAttribute("username", user.getUsername());
        model.addAttribute("roles", user.getAuthorities().stream().map(Role::getAuthority).collect(joining(",")));
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
