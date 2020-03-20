package com.worldcup.BackWorldCup.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldcup.BackWorldCup.model.Game;
import com.worldcup.BackWorldCup.service.GameService;;;

@RestController
@RequestMapping("/api/games")
public class GameController {
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<Game> getAllGames(){
		return gameService.getAllGames();
	}
	
	@GetMapping("/{id}")
	public Optional<Game> getGame(@PathVariable Integer id){
		Optional<Game> Game = gameService.getGame(id);
		
		if (Game.isPresent()) {
			return Game;
		}
		else {
			throw new RuntimeException("Le match avec cet id n'existe pas " + id);
		}
	}
	
	
	@PostMapping
	public Game save(@RequestBody Game Game) {
		return gameService.saveGame(Game);
		
	}
	
	@PutMapping
	public Game update(@RequestBody Game Game) {
		return gameService.updateGame(Game);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		gameService.deleteGame(id);
	}
}