package com.appsdeveloperblog.photoapp.Api.Users.ui.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateUsersModel {

	@NotNull(message ="First name cannot be null")
	@Size(min=2,message ="first name must not be less than two characters")
	private String firstName;
	
	@NotNull(message ="Last name cannot be null")
	@Size(min=2,message ="Last name must not be less than two characters")
	private String lastName;
	
	@NotNull(message="Email cannot be null")
	@Email
	private String email;
	
	@NotNull
	@Size(min=8,max=16, message="password must be greater than or equal to 8 charcater and less than 16 character")
	private String password;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
