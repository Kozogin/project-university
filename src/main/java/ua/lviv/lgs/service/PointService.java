package ua.lviv.lgs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.PointRepository;
import ua.lviv.lgs.domain.Applicant;
import ua.lviv.lgs.domain.Point;
import ua.lviv.lgs.domain.User;

@Service
public class PointService {
	
	private Logger logger = LoggerFactory.getLogger(PointService.class);
	
	@Autowired
	private PointRepository pointRepository;
	
	public void save (Point point) {
		
		logger.info("Save new point {} : " + point); 		
		pointRepository.save(point);
	}
	
	public List<Point> findByApplicant(Applicant applicant){
				
		logger.info("Find by applicant List<Point> {} : " + applicant); 
		return pointRepository.findByApplicant(applicant);		
	}
	
	public void delete(User user) {
		
		logger.info("delete point by user {} : " + user);
		Applicant applicantss = user.getApplicantss();
		List<Point> listPoint = pointRepository.findAll().stream()
				.filter(point -> point.getApplicant().getApplicantId() == applicantss.getApplicantId())
				.collect(Collectors.toList());
		
		for (Point pointDelete : listPoint) {
			pointRepository.delete(pointDelete);
		}		

	}

}
