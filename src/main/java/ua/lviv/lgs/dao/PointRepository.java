package ua.lviv.lgs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Applicant;
import ua.lviv.lgs.domain.Point;

@Repository
public interface PointRepository extends JpaRepository<Point, Integer>{
	
	List<Point> findByApplicant(Applicant applicant);
	
}
