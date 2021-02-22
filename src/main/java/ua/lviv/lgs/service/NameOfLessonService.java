package ua.lviv.lgs.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.NameOfLessonRepository;
import ua.lviv.lgs.domain.NameOfLesson;

@Service
public class NameOfLessonService {
	
	private Logger logger = LoggerFactory.getLogger(NameOfLessonService.class);
	
	@Autowired
	private NameOfLessonRepository nameOfLessonRepository;
	
	public void save(NameOfLesson nameOfLesson) {
		
		logger.info("Create Lesson {} : " + nameOfLesson); 
		nameOfLessonRepository.save(nameOfLesson);
	}
	
	public NameOfLesson findByLessonId(Integer lessonId) {
		
		logger.info("find Lesson by lessonId {} : " + lessonId);
		return nameOfLessonRepository.findByLessonId(lessonId);		
	}
	
	public List<NameOfLesson> getAllLesson() {
		
		logger.info("List<NameOfLesson> get all lesson {} : "); 
		return nameOfLessonRepository.findAll();		
	}
	
	public List<NameOfLesson> findByNameLike(String nameLike){
		return nameOfLessonRepository.findByNameLike(nameLike);				
	}

}
