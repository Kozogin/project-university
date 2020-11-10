package ua.lviv.lgs.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.domain.User;

public class UserDTOHelper {
	
	public static User createEntity(MultipartFile imgFile, String password, String passwordConfirm, 
			String firstName, String lastName, String email) throws IOException {
		
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
