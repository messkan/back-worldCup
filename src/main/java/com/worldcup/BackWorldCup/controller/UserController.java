package com.worldcup.BackWorldCup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldcup.BackWorldCup.model.User;
import com.worldcup.BackWorldCup.repository.UserRepository;

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
}
