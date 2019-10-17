package edu.shep.demo.controllers.web;


import edu.shep.demo.model.Person;
import edu.shep.demo.services.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/person")
@CrossOrigin("*")
@Controller
public class PersonWebController {
    @Autowired
    PersonServiceImpl service;

    @RequestMapping ("/list")
    String showAll(Model model){
        List<Person> list = service.getAll();
        model.addAttribute("persons", list);
        return "personsList";
    }



}
