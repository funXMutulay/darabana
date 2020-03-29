package org.quantum.nine.cart.security;

import org.quantum.nine.cart.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	User findByEmail(String email);

}
