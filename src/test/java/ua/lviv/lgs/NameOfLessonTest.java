package ua.lviv.lgs;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.dao.NameOfLessonRepository;
import ua.lviv.lgs.domain.NameOfLesson;
import ua.lviv.lgs.service.NameOfLessonService;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {Application.class})
public class NameOfLessonTest {
	
	@Autowired
	private NameOfLessonService nameOfLessonService;
	
	@Autowired
	private NameOfLessonRepository nameOfLessonRepository;
	
	@Before
	public void beforeTest() {
		NameOfLesson nameOfLesson = new NameOfLesson();
		nameOfLesson.setName("before");		
		nameOfLessonRepository.save(nameOfLesson);
	}
	
	@Test	
	public void testSaveNameOfLesson()  {
				
		List<NameOfLesson> nameOfLessons = nameOfLessonService.getAllLesson();
		assertThat(nameOfLessons, hasSize(1));
		
		NameOfLesson nameOfLesson = new NameOfLesson();
		nameOfLesson.setName("lesson2");		
		nameOfLessonService.save(nameOfLesson);		
		
		NameOfLesson nameOfLesson2 = new NameOfLesson();
		nameOfLesson2.setName("lesson3");
		nameOfLessonRepository.save(nameOfLesson2);
		
		nameOfLessons = nameOfLessonService.getAllLesson();
		assertThat(nameOfLessons, hasSize(3));
		
		NameOfLesson nameOfLessonFromDb = nameOfLessons.get(2);
		assertTrue(nameOfLessonFromDb.getName().equals(nameOfLesson2.getName()));
		
		//findByLessonId()
		NameOfLesson nameOfLesson3 =  nameOfLessonService.getAllLesson().get(0);
		assertTrue(nameOfLessonService.findByLessonId(
				nameOfLesson3.getLessonId()
				).getName() == "before");		
		
	}

}
