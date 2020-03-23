package com.worldcup.BackWorldCup.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.worldcup.BackWorldCup.model.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

	
}
