package ua.lviv.lgs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.Applicant;
import ua.lviv.lgs.domain.Role;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.ApplicantService;
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
	
	
	/*  UsertService                                                */
	
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
	}
	
	@Test	
	public void testFindByAssignedId()  {	
		assertTrue(userService.findByAssignedId("id1").get().getEmail().equals("1@gmail.com"));	
		assertFalse(userService.findByAssignedId("id1").get().getEmail().equals("91@gmail.com"));
	}
	
	@Test	
	public void findAllApplicant()  {	
		List<User> users = userService.findAllApplicant();
		List<User> adminRole = users.stream().filter(user -> user.getRole().equals(Role.ROLE_ADMIN)).collect(Collectors.toList());
		List<User> userRole = users.stream().filter(user -> user.getRole().equals(Role.ROLE_USER)).collect(Collectors.toList());
		List<User> admin = userService.getAllUsers().stream().filter(user -> user.getRole().equals(Role.ROLE_ADMIN)).collect(Collectors.toList());
		
		assertTrue(adminRole.size() == 0);
		assertTrue(userRole.size() != 0);
		assertTrue(admin.size() == 1);
	}
	
	@Test	
	public void testGetLastRegistrationUser()  {	
		assertTrue(userService.getLastRegistrationUser().getFirstName().equals("100"));
		assertFalse(userService.getLastRegistrationUser().getFirstName().equals("100"));
	}

	/*  ApplicantService                                                */
	
	@Test	
	public void testSave()  {
		List<Applicant> applicants = new ArrayList<>();
		assertThat(applicants, hasSize(0));
		
		Applicant applicant = new Applicant();
		applicant.setBallgpa(10.58);
		applicant.setChecked(true);
		applicantService.save(applicant);
		
		applicants = applicantService.getAllApplicant();
		assertThat(applicants, hasSize(1));
		
//		Applicant applicantFromDb = 
//		User userFromDb = users.get(0);
//		assertTrue(userFromDb.getAssignedId().equals(user.getAssignedId()));
		
	}



}
