package edu.shep.demo.controllers.web.admin;

import edu.shep.demo.forms.SubjectForm;
import edu.shep.demo.model.Speciality;
import edu.shep.demo.model.Subject;
import edu.shep.demo.services.speciality.impls.SpecialityServiceImpl;
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
    @Autowired
    SpecialityServiceImpl specialityService;


    @RequestMapping ("/list")
    public String list(Model model){
        List<Subject> list = service.getAll();
        model.addAttribute("subjects", list);
        return "administrator/subject/subjectsList";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") String id){
        //service.delete(id);
        Subject newSubject = service.get(id);
        newSubject.setEnabled(!newSubject.isEnabled());
        service.update(newSubject);
        return  "redirect:/admin/subject/list";
    }




    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        SubjectForm subjectForm = new SubjectForm();
        model.addAttribute("subjectForm", subjectForm);
        return "administrator/subject/subjectAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute("subjectForm") SubjectForm subjectForm){
        Subject newSubject = new Subject(subjectForm.getName(), Double.parseDouble(subjectForm.getHours()));
        if(!service.existsByNameAndHours(newSubject.getName(), newSubject.getHours())) service.create(newSubject);
        return "redirect:/admin/subject/list";
    }




    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable(value="id") String id){
        Subject subjectToUpdate = service.get(id);
        SubjectForm subjectForm = new SubjectForm(subjectToUpdate.getName(), Double.toString(subjectToUpdate.getHours()));
        subjectForm.setId(subjectToUpdate.getId());
        model.addAttribute("subjectForm", subjectForm);
        return "administrator/subject/subjectUpdate";
    }



    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("subjectForm") SubjectForm subjectForm, @PathVariable(value="id") String id){
        Subject newSubject = new Subject(subjectForm.getName(), Double.parseDouble(subjectForm.getHours()));
        newSubject.setId(id);
        List<Speciality> specialitiesToUpdate = specialityService.findAllBySubjectsContains(service.get(id));

        /*later
        System.out.println(specialitiesToUpdate);
        List<Subject> subjects;
        if(specialitiesToUpdate != null){
            for (Speciality specialityToUpdate:specialitiesToUpdate) {
                subjects = specialityToUpdate.getSubjects();
                for (Subject subject:subjects) {
                    if(subject==service.get(id)) {subject = newSubject;
                    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        System.out.println(subjects);
                                                  specialityToUpdate.setSubjects(subjects);
                                                  specialityService.update(specialityToUpdate);
                                                  break;
                    }
                }
            }
        }
        */
        service.update(newSubject);
        return "redirect:/admin/subject/list";
    }




}
