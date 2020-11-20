package ua.lviv.lgs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.PointRepository;
import ua.lviv.lgs.domain.Applicant;
import ua.lviv.lgs.domain.Point;
import ua.lviv.lgs.domain.User;

@Service
public class PointService {
	
	@Autowired
	private PointRepository pointRepository;
	
	public void save (Point point) {
		pointRepository.save(point);
	}
	
	public void delete(User user) {
		
		Applicant applicantss = user.getApplicantss();
		List<Point> listPoint = pointRepository.findAll().stream()
				.filter(point -> point.getApplicant().getApplicantId() == applicantss.getApplicantId())
				.collect(Collectors.toList());
		
		for (Point pointDelete : listPoint) {
			pointRepository.delete(pointDelete);
		}		

	}

}
