package com.worldcup.BackWorldCup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worldcup.BackWorldCup.model.User;

public interface UserRepository extends JpaRepository<User , Long>{
   
	Optional<User> findByEmail(String Email); 
	
	Optional<User> findById(Long id); 
	
	Boolean existsByEmail(String Email);
}
