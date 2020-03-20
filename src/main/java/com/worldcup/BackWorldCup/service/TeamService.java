package com.worldcup.BackWorldCup.service;

import com.worldcup.BackWorldCup.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
	
	Optional<Team> getTeam(Integer id);
	
	List<Team> getAllTeams();
	
	Team saveTeam(Team team);
	
	Team updateTeam(Team team);

	void deleteTeam(Integer id);

		
	
}
