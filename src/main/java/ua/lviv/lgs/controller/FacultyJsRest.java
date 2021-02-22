package ua.lviv.lgs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/lessonsScript")

public class FacultyJsRest {
	
	private static int facultyIdSelectInt;
	
	@RequestMapping(value = "/{facultyIdSelect}", method = RequestMethod.GET)
	public String lessonsScript(@PathVariable(value = "facultyIdSelect", required = false) String facultyIdSelect) {		
    	
		//value = "number", required = false
    	System.out.println("");
    	System.out.println(" lessons get ---------------------- " + facultyIdSelect);
    	System.out.println("");
    	
    	facultyIdSelectInt = Integer.parseInt(facultyIdSelect);
    	
        return "lessons/view";
	}

	public static int getFacultyIdSelectInt() {
		return facultyIdSelectInt;
	}

	public static void setFacultyIdSelectInt(int facultyIdSelectInt) {
		FacultyJsRest.facultyIdSelectInt = facultyIdSelectInt;
	}
	
	

}
