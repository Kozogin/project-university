package ua.lviv.lgs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.FacultyLessons;
import ua.lviv.lgs.domain.NameOfLesson;
import ua.lviv.lgs.service.FacultyLessonsService;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.NameOfLessonService;

@Controller
public class NameOfLessonController {
	
	private Faculty choiseFaculty = new Faculty();
	
	@Autowired
    private NameOfLessonService nameOfLessonService;
	
	@Autowired
    private FacultyService facultyService;
	
	@Autowired
	private FacultyLessonsService facultyLessonsService;
		    
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
    public ModelAndView welcome(ModelMap model) { 
    	    	    	
    	ModelAndView map = new ModelAndView("lessons");
    	List<Faculty> allAndChoiseFaculty = new ArrayList<>();
    	allAndChoiseFaculty.add(choiseFaculty);
    	allAndChoiseFaculty.addAll(facultyService.getAllFaculty());
    	
    	map.addObject("lessons", nameOfLessonService.getAllLesson());    	
    	map.addObject("faculties", allAndChoiseFaculty);    	
    	map.addObject("selectFaculty", new Faculty());
    	
        return map;
    }
    
    @RequestMapping(value = "/lessons", method = RequestMethod.POST)
	public ModelAndView addFacultyLessons(@ModelAttribute("selectFaculty") Faculty faculty, NameOfLesson lesson) {
		
    	try {
    		if(faculty.getFacultyId() != null) {    		
    			choiseFaculty = new Faculty(facultyService.findByFacultyId(faculty.getFacultyId()));
    		}
    		
    		NameOfLesson nameOfLesson = nameOfLessonService.findByLessonId(lesson.getLessonId());
    		if(nameOfLesson != null) {
	    		
	    		FacultyLessons facultyLessons = new FacultyLessons();
	    		facultyLessons.setNameOfLessons(nameOfLesson);
	    		facultyLessons.setFacultys(choiseFaculty);		
	    		facultyLessonsService.addFacultyLessons(facultyLessons);
    		}
	    		
    	} catch(Exception e) {}
		
		return new ModelAndView("redirect:/lessons");
	}
    

}
