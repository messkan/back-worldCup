package com.worldcup.BackWorldCup.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldcup.BackWorldCup.model.Team;
import com.worldcup.BackWorldCup.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	@Override
	public Optional<Team> getTeam(Integer id) {
		// TODO Auto-generated method stub
		return teamRepository.findById(id);
	}
		
	@Override
	public List<Team> getAllTeams() {
		// TODO Auto-generated method stub
		return teamRepository.findAll();
	}

	@Override
	public Team saveTeam(Team team) {
		// TODO Auto-generated method stub
		return teamRepository.save(team);
	}

	@Override
	public Team  updateTeam(Team team) {
		// TODO Auto-generated method stub
		return teamRepository.saveAndFlush(team);

	}

	@Override
	public void deleteTeam(Integer id) {
		// TODO Auto-generated method stub
		teamRepository.deleteById(id);

	}

}
