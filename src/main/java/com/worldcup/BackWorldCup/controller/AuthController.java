package com.worldcup.BackWorldCup.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldcup.BackWorldCup.exception.AppException;
import com.worldcup.BackWorldCup.model.Role;
import com.worldcup.BackWorldCup.model.RoleName;
import com.worldcup.BackWorldCup.model.User;
import com.worldcup.BackWorldCup.payload.ApiResponse;
import com.worldcup.BackWorldCup.payload.JwtAuthenticationResponse;
import com.worldcup.BackWorldCup.payload.LoginRequest;
import com.worldcup.BackWorldCup.payload.UserRequest;
import com.worldcup.BackWorldCup.repository.RoleRepository;
import com.worldcup.BackWorldCup.repository.UserRepository;
import com.worldcup.BackWorldCup.security.JwtTokenProvider;

import java.util.Collection;
import java.util.Collections;


@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider tokenProvider;
	    
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
   
	@Autowired
	RoleRepository roleRepository;
	
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        
        
        Collection<? extends GrantedAuthority> roles = authentication.getAuthorities(); 
       
        
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt , roles ));
    }
    
    
    @PostMapping("/newUser")
	public ResponseEntity newUser(
			@RequestBody UserRequest userRequest
			)
	{
		

        if(userRepository.existsByEmail(userRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }
        System.out.println(userRequest.getPassword());
        
        User user = new User();
        user.setEmail(userRequest.getEmail());

   
                                                             
        Role userRole = roleRepository.findByName(RoleName.valueOf(userRequest.getRole()))
                .orElseThrow(() -> new AppException("Role not set."));

        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
  
    
        user.setRoles(Collections.singleton(userRole));
   
        
        userRepository.save(user);
          
        
		
		return  new ResponseEntity(new ApiResponse(true, "success"),
                HttpStatus.CREATED);
	}

	
	
}
