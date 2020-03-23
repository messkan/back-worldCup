package com.worldcup.BackWorldCup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldcup.BackWorldCup.model.Team;
import com.worldcup.BackWorldCup.service.TeamService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@GetMapping
	public List<Team> getAllTeams(){
		return teamService.getAllTeams();
	}
	
	@GetMapping("/{id}")
	public Optional<Team> getTeam(@PathVariable Integer id){
		Optional<Team> team = teamService.getTeam(id);
		
		if (team.isPresent()) {
			return team;
		}
		else {
			throw new RuntimeException("L'equipe avec cet id n'existe pas " + id);
		}
	}
	
	
	@PostMapping
	public Team save(@RequestBody Team team) {
		return teamService.saveTeam(team);
		
	}
	
	@PutMapping
	public Team update(@RequestBody Team team) {
		return teamService.updateTeam(team);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		teamService.deleteTeam(id);
	}

}
