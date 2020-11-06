package ua.lviv.lgs.security;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.User;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String assignedId) throws UsernameNotFoundException {

		Optional<User> userOptional = userRepository.findByAssignedId(assignedId);

		if (userOptional.isPresent()) {
			User user = userOptional.get();
			
			System.out.println("role ===  " + new CustomUserDetails(user, Collections.singletonList(user.getRole().toString())));
			
			return new CustomUserDetails(user, Collections.singletonList(user.getRole().toString()));
		}

		throw new UsernameNotFoundException("No user present with assignedId:" + assignedId);
	}

}
