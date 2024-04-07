package com.example.demo.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.UsernameNotFoundException;
import com.example.demo.Model.User;
import com.example.demo.ServiceI.userServicesI;
import com.example.demo.repository.userRepository;

@Service
public class userServices implements userServicesI{

	@Autowired
	userRepository ures;
	
	@Override
	public User createUser(User user) {
	
		return ures.save(user);
	}

	@Override
	public boolean isUserAdmin(String username) {
		 Optional<User> ucheck = ures.findByUsername(username);
		     if(ucheck.isPresent())
		     {
		    	 User user=ucheck.get();
		    	  if(user.getRole()=="Admin")
		    	   return true;
		    	 
		     }
		     else {
				throw new UsernameNotFoundException("user not found");
			}
			return false;
		    
	}
	
}
