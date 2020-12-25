package ua.lviv.lgs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.dao.FacultyLessonsRepository;
import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.dao.NameOfLessonRepository;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.FacultyLessons;
import ua.lviv.lgs.domain.NameOfLesson;
import ua.lviv.lgs.service.FacultyLessonsService;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.NameOfLessonService;


@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
@SpringBootTest
@ContextConfiguration(classes = {Application.class})
public class FacultyLessonsTest {
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	private NameOfLessonService nameOfLessonService;
	
	@Autowired
	private NameOfLessonRepository nameOfLessonRepository;
	
	@Autowired
	private FacultyLessonsService facultyLessonsService;
	
	@Autowired
	private FacultyLessonsRepository facultyLessonsRepository;	
	
	
	@Test	
	public void test1AddFacultyLessons()  {
		
			Faculty facultyb = new Faculty(); 
			facultyb.setName("before faculty");		
			facultyRepository.save(facultyb);
			
			Faculty facultyb2 = new Faculty(); 
			facultyb2.setName("before faculty two");		
			facultyRepository.save(facultyb2);
				
			NameOfLesson nameOfLessonb = new NameOfLesson();
			nameOfLessonb.setName("before lesson");		
			nameOfLessonRepository.save(nameOfLessonb);
			
			NameOfLesson nameOfLessonb2 = new NameOfLesson();
			nameOfLessonb2.setName("before lesson two");		
			nameOfLessonRepository.save(nameOfLessonb2);
		
		List<FacultyLessons> facultyLessonsThat = facultyLessonsRepository.findAll();
		assertThat(facultyLessonsThat, hasSize(0));
		
		Faculty faculty = facultyService.getAllFaculty().get(0);
		NameOfLesson nameOfLesson = nameOfLessonService.getAllLesson().get(0);
		
		FacultyLessons facultyLessons = new FacultyLessons();
		facultyLessons.setFacultys(faculty);
		facultyLessons.setNameOfLessons(nameOfLesson);
		
		facultyLessonsService.addFacultyLessons(facultyLessons);
		
		Faculty faculty2 = facultyService.getAllFaculty().get(1);
		NameOfLesson nameOfLesson2 = nameOfLessonService.getAllLesson().get(1);
		
		FacultyLessons facultyLessons2 = new FacultyLessons();
		facultyLessons2.setFacultys(faculty2);
		facultyLessons2.setNameOfLessons(nameOfLesson2);
		
		facultyLessonsService.addFacultyLessons(facultyLessons2);
		
		facultyLessonsThat = facultyLessonsRepository.findAll();
		assertThat(facultyLessonsThat, hasSize(2));
		
		List<FacultyLessons> facultyLessonsFromDb = facultyLessonsService.getAll();
		FacultyLessons FacultyLessonsFromDb1 = facultyLessonsFromDb.get(0);
		assertTrue(FacultyLessonsFromDb1.getFacultys().equals(faculty));
		assertTrue(FacultyLessonsFromDb1.getNameOfLessons().equals(nameOfLesson));
		
		FacultyLessons FacultyLessonsFromDb2 = facultyLessonsFromDb.get(1);
		assertTrue(FacultyLessonsFromDb2.getFacultys().equals(faculty2));
		assertTrue(FacultyLessonsFromDb2.getNameOfLessons().equals(nameOfLesson2));
		
		
		//testGetLessonsOfThisFaculty
		NameOfLesson nameOfLessonb4 = new NameOfLesson();
		nameOfLessonb4.setName("lesson2 before faculty");		
		nameOfLessonRepository.save(nameOfLessonb4);
		
		NameOfLesson nameOfLessonb3 = new NameOfLesson();
		nameOfLessonb3.setName("lesson3 before faculty");		
		nameOfLessonRepository.save(nameOfLessonb3);
		
		FacultyLessons fl = new FacultyLessons();
		fl.setFacultys(faculty);
		fl.setNameOfLessons(nameOfLessonb4);		
		facultyLessonsService.addFacultyLessons(fl);
		
		FacultyLessons fl2 = new FacultyLessons();
		fl2.setFacultys(faculty);
		fl2.setNameOfLessons(nameOfLessonb3);		
		facultyLessonsService.addFacultyLessons(fl2);
		
		
		Integer facultyId = facultyLessonsRepository.findAll().get(0)
				.getFacultys().getFacultyId();	
		
		assertTrue(facultyLessonsService.getLessonsOfThisFaculty(facultyId).size() == 3);
		
		//getAllThisFaculty
		assertTrue(facultyLessonsService.getAllThisFaculty(facultyId).size() == 3);
		
		//testDelete
		List<FacultyLessons> facultyLessonsFromDb4 = facultyLessonsService.getAll();
		FacultyLessons FacultyLessonsFromDb4 = facultyLessonsFromDb4.get(1);
		facultyLessonsService.delete(FacultyLessonsFromDb4);
		List<FacultyLessons> facultyLessonsThat4 = facultyLessonsRepository.findAll();
		assertThat(facultyLessonsThat4, hasSize(3));
				
	}	
	
//	@Test	
//	public void testGetLessonsOfThisFaculty() {
//		NameOfLesson nameOfLessonb = new NameOfLesson();
//		nameOfLessonb.setName("lesson2 before faculty");		
//		nameOfLessonRepository.save(nameOfLessonb);
//		
//		NameOfLesson nameOfLessonb3 = new NameOfLesson();
//		nameOfLessonb3.setName("lesson3 before faculty");		
//		nameOfLessonRepository.save(nameOfLessonb3);
//		
//		Integer facultyId = facultyLessonsRepository.findAll().get(0)
//				.getFacultys().getFacultyId();
//		
//		assertTrue(facultyLessonsService.getLessonsOfThisFaculty(facultyId).size() == 3);
//		
//	}
	
	
	
	

//	@Test	
//	public void testzDelete()  {
//		
//		List<FacultyLessons> facultyLessonsFromDb = facultyLessonsService.getAll();
//		FacultyLessons FacultyLessonsFromDb2 = facultyLessonsFromDb.get(1);
//		facultyLessonsService.delete(FacultyLessonsFromDb2);
//		List<FacultyLessons> facultyLessonsThat = facultyLessonsRepository.findAll();
//		assertThat(facultyLessonsThat, hasSize(1));
//		
//	}
		
	
	


}
