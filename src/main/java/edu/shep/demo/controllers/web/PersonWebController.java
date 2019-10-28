package edu.shep.demo.controllers.web;


import edu.shep.demo.forms.PersonForm;
import edu.shep.demo.model.Person;
import edu.shep.demo.services.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RequestMapping("/admin/person")
@CrossOrigin("*")
@Controller
public class PersonWebController {
    @Autowired
    PersonServiceImpl service;

    @RequestMapping ("/list")
    public String list(Model model){
        List<Person> list = service.getAll();
        model.addAttribute("persons", list);
        return "administrator/person/personsList";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") String id){
        service.delete(id);
        return  "redirect:/admin/person/list";
    }




    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);
        return "administrator/person/personAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute("personForm") PersonForm personForm){
        Person newPerson = new Person(personForm.getName(), personForm.getSurname(), personForm.getPatronymic(), LocalDate.parse(personForm.getDateOfBirth(), DateTimeFormatter.ofPattern("MM/dd/yyyy")), personForm.getPhoneNumber());
        service.create(newPerson);
        return "redirect:/admin/person/list";
    }




    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable(value="id") String id){
        Person personToUpdate = service.get(id);
        PersonForm personForm = new PersonForm(personToUpdate.getName(), personToUpdate.getSurname(), personToUpdate.getPatronymic(),
                personToUpdate.getDateOfBirth().toString(), personToUpdate.getPhoneNumber());
        personForm.setId(personToUpdate.getId());
        model.addAttribute("personForm", personForm);
        return "administrator/person/personUpdate";
    }



    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("personForm") PersonForm personForm, @PathVariable(value="id") String id){
        LocalDate newDate;
        try{
            newDate = LocalDate.parse(personForm.getDateOfBirth(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        }
        catch(DateTimeParseException e){
            newDate = LocalDate.parse(personForm.getDateOfBirth(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

     Person newPerson = new Person(personForm.getName(), personForm.getSurname(), personForm.getPatronymic(),
                newDate, personForm.getPhoneNumber());
        newPerson.setId(id);
        service.update(newPerson);
        return "redirect:/admin/person/list";
    }






}
