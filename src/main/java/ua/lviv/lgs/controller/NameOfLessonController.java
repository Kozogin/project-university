package ua.lviv.lgs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.FacultyLessons;
import ua.lviv.lgs.domain.NameOfLesson;
import ua.lviv.lgs.service.FacultyLessonsService;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.NameOfLessonService;

@Controller
public class NameOfLessonController {
	
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
    	
    	//model.addAttribute("faculty", new Faculty());
    	    	    	
    	ModelAndView map = new ModelAndView("lessons");
    	//map.addObject("lessons", nameOfLessonService.getAllLesson());	
    	
//    	model.addAttribute("selectFaculty", new Faculty()); 
    	
    	List<Faculty> listInteger = new ArrayList<>();
    	listInteger.add(new Faculty(201,"iitt"));
    	listInteger.add(new Faculty(202, "llkk"));
    	listInteger.add(new Faculty(203,"8844"));
    	listInteger.add(new Faculty(204, "y5t8"));
    	
    	
    	map.addObject("faculties", listInteger);
    	map.addObject("selectFaculty", new Faculty());
    	
    	
    	
    	
  //  	map.addObject("faculties", facultyService.getAllFaculty());
        return map;
    }
    
    @RequestMapping(value = "/lessons", method = RequestMethod.POST)
	public ModelAndView addFacultyLessons(@ModelAttribute("selectFaculty") Faculty faculty) {
			
//		
//		NameOfLesson nameOfLesson = nameOfLessonService.findByLessonId(lessonId);
//		
//		FacultyLessons facultyLessons = new FacultyLessons();
//		facultyLessons.setNameOfLessons(nameOfLesson);
//				
//		System.out.println(facultyLessons.getNameOfLessons());
		System.out.println("facultyId ----- "+faculty);
		//System.out.println("lessonId ------- "+lessonId);
		
	//	facultyLessonsService.addFacultyLessons(facultyLessons);
		return new ModelAndView("lessons");
	}
    
    
    
    
//    private ModelAndView getFacultyLessonsItems() {
//		ModelAndView map = new ModelAndView("redirect:/add_lesson_to_faculty");
//		map.addObject("add_lesson_to_faculty", facultyLessonsService.getAll());
//		return map;		
//	}

}
