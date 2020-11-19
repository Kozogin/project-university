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
	public String userPoint(Model model) {
		System.out.println("User Point Contr -------------------------------------- GET");
		return "user";
	}
	
	@RequestMapping(value = "/userball", method = RequestMethod.POST)
	public ModelAndView userPointPost(
			@RequestParam String ballgpa,
			@RequestParam (value="ball") String [] ball
			) throws IOException {
		
		System.out.println("User Point Contr -- POST  " + ballgpa);	
		
		for (int i = 0; i < ball.length; i++) {
			System.out.println(ball[i]);
		}
		
		return new ModelAndView("redirect:/user");
	}

}
