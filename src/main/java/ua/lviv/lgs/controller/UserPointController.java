package ua.lviv.lgs.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserPointController {
	
	@RequestMapping(value = "/userball", method = RequestMethod.GET)
	public String registration(Model model) {
		System.out.println("User Point Contr -------------------------------------- GET");
		return "user";
	}
	
	@RequestMapping(value = "/userball", method = RequestMethod.POST)
	public ModelAndView registration(
			@RequestParam String ballgpa,
			@RequestParam String ball1,
			@RequestParam String ball2
			) throws IOException {
		
		System.out.println("User Point Contr -- POST  " + ballgpa + " -- " + ball1 + " -- " + ball2);	
		
		return new ModelAndView("redirect:/user");
	}

}
