package com.worldcup.BackWorldCup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldcup.BackWorldCup.exception.AppException;
import com.worldcup.BackWorldCup.model.Game;
import com.worldcup.BackWorldCup.model.User;
import com.worldcup.BackWorldCup.payload.ApiResponse;
import com.worldcup.BackWorldCup.repository.UserRepository;
import com.worldcup.BackWorldCup.security.UserPrincipal;
import com.worldcup.BackWorldCup.service.GameServiceImpl;

@RestController
@PreAuthorize("hasRole('USER')")
@RequestMapping("/reserve")
public class ReserveController {
     
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	GameServiceImpl gameService;
	
	// id game
	@PostMapping("/{id}")
	public ResponseEntity reserveGame(@PathVariable Long id) {
		 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 
		UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();   
		  
		User user = userRepository.findById(userPrincipal.getId())
				  .orElseThrow( 
						  () ->  new AppException("no user found") 
						  );
	    Game game = gameService.getGame(id)
	    		.orElseThrow(
	    				() -> new AppException("no game Found")
 	    				);
	    
	    if(user.getAmount() >= game.getPrice())
	    {
	    	user.setAmount(user.getAmount() - game.getPrice());
	    	user.addGame(game);
	    	userRepository.saveAndFlush(user);
	       
	    	return new ResponseEntity(new ApiResponse(true, "success"),
	                 HttpStatus.OK);
	    
	    }
	    
	   
		
		return new ResponseEntity(new ApiResponse(false, "amount insufficient"),
				 HttpStatus.BAD_REQUEST
				);
		
	}
	
}
