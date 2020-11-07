package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.service.FacultyService;

@Controller
public class FacultyController {
	
	@Autowired
    private FacultyService facultyService;
	
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
	        facultyService.save(createFacultyForm);

	        return "redirect:/create_faculty";
	    }
	    
	    @RequestMapping(value ="/faculties", method = RequestMethod.GET)
	    public String faculties() {     	
	        return "faculties";
	    }

}
