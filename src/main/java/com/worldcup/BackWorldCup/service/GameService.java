package com.worldcup.BackWorldCup.service;

import java.util.List;
import java.util.Optional;

import com.worldcup.BackWorldCup.model.Game;

public interface GameService {

    Optional<Game> getGame(Long id);
	
	List<Game> getAllGames();
	
	Game saveGame(Game game);
	
	Game updateGame(Game game);

	void deleteGame(Long id);
}