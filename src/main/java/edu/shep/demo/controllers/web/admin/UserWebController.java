package edu.shep.demo.controllers.web.admin;

import edu.shep.demo.model.Role;
import edu.shep.demo.model.User;
import edu.shep.demo.services.config.UserService;
import edu.shep.demo.services.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;
import java.util.stream.Collectors;


@RequestMapping("/admin/user")
@Controller
public class UserWebController {
    @Autowired
    UserService service;
    @Autowired
    PersonServiceImpl personService;


    @RequestMapping("/list")
    public String list(Model model){
        List<User> users= service.getAll();
        users.sort(Comparator.comparing(User::getUsername));
        model.addAttribute("users", users);
        return "administrator/user/userList";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(value="id") String id){
        User unEnabled = service.get(id);
       if(unEnabled.isEnabled()){
        unEnabled.setEnabled(false);
        //personService.disableEveryObjectContainingPersonById();
       }
       else unEnabled.setEnabled(true);
       service.update(unEnabled);
        return "redirect:/admin/user/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        User userForm = new User();
        Map<String, String> mavs = Arrays.stream(Role.values()).collect(Collectors.toMap(Role::getAuthority, Role::getAuthority));
        //List<Role> roles = new ArrayList<>(Arrays.asList(Role.values()));
        model.addAttribute("userForm",userForm);
        model.addAttribute("roles", mavs);
        return "administrator/user/userAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("userForm") User userForm){
        List<Role> newRoles = new ArrayList<>();
        for (Role newRole : userForm.getAuthorities()) {
            newRoles.add(newRole);
        }
        
        User newUser = new User(userForm.getUsername(), new BCryptPasswordEncoder().encode(userForm.getPassword()), newRoles, true, true, true, true);
        service.create(newUser);
        return"redirect:/admin/user/list";
    }


    @RequestMapping(value="/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable(value="id") String id){
        User userToUpdate = service.get(id);

        Map<String, String> roles = Arrays.stream(Role.values()).collect(Collectors.toMap(Role::getAuthority, Role::getAuthority));

        model.addAttribute("roles", roles);
        model.addAttribute("userForm",userToUpdate);

        return "administrator/user/userUpdate";
    }

    @RequestMapping(value="/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("userForm") User userForm, @PathVariable(value="id") String id){
        List<Role> newRoles = new ArrayList<>();
        for (Role newRole : userForm.getAuthorities()) {
            newRoles.add(newRole);
        }

        User newUser = new User(userForm.getUsername(), service.get(id).getPassword(), newRoles, service.get(id).isAccountNonExpired(),service.get(id).isAccountNonLocked(), service.get(id).isCredentialsNonExpired(),service.get(id).isEnabled());
        service.update(userForm);
        return "redirect:/admin/user/list";
    }




}
