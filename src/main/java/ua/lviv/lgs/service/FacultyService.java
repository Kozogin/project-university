package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.domain.Faculty;

@Service
public class FacultyService {
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	public void save(Faculty faculty) {
		facultyRepository.save(faculty);
	}
	
	public Faculty findByFacultyId(Integer facultyId){
		return facultyRepository.findByFacultyId(facultyId);		
	}
	
	public List<Faculty> getAllFaculty(){
		return facultyRepository.findAll();		
	}

}
