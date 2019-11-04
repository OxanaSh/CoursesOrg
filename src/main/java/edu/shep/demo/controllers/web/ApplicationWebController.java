package edu.shep.demo.controllers.web;


import edu.shep.demo.forms.ApplicationForm;
import edu.shep.demo.model.*;
import edu.shep.demo.services.application.impls.ApplicationServiceImpl;
import edu.shep.demo.services.speciality.impls.SpecialityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;


@CrossOrigin("*")
@Controller
public class ApplicationWebController {
    @Autowired
    ApplicationServiceImpl applicationService;
    @Autowired
    SpecialityServiceImpl specialityService;

    @RequestMapping(value = "/application/", method = RequestMethod.GET)
    public String application(Model model){
        ApplicationForm applicationForm = new ApplicationForm();
        Map<String, String> lessonForms = Arrays.stream(LessonForm.values()).collect(Collectors.toMap(LessonForm::getLessonForm, LessonForm::getLessonForm));
        Map<String, String> occupations = Arrays.stream(Occupation.values()).collect(Collectors.toMap(Occupation::getOccupation, Occupation::getOccupation));
        Map<String, String> degrees = Arrays.stream(Degree.values()).collect(Collectors.toMap(Degree::getDegree, Degree::getDegree));

        Map<String, String> specialities = specialityService.findAllByEnabledIsTrue().stream()
                .collect(Collectors.toMap(Speciality::getId, Speciality::getName));

        model.addAttribute("degrees", degrees);
        model.addAttribute("occupations", occupations);
        model.addAttribute("specialities", specialities);
        model.addAttribute("lessonForms", lessonForms);
        model.addAttribute("applicationForm", applicationForm);
        return "application";
    }

    @RequestMapping(value = "/application/", method = RequestMethod.POST)
    public String application(@ModelAttribute("applicationForm") ApplicationForm applicationForm){
        Person newPerson =  new Person(applicationForm.getName(), applicationForm.getSurname(),
                applicationForm.getPatronymic(), LocalDate.parse(applicationForm.getDateOfBirth(),
                DateTimeFormatter.ofPattern("MM/dd/yyyy")), applicationForm.getPhoneNumber());

        Application newApplication = new Application(newPerson, applicationForm.getUsername(), applicationForm.getSpeciality(), applicationForm.getFormOfStudying(),
                                           applicationForm.getDegree(), false, LocalDate.now(), applicationForm.getWhomWantToBe());
        applicationService.create(newApplication);
        return "redirect:/application/";
    }

    @RequestMapping("/admin/teacher/application")
    public String teacherApplication(Model model){
        model.addAttribute("teachers", applicationService.getAllTeachers());
        return "/administrator/application/teacherApplicationList";
    }

    @RequestMapping("/admin/changeApproved/{id}/true")
    public String changeApprovedTrue(@PathVariable("id") String id) {
        Application newApplication = applicationService.get(id);
        boolean approved = true;
        newApplication.setApproval(approved);
        newApplication.setEnabled(false);
        applicationService.update(newApplication);



        if (newApplication.getWhomWantToBe() == Occupation.TEACHER) return "redirect:/admin/teacher/application";
        else return "redirect:/admin/student/application";
    }

    @RequestMapping("/admin/changeApproved/{id}/false")
    public String changeApprovedFalse(@PathVariable("id") String id) {
        Application newApplication = applicationService.get(id);
        boolean approved = false;
        newApplication.setApproval(approved);
        newApplication.setEnabled(false);
        applicationService.update(newApplication);

        if (newApplication.getWhomWantToBe() == Occupation.TEACHER) return "redirect:/admin/teacher/application";
        else return "redirect:/admin/student/application";
    }

}
