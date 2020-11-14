package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.FacultyLessonsRepository;
import ua.lviv.lgs.domain.FacultyLessons;

@Service
public class FacultyLessonsService {
	
	@Autowired
	private FacultyLessonsRepository facultyLessonsRepository;
	
	public List<FacultyLessons> getAll(){
		return facultyLessonsRepository.findAll();
	}
	
	public void delete(FacultyLessons facultyLessons) {
		facultyLessonsRepository.delete(facultyLessons);
	}
	
	public void addFacultyLessons(FacultyLessons facultyLessons) {
		facultyLessonsRepository.save(facultyLessons);
	}
	
}
