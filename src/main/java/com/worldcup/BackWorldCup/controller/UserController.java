package com.worldcup.BackWorldCup.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldcup.BackWorldCup.exception.AppException;
import com.worldcup.BackWorldCup.model.User;
import com.worldcup.BackWorldCup.repository.UserRepository;
import com.worldcup.BackWorldCup.security.UserPrincipal;

@RestController
@RequestMapping("/user")
public class UserController {
    
	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("/users")
	public List<User> getUsers() { 
	return 	userRepository.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
		return new ResponseEntity("deleted", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/current")
	public Optional<User> getCurrent() { 
	   UserPrincipal userPrincipal = 
		(UserPrincipal) SecurityContextHolder.getContext()
	    .getAuthentication()
	    .getPrincipal();
	   Optional<User> user = userRepository.findByEmail(userPrincipal.getEmail());
		return user; 
	}
}
