package com.worldcup.BackWorldCup.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "teams")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private Integer wins;
	
	@Column
	private Integer draws;
	
	@Column
	private Integer loses;
	
	@OneToMany(mappedBy = "homeTeam",  cascade = CascadeType.ALL)
	private Set<Game> homeGames;


	@OneToMany(mappedBy = "awayTeam" ,cascade = CascadeType.ALL)
	private Set<Game> awayGames;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getWins() {
		return wins;
	}


	public void setWins(Integer wins) {
		this.wins = wins;
	}


	public Integer getDraws() {
		return draws;
	}


	public void setDraws(Integer draws) {
		this.draws = draws;
	}


	public Integer getLoses() {
		return loses;
	}


	public void setLoses(Integer loses) {
		this.loses = loses;
	}


	public Set<Game> getHomeGames() {
		return homeGames;
	}


	public void setHomeGames(Set<Game> homeGames) {
		this.homeGames = homeGames;
	}


	public Set<Game> getAwayGames() {
		return awayGames;
	}


	public void setAwayGames(Set<Game> awayGames) {
		this.awayGames = awayGames;
	}
	
	
	
}
