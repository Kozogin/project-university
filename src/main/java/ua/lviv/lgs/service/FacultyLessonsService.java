package ua.lviv.lgs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.el.stream.Stream;

import ua.lviv.lgs.dao.FacultyLessonsRepository;
import ua.lviv.lgs.dao.NameOfLessonRepository;
import ua.lviv.lgs.domain.FacultyLessons;
import ua.lviv.lgs.domain.NameOfLesson;

@Service
public class FacultyLessonsService {
	
	@Autowired
	private FacultyLessonsRepository facultyLessonsRepository;
	
	@Autowired
	private NameOfLessonRepository nameOfLessonRepository;
	
	public List<FacultyLessons> getAll(){
		return facultyLessonsRepository.findAll();
	}
	
	public List<FacultyLessons> getAllThisFaculty(Integer facultyId){
		return facultyLessonsRepository.findAll()
				.stream()
				.filter(faculeson -> faculeson.getFacultys().getFacultyId() == facultyId)
				.collect(Collectors.toList());
	}
	
	
	public List<NameOfLesson> getLessonsOfThisFaculty(Integer facultyId){
		
		try {
			List<FacultyLessons> lessonsOfThisFaculty =
			facultyLessonsRepository.findAll()
					.stream()
					.filter(faculeson -> faculeson.getFacultys().getFacultyId() == facultyId)
					.collect(Collectors.toList());
			
			
			List<NameOfLesson> lessonFaculty = new ArrayList<>();
			
					
			for (FacultyLessons facultyLessons : lessonsOfThisFaculty) {
				lessonFaculty.add(nameOfLessonRepository.findByLessonId(facultyLessons.getNameOfLessons().getLessonId()));
			}
			
			return lessonFaculty;
		} catch(Exception e) {}	
		
		
		return null;
	}
	
	public void delete(FacultyLessons facultyLessons) {
		facultyLessonsRepository.delete(facultyLessons);
	}	
	
	public void addFacultyLessons(FacultyLessons facultyLessons) {
		facultyLessonsRepository.save(facultyLessons);
	}
	
}
