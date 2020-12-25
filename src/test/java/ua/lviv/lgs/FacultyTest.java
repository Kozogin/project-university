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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.service.FacultyService;


@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
@SpringBootTest
@ContextConfiguration(classes = {Application.class})
public class FacultyTest {
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private FacultyRepository facultyRepository;
		
	@Before
	public void beforeTest() {
		Faculty faculty = new Faculty();
		faculty.setName("before");		
		facultyRepository.save(faculty);
	}
	
	@Test	
	public void testSaveFaculty()  {
				
		List<Faculty> facylties = facultyService.getAllFaculty();
		assertThat(facylties, hasSize(1));		
		
		Faculty faculty = new Faculty();
		faculty.setName("f");
		
		facultyService.save(faculty);		
		
		Faculty faculty2 = new Faculty();
		faculty2.setName("f2");
		facultyRepository.save(faculty2);
		
		facylties = facultyService.getAllFaculty();
		assertThat(facylties, hasSize(3));
		
		Faculty facultyFromDb = facylties.get(1);
		assertTrue(facultyFromDb.getName().equals(faculty.getName()));
		
		
		//findByFacultyId(id)
		Faculty faculty3 = facultyService.getAllFaculty().get(2);
		assertTrue(facultyService.findByFacultyId(
				faculty3.getFacultyId()).getName() == "f2");
	}
	
	

}
