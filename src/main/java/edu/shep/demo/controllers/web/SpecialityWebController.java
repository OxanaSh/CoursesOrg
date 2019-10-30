package edu.shep.demo.controllers.web;


import edu.shep.demo.forms.SpecialityForm;
import edu.shep.demo.model.Speciality;
import edu.shep.demo.model.Subject;
import edu.shep.demo.services.speciality.impls.SpecialityServiceImpl;
import edu.shep.demo.services.subject.impls.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequestMapping("/admin/speciality")
@CrossOrigin("*")
@Controller
public class SpecialityWebController {
    @Autowired
    SpecialityServiceImpl service;
    @Autowired
    SubjectServiceImpl subjectService;

    @RequestMapping ("/list")
    public String list(Model model){
        List<Speciality> list = service.getAll();
        model.addAttribute("specialities", list);
        return "administrator/speciality/specialityList";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") String id){
        service.delete(id);
        return  "redirect:/admin/speciality/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        SpecialityForm specialityForm = new SpecialityForm();

        Map<String, String> mavs = subjectService.getAll().stream()
                .collect(Collectors.toMap(Subject::getId, Subject::getName));

        model.addAttribute("mavs", mavs);
        model.addAttribute("specialityForm", specialityForm);
        return  "administrator/speciality/specialityAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("specialityForm") SpecialityForm specialityForm){
        List <Subject> newSubjects = new ArrayList<>();
        for(int i=0; i<specialityForm.getSubjects().size(); i++)
        {
            newSubjects.add(subjectService.get(specialityForm.getSubjects().get(i)));
        }

        Speciality newSpeciality= new Speciality(Integer.parseInt(specialityForm.getCode()), specialityForm.getName(),
                Integer.parseInt(specialityForm.getPayment()), newSubjects);
    service.create(newSpeciality);
        return "redirect:/admin/speciality/list";
    }



    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable(value="id") String id){
        Speciality specialityToUpdate = service.get(id);
        List<String> subList=new ArrayList<>();
        for(int i=0; i<specialityToUpdate.getSubjects().size(); i++){subList.add(specialityToUpdate.getSubjects().get(i).getId());}
        SpecialityForm specialityForm = new SpecialityForm(Integer.toString(specialityToUpdate.getCode()), specialityToUpdate.getName(),
               Integer.toString(specialityToUpdate.getPayment()), subList);
        specialityForm.setId(specialityToUpdate.getId());

        Map<String, String> mavs = subjectService.getAll().stream()
                .collect(Collectors.toMap(Subject::getId, Subject::getName));


        model.addAttribute("specialityForm", specialityForm);
        model.addAttribute("mavs", mavs);
        return "administrator/speciality/specialityUpdate";
    }



    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("subjectForm") SpecialityForm specialityForm, @PathVariable(value="id") String id){
        List<Subject> newSubjects = new ArrayList<>();
        for(int i=0; i<specialityForm.getSubjects().size(); i++)
        {
            newSubjects.add(subjectService.get(specialityForm.getSubjects().get(i)));
        }

        Speciality newSpeciality = new Speciality(Integer.parseInt(specialityForm.getCode()), specialityForm.getName()
                , Integer.parseInt(specialityForm.getPayment()), newSubjects);
        newSpeciality.setId(id);

        service.update(newSpeciality);
        return "redirect:/admin/speciality/list";
    }




}
