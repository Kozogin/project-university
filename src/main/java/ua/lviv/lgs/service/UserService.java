package ua.lviv.lgs.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.Role;
import ua.lviv.lgs.domain.User;

@Service
public class UserService{
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
    @Autowired
    private UserRepository userRepository;
    private User lastUser;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;


    public void save(User user) {
    	
    	logger.info("Register new user {} : " + user); 
    	
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
        user.setRole(Role.ROLE_USER);
        user.setPurchaseDate(new Date());        
        user.setAssignedId(generateAssignedId());
        
        lastUser = new User(user);       
        userRepository.save(user);
    }
    
    public Optional<User> findByAssignedId(String assignedId) { 
    	
    	logger.info("find Optional<User> by assigned id {} : " + assignedId); 
		return userRepository.findByAssignedId(assignedId);    	
    }  
    
    public List<User> getAllUsers(){
    	
    	logger.info("get all users {} : ");
		return userRepository.findAll();    	
    }
    
    public List<User> findAllApplicant(){
    	
    	logger.info("find List<User> all applicant {} : ");
    	try {
		return userRepository.findAll().stream()
				.filter(user -> user.getRole() == Role.ROLE_USER)
				.collect(Collectors.toList());  
    	} catch (Exception e) {    		
    	}
		return null;
    }
    
        
    public User getLastRegistrationUser(){
    	
    	logger.info("get last registration user {} : ");
    	
    	User lastSendUser = new User(lastUser);
    	lastUser = new User("","","","","",Role.ROLE_USER,new Date());
		return lastSendUser;    	
    }
    
    private String generateAssignedId() {
    	
    	logger.info("private generate assigned id {} : ");
    	
    	LocalDate today = LocalDate.now();
		LocalTime time = LocalTime.now();
    	String year = Integer.toString(today.getYear());
    	String mounth = Integer.toString(today.getMonthValue());
    	String day = Integer.toString(today.getDayOfMonth());
    	String hour = Integer.toString(time.getHour());
    	String minute = Integer.toString(time.getMinute());
    	String second = Integer.toString(time.getSecond());
    	
    	String assignedIdGenerated = "ID" + year + mounth + day +hour + minute + second + "00";
				
		return assignedIdGenerated;    	
    }

}