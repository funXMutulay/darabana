package org.quantum.nine.cart.security;

import java.util.UUID;

import org.quantum.nine.cart.JCartException;
import org.quantum.nine.cart.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SecurityService {
	
	@Autowired
	UserRepository userRepository ;
	
	public User findUserByEmail(String email) {
		
		return userRepository.findByEmail(email) ;
		
	}
	
	public String resetPassword(String email)
	{
		User user = findUserByEmail(email);
		if(user == null)
		{
			throw new JCartException("Invalid email address");
		}
		String uuid = UUID.randomUUID().toString();
		user.setPasswordResetToken(uuid);
		return uuid;
	}

}
