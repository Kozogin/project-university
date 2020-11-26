package ua.lviv.lgs.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.domain.Faculty;

@Service
public class FacultyService {
	
	private Logger logger = LoggerFactory.getLogger(FacultyService.class);
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	public void save(Faculty faculty) {
		
		logger.info("Create faculty {} : " + faculty);
		facultyRepository.save(faculty);
	}
	
	public Faculty findByFacultyId(Integer facultyId){
		
		logger.info("find faculty by facultyId {} : " + facultyId);
		return facultyRepository.findByFacultyId(facultyId);		
	}
	
	public List<Faculty> getAllFaculty(){
		
		logger.info("List<Faculty> get all faculty {} : ");
		return facultyRepository.findAll();		
	}

}
