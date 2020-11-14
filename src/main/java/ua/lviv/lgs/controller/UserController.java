package ua.lviv.lgs.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.UserDTOHelper;
import ua.lviv.lgs.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private FacultyService facultyService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {		
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registration(@RequestParam MultipartFile imgFile, @RequestParam String password, 
			@RequestParam String passwordConfirm, @RequestParam String firstName, 
			@RequestParam String lastName, @RequestParam String email) throws IOException {
				
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
		
		ModelAndView map = new ModelAndView("user");
		map.addObject("faculties", facultyService.getAllFaculty());	    	
        return map;
	}

	
}
