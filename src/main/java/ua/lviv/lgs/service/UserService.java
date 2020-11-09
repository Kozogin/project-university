package ua.lviv.lgs.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.Role;
import ua.lviv.lgs.domain.User;

@Service
public class UserService{
	
    @Autowired
    private UserRepository userRepository;
    private User lastUser;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;


    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
        user.setRole(Role.ROLE_USER);
        user.setPurchaseDate(new Date());        
        user.setAssignedId(generateAssignedId());
        
        lastUser = new User(user);       
        userRepository.save(user);
    }
    
    public Optional<User> findByAssignedId(String assignedId) {    	
		return userRepository.findByAssignedId(assignedId);    	
    }  
    
    public List<User> getAllUsers(){
		return userRepository.findAll();    	
    }
    
    public List<User> findAllApplicant(){
    	try {
		return userRepository.findAll().stream()
				.filter(user -> user.getRole() == Role.ROLE_USER)
				.collect(Collectors.toList());  
    	} catch (Exception e) {    		
    	}
		return null;
    }
    
        
    public User getLastRegistrationUser(){
    	
    	User lastSendUser = new User(lastUser);
    	lastUser = new User("","","","","",Role.ROLE_USER,new Date());
		return lastSendUser;    	
    }
    
    private String generateAssignedId() {
    	
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