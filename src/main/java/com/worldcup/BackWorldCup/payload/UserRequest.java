package com.worldcup.BackWorldCup.payload;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;


public class UserRequest {
  	 
	 @NaturalId
	 @NotBlank
	 @Size(max = 40)
	 @Email
	 private String email;
	 
	 
	 
	  @NotBlank
	  @Size(max = 100)
	  private String password;
	  
	  
	  private String role;


	

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


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	  
	  
	  
}