package ua.lviv.lgs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.NameOfLesson;

@Repository
public interface NameOfLessonRepository extends JpaRepository<NameOfLesson, Integer>{
	
	NameOfLesson findByLessonId(Integer lessonId);
	
	//**************
	List<NameOfLesson> findByNameLike(String nameLike);
	
}
