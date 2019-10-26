package edu.shep.demo.controllers.web;

import edu.shep.demo.forms.UserForm;
import edu.shep.demo.model.Role;
import edu.shep.demo.model.User;
import edu.shep.demo.services.config.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RequestMapping("/admin/user")
@Controller
public class UserWebController {

    @Autowired
    UserService service;

    @RequestMapping("/list")
    String list(Model model){
        model.addAttribute("users", service.getAll());
        return "administrator/user/userList";
    }

    @RequestMapping("/delete/{id}")
    String delete(@PathVariable(value="id") String id){
        User unEnabled = service.get(id);
        unEnabled.setEnabled(false);
       service.update(unEnabled);
        return "redirect:/admin/user/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        UserForm userForm = new UserForm();
        Map<String, String> mavs = Arrays.stream(Role.values()).collect(Collectors.toMap(Role::getAuthority, Role::getAuthority));
        List<Role> roles = new ArrayList<>(Arrays.asList(Role.values()));
        model.addAttribute("userForm",userForm);
        model.addAttribute("roles", mavs);
        return "administrator/user/userAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@ModelAttribute("userForm") UserForm userForm){
        List<Role> newRoles = new ArrayList<>();
        for (Role newRole : userForm.getAuthorities()) {
            newRoles.add(newRole);
        }
        
        User newUser = new User(userForm.getUsername(), new BCryptPasswordEncoder().encode(userForm.getPassword()), newRoles, true, true, true, true);
        service.create(newUser);
        return"redirect:/admin/user/list";
    }


}
