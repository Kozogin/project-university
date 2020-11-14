package ua.lviv.lgs.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.FacultyLessons;
import ua.lviv.lgs.domain.NameOfLesson;
import ua.lviv.lgs.service.FacultyLessonsService;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.NameOfLessonService;

@Controller
public class FacultyLessonsController {
	
	@Autowired
	private FacultyLessonsService facultyLessonsService;
	
	@Autowired
	private NameOfLessonService nameOfLessonService;
	
	@Autowired
	private FacultyService facultyService;
	
	@RequestMapping(value = "/add_lesson_to_facultys", method = RequestMethod.GET)
	public ModelAndView getAllItems() throws IOException {
		return getFacultyLessonsItems();
	}
	
	@RequestMapping(value = "/add_lesson_to_faculty", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam String facultyLessonsId) throws IOException {
		
		facultyLessonsService.delete(new FacultyLessons(Integer.parseInt(facultyLessonsId.replaceAll("\\s",""))));
				
		return getFacultyLessonsItems();
	}
	
//	@RequestMapping(value = "/add_lesson_to_faculty", method = RequestMethod.POST)
//	public ModelAndView addFacultyLessons(@RequestParam String lessonId) {
//			
//		
//		NameOfLesson nameOfLesson = nameOfLessonService.findByLessonId(Integer.parseInt(lessonId));
//		
//		FacultyLessons facultyLessons = new FacultyLessons();
//		facultyLessons.setNameOfLessons(nameOfLesson);
//				
//		System.out.println(facultyLessons.getNameOfLessons());
//		
//	//	facultyLessonsService.addFacultyLessons(facultyLessons);
//		return getFacultyLessonsItems();
//	}
	
	private ModelAndView getFacultyLessonsItems() {
		ModelAndView map = new ModelAndView("redirect:/add_lesson_to_faculty");
		map.addObject("add_lesson_to_faculty", facultyLessonsService.getAll());
		return map;		
	}
	
}
