package com.Authent.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Authent.Repository.UserRepo;
import com.Authent.model.Userr;


@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	 @Autowired
	    private BCryptPasswordEncoder passwordEncoder;


	 public Userr signUp(Userr user) throws IllegalStateException {
		    if (userRepo.existsByEmail(user.getEmail())) {
		        throw new IllegalStateException("Email already in use");
		    }

		    user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash password
		    user.setFullName(user.getFullName());  // fullName  saved

		    return userRepo.save(user);
		}



	    public boolean login(String email, String password) {
	        Userr user = userRepo.findByEmail(email);

	        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
	            return false; 
	        }

	        return true; 
	    }


	    public Userr findByEmail(String email) {
	        return userRepo.findByEmail(email);
	    }

	
}
