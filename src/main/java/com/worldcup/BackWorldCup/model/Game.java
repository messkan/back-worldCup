package com.worldcup.BackWorldCup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "games")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column
	private String date;
	
	@Column
	private String score;
	
	@Column
	private Double price; 
	
	

	@Column
	private String stadium;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "home_team_id", referencedColumnName = "team_id")
 	@JsonIgnore
	private Team homeTeam;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "away_team_id", referencedColumnName = "team_id")
 	@JsonIgnore
	private Team awayTeam;

	public Long getId() {
		return id;
	}

	public void setId(Long id2) {
		this.id = id2;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	
	
}
