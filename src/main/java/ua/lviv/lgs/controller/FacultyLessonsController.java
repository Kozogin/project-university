package ua.lviv.lgs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.FacultyLessons;
import ua.lviv.lgs.domain.NameOfLesson;
import ua.lviv.lgs.service.FacultyLessonsService;
import ua.lviv.lgs.service.FacultyService;

@Controller
public class FacultyLessonsController {

	private Faculty choiseFaculty = new Faculty();

	@Autowired
	private FacultyLessonsService facultyLessonsService;

	@Autowired
	private FacultyService facultyService;

	@RequestMapping(value = "/add_lesson_to_faculty", method = RequestMethod.GET)
	public ModelAndView welcome(ModelMap model) {

		List<NameOfLesson> nameOfLesson = new ArrayList<>();

		try {
			if (choiseFaculty.getFacultyId() != null) {
				nameOfLesson = facultyLessonsService.getLessonsOfThisFaculty(choiseFaculty.getFacultyId());
			}

		} catch (Exception e) {
		}

		ModelAndView map = new ModelAndView("add_lesson_to_faculty");
		List<Faculty> allAndChoiseFaculty = new ArrayList<>();
		allAndChoiseFaculty.add(choiseFaculty);
		allAndChoiseFaculty.addAll(facultyService.getAllFaculty());

		map.addObject("faculties", allAndChoiseFaculty);
		map.addObject("selectFaculty", new Faculty());
		map.addObject("nameOfLesson", nameOfLesson);

		return map;
	}

	@RequestMapping(value = "/add_lesson_to_faculty", method = RequestMethod.POST)
	public ModelAndView addFacultyLessons(@ModelAttribute("selectFaculty") Faculty faculty, NameOfLesson lesson) {

		try {
			if (faculty.getFacultyId() != null) {
				choiseFaculty = new Faculty(facultyService.findByFacultyId(faculty.getFacultyId()));
			}
		} catch (Exception e) {
		}
		ModelAndView map = new ModelAndView("redirect:/add_lesson_to_faculty");

		return map;
	}

	@RequestMapping(value = "/add_lesson_to_faculty_del", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam String facultyLessonsId, ModelMap model) throws IOException {

		//facultyLessonsService.delete(new FacultyLessons(Integer.parseInt(facultyLessonsId.replaceAll("\\s", ""))));
		
		System.out.println(facultyLessonsId);
		
		
		
		List<NameOfLesson> nameOfLesson = new ArrayList<>();

		try {
			if (choiseFaculty.getFacultyId() != null) {
				nameOfLesson = facultyLessonsService.getLessonsOfThisFaculty(choiseFaculty.getFacultyId());
			}

		} catch (Exception e) {
		}
		
		

		ModelAndView map = new ModelAndView("add_lesson_to_faculty");
		List<Faculty> allAndChoiseFaculty = new ArrayList<>();
		allAndChoiseFaculty.add(choiseFaculty);
		allAndChoiseFaculty.addAll(facultyService.getAllFaculty());

		map.addObject("faculties", allAndChoiseFaculty);
		map.addObject("selectFaculty", new Faculty());
		map.addObject("nameOfLesson", nameOfLesson);

		return map;
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

}
