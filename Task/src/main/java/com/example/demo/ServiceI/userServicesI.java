package com.example.demo.ServiceI;

import com.example.demo.Model.User;

public interface userServicesI {

	User createUser(User user);

	boolean isUserAdmin(String username);

	
}
