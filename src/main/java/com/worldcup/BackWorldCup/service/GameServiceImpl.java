package com.worldcup.BackWorldCup.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldcup.BackWorldCup.model.Game;
import com.worldcup.BackWorldCup.repository.GameRepository;
@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameRepository gameRepository;

	@Override
	public Optional<Game> getGame(Long id) {
		// TODO Auto-generated method stub
		return gameRepository.findById(id);
	}

	@Override
	public List<Game> getAllGames() {
		// TODO Auto-generated method stub
		return gameRepository.findAll();
	}

	@Override
	public Game saveGame(Game game) {
		// TODO Auto-generated method stub
		return gameRepository.save(game);
	}

	@Override
	public Game updateGame(Game game) {
		// TODO Auto-generated method stub
		
		return gameRepository.saveAndFlush(game);
	}

	@Override
	public void deleteGame(Long id) {
		// TODO Auto-generated method stub
		gameRepository.deleteById(id);

	}

	

}
