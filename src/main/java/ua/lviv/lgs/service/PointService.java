package ua.lviv.lgs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.PointRepository;
import ua.lviv.lgs.domain.Point;

@Service
public class PointService {
	
	@Autowired
	private PointRepository pointRepository;
	
	public void save (Point point) {
		pointRepository.save(point);
	}

}
