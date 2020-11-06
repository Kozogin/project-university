package ua.lviv.lgs.service;

import java.util.Date;
import java.util.Optional;

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

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;


    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
        user.setRole(Role.ROLE_USER);
        user.setPurchaseDate(new Date());
        user.setAssignedId("ID" + new Date().toString());
        userRepository.save(user);
    }
    
    public Optional<User> findByAssignedId(String assignedId) {    	
		return userRepository.findByAssignedId(assignedId);    	
    }

}