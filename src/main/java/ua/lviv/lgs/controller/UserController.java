package ua.lviv.lgs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Applicant;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.FacultyLessons;
import ua.lviv.lgs.domain.NameOfLesson;
import ua.lviv.lgs.domain.Point;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.FacultyLessonsService;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.PointService;
import ua.lviv.lgs.service.UserDTOHelper;
import ua.lviv.lgs.service.UserService;

@Controller
public class UserController {

	private Faculty choiseFaculty = new Faculty();
	private List<FacultyLessons> lessonThisFaculty = new ArrayList<>();
	
	@Autowired
	private UserService userService;

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private FacultyLessonsService facultyLessonsService;
	
	@Autowired
	private PointService pointService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registration(@RequestParam MultipartFile imgFile, @RequestParam String password,
			@RequestParam String passwordConfirm, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email) throws IOException {

		userService.save(UserDTOHelper.createEntity(imgFile, password, passwordConfirm, firstName, lastName, email));

		return new ModelAndView("redirect:/reg_succeess");
	}

	@RequestMapping(value = "/reg_succeess", method = RequestMethod.GET)
	public ModelAndView regSucceess() {

		User lastUser = userService.getLastRegistrationUser();

		if (lastUser.getAssignedId() == "") {
			return new ModelAndView("login");
		}

		ModelAndView map = new ModelAndView("reg_succeess");
		map.addObject("lastUser", lastUser);
		return map;
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		return "login";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String welcomeAdmin(Model model) {
		return "admin";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView welcome(ModelMap model, Authentication authentication) {

		String role = authentication.getAuthorities().stream().findFirst().orElse(null).toString();

		if (role.equals("ROLE_ADMIN")) {
			ModelAndView map = new ModelAndView("admin");
			map.addObject("users", userService.findAllApplicant());
			return map;
		}

		//List<FacultyLessons> lessonThisFaculty = new ArrayList<>();

		try {
			if (choiseFaculty.getFacultyId() != null) {
				lessonThisFaculty = facultyLessonsService.getAllThisFaculty(choiseFaculty.getFacultyId());
			}

		} catch (Exception e) {
		}

		ModelAndView map = new ModelAndView("user");
		List<Faculty> allAndChoiseFaculty = new ArrayList<>();
		allAndChoiseFaculty.add(choiseFaculty);
		allAndChoiseFaculty.addAll(facultyService.getAllFaculty());		

		map.addObject("faculties", allAndChoiseFaculty);
		map.addObject("selectFaculty", new Faculty());
		map.addObject("lessonThisFaculty", lessonThisFaculty);

		return map;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView addFacultyLessons(@ModelAttribute("selectFaculty") Faculty faculty) {

		try {
			if (faculty.getFacultyId() != null) {
				choiseFaculty = new Faculty(facultyService.findByFacultyId(faculty.getFacultyId()));
			}
		} catch (Exception e) {
		}
		ModelAndView map = new ModelAndView("redirect:/user");

		return map;
	}	
	
	@RequestMapping(value = "/userball", method = RequestMethod.POST)
	public ModelAndView userPointPost(
			Authentication authentication,
			@RequestParam String ballgpa,
			@RequestParam (value="ball") String [] ball
			) throws IOException {
		
		System.out.println("User Point Contr -- POST  " + ballgpa);	
		
		for (int i = 0; i < ball.length; i++) {
			System.out.println(ball[i]);
		}
		
		int i = 0;
		Applicant aplicant = new Applicant(
				userService.findByAssignedId(authentication.getName()).get(), 
				choiseFaculty);
		
		for (Iterator<FacultyLessons> iterator = lessonThisFaculty.iterator(); 
				iterator.hasNext();) {
			FacultyLessons facultyLessons = (FacultyLessons) iterator.next();
			NameOfLesson lesson = facultyLessons.getNameOfLessons();
						
			
			
			//try {				
				
				System.out.println("aplicant " + aplicant);
				System.out.println("lesson " + lesson);
				System.out.println("ball " + ball[i]);
				System.out.println("point" + new Point(lesson, aplicant, Double.parseDouble(ball[i])));
				
				pointService.save(new Point(
						lesson, 
						aplicant,
						Double.parseDouble(ball[i])));
			//} catch (Exception e) {}
		
				i++;
		}
		
		
		return new ModelAndView("redirect:/user");
	}

}
