package edu.shep.demo.controllers.web;


import edu.shep.demo.forms.ApplicationForm;
import edu.shep.demo.model.*;
import edu.shep.demo.services.application.impls.ApplicationServiceImpl;
import edu.shep.demo.services.speciality.impls.SpecialityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/admin/application")
@CrossOrigin("*")
@Controller
public class ApplicationWebController {
    @Autowired
    ApplicationServiceImpl applicationService;
    @Autowired
    SpecialityServiceImpl specialityService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String application(Model model){
        ApplicationForm applicationForm = new ApplicationForm();
        Map<String, String> lessonForms = Arrays.stream(LessonForm.values()).collect(Collectors.toMap(LessonForm::getLessonForm, LessonForm::getLessonForm));
        Map<String, String> occupations = Arrays.stream(Occupation.values()).collect(Collectors.toMap(Occupation::getOccupation, Occupation::getOccupation));

        Map<String, String> specialities = specialityService.findAllByEnabledIsTrue().stream()
                .collect(Collectors.toMap(Speciality::getId, Speciality::getName));

        model.addAttribute("occupations", occupations);
        model.addAttribute("specialities", specialities);
        model.addAttribute("lessonForms", lessonForms);
        model.addAttribute("applicationForm", applicationForm);
        return "application";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String application(@ModelAttribute("applicationForm") ApplicationForm applicationForm){
        Person newPerson =  new Person(applicationForm.getName(), applicationForm.getSurname(),
                applicationForm.getPatronymic(), LocalDate.parse(applicationForm.getDateOfBirth(),
                DateTimeFormatter.ofPattern("MM/dd/yyyy")), applicationForm.getPhoneNumber());

        Application newApplication = new Application(newPerson, applicationForm.getUsername(), applicationForm.getSpeciality(), applicationForm.getFormOfStudying(),
                                            false, LocalDate.now(), applicationForm.getWhomWantToBe());
        applicationService.create(newApplication);
        return "redirect:/";
    }



}
