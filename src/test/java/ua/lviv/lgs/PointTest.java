package ua.lviv.lgs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.dao.NameOfLessonRepository;
import ua.lviv.lgs.dao.PointRepository;
import ua.lviv.lgs.domain.Applicant;
import ua.lviv.lgs.domain.NameOfLesson;
import ua.lviv.lgs.domain.Point;
import ua.lviv.lgs.service.ApplicantService;
import ua.lviv.lgs.service.PointService;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {Application.class})
public class PointTest {
	
	@Autowired
	private ApplicantService applicantService;	
	
	@Autowired
	private NameOfLessonRepository nameOfLessonRepository;
	
	@Autowired
	private PointService pointService;
	
	@Autowired
	private PointRepository pointRepository;
	
	@Test	
	public void testSavePoint()  {
		
		List<Applicant> applicants = applicantService.getAllApplicant();
		assertThat(applicants, hasSize(0));
		
		Applicant applicant = new Applicant();
		applicant.setBallgpa(10.58);
		applicant.setChecked(true);	
		
		
		NameOfLesson nameOfLesson = new NameOfLesson();
		nameOfLesson.setName("lesson1");		
		nameOfLessonRepository.save(nameOfLesson);				
			
		Point point = new Point();
		point.setApplicant(applicant);
		point.setBall(11d);
		point.setNameOfLesson(nameOfLesson);
		
		pointRepository.save(point);	
		
		//findByApplicant
		List<Point> findByApplicant = pointService.findByApplicant(applicant);
		assertThat(findByApplicant, hasSize(1));	
		assertTrue(findByApplicant.get(0).getBall().equals(point.getBall()));
		assertTrue(findByApplicant.get(0).getNameOfLesson().equals(point.getNameOfLesson()));
		
	}

}
