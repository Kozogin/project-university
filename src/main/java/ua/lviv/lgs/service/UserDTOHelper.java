package ua.lviv.lgs.service;

import java.io.IOException;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.domain.User;

public class UserDTOHelper {
	
	private static Logger logger = LoggerFactory.getLogger(UserDTOHelper.class);
	
	public static User createEntity(MultipartFile imgFile, String password, String passwordConfirm, 
			String firstName, String lastName, String email) throws IOException {
		
		logger.info("Register new user {} : "); 
		
		User user = new User();
		user.setPassword(password);
		user.setPasswordConfirm(passwordConfirm);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setEncodedImage(Base64.getEncoder().encodeToString(imgFile.getBytes()));
		return user;		
	}

}
