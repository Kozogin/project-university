package ua.lviv.lgs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.dao.ApplicantRepository;
import ua.lviv.lgs.dao.FacultyLessonsRepository;
import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.dao.NameOfLessonRepository;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.Applicant;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.FacultyLessons;
import ua.lviv.lgs.domain.NameOfLesson;
import ua.lviv.lgs.domain.Role;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.ApplicantService;
import ua.lviv.lgs.service.FacultyLessonsService;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.NameOfLessonService;
import ua.lviv.lgs.service.UserService;


@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
@ContextConfiguration(classes = {Application.class})
public class ApplicationTests {
	
	@Autowired
	private UserService userService;
		
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
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
	
	/*  UsertService   ---------------------------------      */
	
	@Before
	public void beforeTest() {
		
	}
	
	@Test	
	public void testSaveUser()  {		
		
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setAssignedId("id1");
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setRole(Role.ROLE_USER);

		userRepository.save(user);

		users = userService.getAllUsers();
		assertThat(users, hasSize(1));		

		User userFromDb = users.get(0);
		assertTrue(userFromDb.getAssignedId().equals(user.getAssignedId()));
		assertTrue(userFromDb.getEmail().equals(user.getEmail()));
		assertTrue(userFromDb.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDb.getLastName().equals(user.getLastName()));
		assertTrue(userFromDb.getRole().equals(user.getRole()));
		
		User user2 = new User();
		user2.setAssignedId("admin");
		user2.setEmail("admin@gmail.com");
		user2.setFirstName("9");
		user2.setLastName("9");
		user2.setPassword("9");
		user2.setPasswordConfirm("9");
		user2.setRole(Role.ROLE_ADMIN);

		userRepository.save(user2);
		
		User user3 = new User();
		
		user3.setEmail("id100");
		user3.setFirstName("100");
		user3.setLastName("100");
		user3.setPassword("100");
		user3.setPasswordConfirm("100");
		
		userService.save(user3);
		
		//findByAssignedId("id")
		assertTrue(userService.findByAssignedId("id1").get().getEmail().equals("1@gmail.com"));	
		assertFalse(userService.findByAssignedId("id1").get().getEmail().equals("91@gmail.com"));
	
		
		//findAllApplicant()
		List<User> userss = userService.findAllApplicant();
		List<User> adminRole = userss.stream().filter(usert -> usert.getRole().equals(Role.ROLE_ADMIN)).collect(Collectors.toList());
		List<User> userRole = userss.stream().filter(usert -> usert.getRole().equals(Role.ROLE_USER)).collect(Collectors.toList());
		List<User> admin = userService.getAllUsers().stream().filter(usert -> usert.getRole().equals(Role.ROLE_ADMIN)).collect(Collectors.toList());
		
		assertTrue(adminRole.size() == 0);
		assertTrue(userRole.size() != 0);
		assertTrue(admin.size() == 1);
		
		
		//isExist(user)
		User user5 = new User();
		user5.setAssignedId("id2000");
		user5.setEmail("2000@gmail.com");
		user5.setFirstName("2000");
		user5.setLastName("2000");
		user5.setPassword("2000");
		user5.setPasswordConfirm("2000");
		user5.setRole(Role.ROLE_USER);
		
		assertTrue(applicantService.isExist(user5));			
	}	

	
	@Test	
	public void testGetLastRegistrationUser()  {	
		assertTrue(userService.getLastRegistrationUser().getFirstName().equals("100"));
		assertFalse(userService.getLastRegistrationUser().getFirstName().equals("100"));
	}

	/*  ApplicantService   ---------------------------------      */
	
	@Test	
	public void testSaveApplicant()  {
		List<Applicant> applicants = new ArrayList<>();
		assertThat(applicants, hasSize(0));
		
		Applicant applicant = new Applicant();
		applicant.setBallgpa(10.58);
		applicant.setChecked(true);
		applicantService.save(applicant);		
		
		Applicant applicant2 = new Applicant();
		applicant2.setBallgpa(8.005);
		applicant2.setChecked(false);		
		applicantRepository.save(applicant2);
		
		applicants = applicantService.getAllApplicant();
		assertThat(applicants, hasSize(2));
		
		Applicant applicantFromDb = applicantService.getAllApplicant().get(1);
		assertTrue(applicantFromDb.getBallgpa().equals(applicant2.getBallgpa()));
		assertTrue(applicantFromDb.getChecked().equals(applicant2.getChecked()));
		
		
		//findApplicant()
		assertTrue(applicantService.findApplicant(
				applicantFromDb.getApplicantId()
				).getBallgpa() == 8.005);
		
	}
	
	/*  FacultyService   ---------------------------------      */
	
	@Test	
	public void testSaveFaculty()  {
				
		List<Faculty> facylties = new ArrayList<>();
		assertThat(facylties, hasSize(0));
		
		Faculty faculty = new Faculty();
		faculty.setName("f");
		
		facultyService.save(faculty);		
		
		Faculty faculty2 = new Faculty();
		faculty2.setName("f2");
		facultyRepository.save(faculty2);
		
		facylties = facultyService.getAllFaculty();
		assertThat(facylties, hasSize(2));
		
		Faculty facultyFromDb = facylties.get(1);
		assertTrue(facultyFromDb.getName().equals(faculty2.getName()));
		
		
		//findByFacultyId(id)
		Faculty faculty3 = facultyService.getAllFaculty().get(0);
		assertTrue(facultyService.findByFacultyId(
				faculty3.getFacultyId()).getName() == "f");
	}
	

		/*  NameOfLessonService   ---------------------------------      */
	
	@Test	
	public void testSaveNameOfLesson()  {
				
		List<NameOfLesson> nameOfLessons = new ArrayList<>();
		assertThat(nameOfLessons, hasSize(0));
		
		NameOfLesson nameOfLesson = new NameOfLesson();
		nameOfLesson.setName("lesson");
		
		nameOfLessonService.save(nameOfLesson);		
		
		NameOfLesson nameOfLesson2 = new NameOfLesson();
		nameOfLesson2.setName("lesson2");
		nameOfLessonRepository.save(nameOfLesson2);
		
		nameOfLessons = nameOfLessonService.getAllLesson();
		assertThat(nameOfLessons, hasSize(2));
		
		NameOfLesson nameOfLessonFromDb = nameOfLessons.get(1);
		assertTrue(nameOfLessonFromDb.getName().equals(nameOfLesson2.getName()));
		
		//findByLessonId()
		NameOfLesson nameOfLesson3 =  nameOfLessonService.getAllLesson().get(0);
		assertTrue(nameOfLessonService.findByLessonId(
				nameOfLesson3.getLessonId()
				).getName() == "lesson");		
		
	}
	
		
//	@Test	
//	public void testSaveFacultyLessons()  {
//		
//		Faculty faculty = new Faculty("faculty test");
//		NameOfLesson nameOfLesson = new NameOfLesson("lesson test");
//		
//		FacultyLessons facultyLessons = new FacultyLessons();
//		facultyLessons.setFacultys(faculty);
//		facultyLessons.setNameOfLessons(nameOfLesson);
//		
//		facultyLessonsService.addFacultyLessons(facultyLessons);
//		
//	}
	



}
