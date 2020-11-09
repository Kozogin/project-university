package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.NameOfLessonRepository;
import ua.lviv.lgs.domain.NameOfLesson;

@Service
public class NameOfLessonService {
	
	@Autowired
	private NameOfLessonRepository nameOfLessonRepository;
	
	public void save(NameOfLesson nameOfLesson) {
		nameOfLessonRepository.save(nameOfLesson);
	}
	
	public NameOfLesson findByLessonId(Integer lessonId) {
		return nameOfLessonRepository.findByLessonId(lessonId);		
	}
	
	public List<NameOfLesson> getAllLesson() {
		return nameOfLessonRepository.findAll();		
	}

}
