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
import com.worldcup.BackWorldCup.payload.GameRequest;
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
	public Optional<Game> getGame(@PathVariable Long id){
		Optional<Game> Game = gameService.getGame(id);
		
		if (Game.isPresent()) {
			return Game;
		}
		else {
			throw new RuntimeException("Le match avec cet id n'existe pas " + id);
		}
	}
	
	
	@PostMapping
	public Game save(@RequestBody GameRequest gameRequest) {
		
		Game game = new Game();
		game.setDate(gameRequest.getDate());
		game.setStadium(gameRequest.getStadium());
		game.setScore(gameRequest.getScore());
		game.setPrice(gameRequest.getPrice());
		game.setAwayTeam(gameRequest.getAwayTeam());
		game.setHomeTeam(gameRequest.getHomeTeam());
		
		return gameService.saveGame(game);
		
	}
	
	@PutMapping("/{id}")
	public Game update(@RequestBody GameRequest gameRequest, @PathVariable Long id) {
		
		Optional<Game> optionalGame = gameService.getGame(id);
		
		
		if (optionalGame.isPresent()) {
			Game exisGame = optionalGame.get();

			Game game = new Game();
			game.setId(id);
			game.setDate(gameRequest.getDate());
			game.setStadium(gameRequest.getStadium());
			game.setScore(gameRequest.getScore());
			game.setPrice(gameRequest.getPrice());
			game.setAwayTeam(exisGame.getAwayTeam());
			game.setHomeTeam(exisGame.getHomeTeam());
			return gameService.updateGame(game);
		}
		else {
			throw new RuntimeException("Le match avec cet id n'existe pas " + id);
		}
		
		
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		gameService.deleteGame(id);
	}
}
