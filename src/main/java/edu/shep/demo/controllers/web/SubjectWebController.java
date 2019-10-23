package edu.shep.demo.controllers.web;

import edu.shep.demo.forms.SubjectForm;
import edu.shep.demo.model.Subject;
import edu.shep.demo.services.subject.impls.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RequestMapping("/admin/subject")
@CrossOrigin("*")
@Controller
public class SubjectWebController {
    @Autowired
    SubjectServiceImpl service;

    @RequestMapping ("/list")
    String showAll(Model model){
        List<Subject> list = service.getAll();
        model.addAttribute("subjects", list);
        return "subject/subjectsList";
    }

    @RequestMapping("/delete/{id}")
    RedirectView delete(@PathVariable(value = "id") String id){
        service.delete(id);
        return  new RedirectView("/admin/subject/list");
    }




    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String addSubject(Model model){
        SubjectForm subjectForm = new SubjectForm();
        model.addAttribute("subjectForm", subjectForm);
        return "subject/subjectAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute("subjectForm") SubjectForm subjectForm){
        Subject newSubject = new Subject(subjectForm.getName(), Double.parseDouble(subjectForm.getHours()));
        service.create(newSubject);
        return "redirect:/admin/subject/list";
    }




    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateSubject(Model model, @PathVariable(value="id") String id){
        Subject subjectToUpdate = service.get(id);
        SubjectForm subjectForm = new SubjectForm(subjectToUpdate.getName(), Double.toString(subjectToUpdate.getHours()));
        subjectForm.setId(subjectToUpdate.getId());
        model.addAttribute("subjectForm", subjectForm);
        return "subject/subjectUpdate";
    }



    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("subjectForm") SubjectForm subjectForm, @PathVariable(value="id") String id){


        Subject newSubject = new Subject(subjectForm.getName(), Double.parseDouble(subjectForm.getHours()));
        newSubject.setId(id);
        service.update(newSubject);
        return "redirect:/admin/subject/list";
    }




}
