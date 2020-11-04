package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.FacultyLessons;

@Repository
public interface FacultyLessonsRepository extends JpaRepository<FacultyLessons, Integer>{
	
}
