package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.lviv.lgs.domain.NameOfLesson;
import ua.lviv.lgs.service.NameOfLessonService;

@Controller
public class NameOfLessonController {
	
	@Autowired
    private NameOfLessonService nameOfLessonService;
    
	@RequestMapping(value ="/create_lesson", method = RequestMethod.GET)
    public String createLesson(Model model) {
    	model.addAttribute("createLessonForm", new NameOfLesson());
        return "create_lesson";
    }
    
    @RequestMapping(value = "/create_lesson", method = RequestMethod.POST)
    public String createLesson(@ModelAttribute("createLessonForm") NameOfLesson createLessonForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "user";
        }
        nameOfLessonService.save(createLessonForm);

        return "redirect:/create_lesson";
    }
    
    @RequestMapping(value ="/lessons", method = RequestMethod.GET)
    public String lessons() {     	
        return "lessons";
    }

}
