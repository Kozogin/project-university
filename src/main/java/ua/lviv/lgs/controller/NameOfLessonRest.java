package ua.lviv.lgs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/gradesScript")

public class NameOfLessonRest {

	private static int facultyIdSelectInt;

	@RequestMapping(value = "/{facultyIdSelect}", method = RequestMethod.GET)
	public ModelAndView lessonsScript(@PathVariable(value = "facultyIdSelect", required = false) String facultyIdSelect, 
			ModelMap model) {
		
		System.out.println("");
		System.out.println(" lessons get222 ---------------------- " + facultyIdSelect);
		System.out.println("");

		facultyIdSelectInt = Integer.parseInt(facultyIdSelect);
			
		ModelAndView map = new ModelAndView("redirect:/add_lesson_to_faculty");

		return map;		
	}

	public static int getFacultyIdSelectInt() {
		return facultyIdSelectInt;
	}

	public static void setFacultyIdSelectInt(int facultyIdSelectInt) {
		NameOfLessonRest.facultyIdSelectInt = facultyIdSelectInt;
	}	

}
