package ua.lviv.lgs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.dao.ApplicantRepository;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.Applicant;
import ua.lviv.lgs.domain.Role;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.ApplicantService;
import ua.lviv.lgs.service.UserService;


@RunWith(SpringRunner.class)
//@DataJpaTest
@ActiveProfiles(profiles = "test")
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
	
	/*  UsertService   ---------------------------------      */
	
	@Test(timeout = 19500)	
	public void test1SaveUser()  {		
		
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

		User userFromDb = userRepository.findAll().get(0);
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
		
		users = userService.getAllUsers();
		assertThat(users, hasSize(3));	
				
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
	public void test2FindByAssignedId()  {
		assertTrue(userService.findByAssignedId("id1").get().getEmail().equals("1@gmail.com"));	
		assertFalse(userService.findByAssignedId("id1").get().getEmail().equals("91@gmail.com"));
	
	}
	
	@Test	
	public void test3FindAllApplicant()  {
		List<User> userss = userService.findAllApplicant();
		List<User> adminRole = userss.stream().filter(usert -> usert.getRole().equals(Role.ROLE_ADMIN)).collect(Collectors.toList());
		List<User> userRole = userss.stream().filter(usert -> usert.getRole().equals(Role.ROLE_USER)).collect(Collectors.toList());
		List<User> admin = userService.getAllUsers().stream().filter(usert -> usert.getRole().equals(Role.ROLE_ADMIN)).collect(Collectors.toList());
				
		assertTrue(adminRole.size() == 0);
		assertTrue(userRole.size() == 2);
		assertTrue(admin.size() == 1);
	}

	
	@Test	
	public void test4GetLastRegistrationUser()  {	
		assertTrue(userService.getLastRegistrationUser().getFirstName().equals("100"));
		assertFalse(userService.getLastRegistrationUser().getFirstName().equals("100"));
	}

	/*  ApplicantService   ---------------------------------      */
	
	@Test	
	public void test5SaveApplicant()  {
		List<Applicant> applicants = applicantService.getAllApplicant();
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
	}
	
	@Test	
	public void test6FindApplicant()  {
		Applicant applicantFromDb = applicantService.getAllApplicant().get(1);
		assertTrue(applicantService.findApplicant(
				applicantFromDb.getApplicantId()
				).getBallgpa() == 8.005);
	}


}
