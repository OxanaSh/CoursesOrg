package edu.shep.demo.controllers.web;

import edu.shep.demo.forms.LessonForm;
import edu.shep.demo.model.Lesson;
import edu.shep.demo.services.lesson.impls.LessonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/schedule")
@CrossOrigin("*")
@Controller
public class ScheduleWebController {
    @Autowired
    LessonServiceImpl lessonService;



    @RequestMapping("/")
    public String schedule(){

       return "schedule/February";
   }

    @RequestMapping(value = "/addLesson", method = RequestMethod.GET)
    public String addLesson(Model model){
        boolean isAuthenticated;
        // checking if someone is logged in
        //if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails) isAuthenticated = true;
        //else isAuthenticated = false;


        LessonForm lessonForm = new LessonForm();
        model.addAttribute("lessonForm", lessonForm);
        return "schedule/addLesson";
    }

    @RequestMapping(value = "/addLesson", method = RequestMethod.POST)
    public String addLesson(Model model, @ModelAttribute("lessonForm") LessonForm lessonForm){
        Lesson newLesson = new Lesson(lessonForm.getTopic());
        lessonService.create(newLesson);
        return "redirect:/schedule/";
    }


}
