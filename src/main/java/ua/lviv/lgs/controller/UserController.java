package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Applicant;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;

@Controller
public class UserController {
	
    @Autowired
    private UserService userService;



    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);

        return "redirect:/reg_succeess";
    }
    
    
    @RequestMapping(value ="/reg_succeess", method = RequestMethod.GET)
	public ModelAndView regSucceess() {
    	
    	User lastUser = userService.getLastRegistrationUser();
    	if(lastUser != null) {
    		ModelAndView map = new ModelAndView("reg_succeess");
    		map.addObject("lastUser", lastUser);
    		return map;
    	}
		
		return null;
	}    
    
    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
//        if (error != null)
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
    
    
    @RequestMapping(value ="/admin", method = RequestMethod.GET)
    public String welcomeAdmin(Model model) {     	
        return "admin";
    }
    
    @RequestMapping(value ="/user", method = RequestMethod.GET)
    public String welcome(ModelMap model, Authentication authentication) {    	
    	
    	String role = authentication.getAuthorities().stream().findFirst().orElse(null).toString();
    	if(role.equals("ROLE_ADMIN")) {
    		return "admin";
    	}
    	model.addAttribute("applicantForm", new Applicant());
        return "user";
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String applicationSubmission(@ModelAttribute("applicantForm") Applicant applicantForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "user";
        }
       // userService.save(applicantForm);

        return "redirect:/reg_succeess";
    }
    
    //------------------------------------------------------------------
    @RequestMapping(value ="/create_faculty", method = RequestMethod.GET)
    public String createFaculty(Model model) { 
    	model.addAttribute("createFacultyForm", new Faculty());
        return "create_faculty";
    }
    
    @RequestMapping(value = "/create_faculty", method = RequestMethod.POST)
    public String createFacultyPost(@ModelAttribute("createFacultyForm") Faculty createFacultyForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "user";
        }
       // userService.save(applicantForm);

        return "redirect:/user";
    }
    
    @RequestMapping(value ="/faculties", method = RequestMethod.GET)
    public String faculties() {     	
        return "faculties";
    }
    
    @RequestMapping(value ="/create_lesson", method = RequestMethod.GET)
    public String createLesson(Model model) {
    	//model.addAttribute("createNameOfLessonForm", new NameOfLesson());
        return "create_lesson";
    }
    
//    @RequestMapping(value = "/create_faculty", method = RequestMethod.POST)
//    public String createLesson(@ModelAttribute("createNameOfLessonForm") Faculty createNameOfLessonForm, BindingResult bindingResult, Model model) {
//
//        if (bindingResult.hasErrors()) {
//            return "user";
//        }
//       // userService.save(applicantForm);
//
//        return "redirect:/user";
//    }
    
    @RequestMapping(value ="/lessons", method = RequestMethod.GET)
    public String lessons() {     	
        return "lessons";
    }
    
    @RequestMapping(value ="/add_lesson_to_faculty", method = RequestMethod.GET)
    public String addLessonToFaculty() {     	
        return "add_lesson_to_faculty";
    }
    
    
    
    
    
    
    
    
}
