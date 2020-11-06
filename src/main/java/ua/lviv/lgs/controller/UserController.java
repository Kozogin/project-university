package ua.lviv.lgs.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

        return "redirect:/user";
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

//    @RequestMapping(value ="/user", method = RequestMethod.GET)
//    public String welcomeUser(Model model) { 
//        return "user";
//    }
    
    @RequestMapping(value ="/admin", method = RequestMethod.GET)
    public String welcomeAdmin(Model model) {     	
        return "admin";
    }
    
    @RequestMapping(value ="/user", method = RequestMethod.GET)
    public String welcome(ModelMap model, Authentication authentication) {
    	//System.out.println(authentication.getAuthorities().toString());
    	
    	Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    	
    	String role = null;
    	for (GrantedAuthority grantedAuthority : authorities) {
    		 role = grantedAuthority.toString();
		}
    	
    	if(role.equals("ROLE_ADMIN")) {
    		return "admin";
    	}    		
    	
        return "user";
    }
    
    
}
