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

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "teams")
public class Team  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private int wins;
	
	@Column
	private int draws;
	
	@Column
	private int loses;
	
	@Column
	private String flag; 
	
	@OneToMany(mappedBy = "homeTeam",  cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Game> homeGames;


	@OneToMany(mappedBy = "awayTeam" ,cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Game> awayGames;

	

	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}


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


	public int getWins() {
		return wins;
	}


	public void setWins(int wins) {
		this.wins = wins;
	}


	public int getDraws() {
		return draws;
	}


	public void setDraws(int draws) {
		this.draws = draws;
	}


	public int getLoses() {
		return loses;
	}


	public void setLoses(int loses) {
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
