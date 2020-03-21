package com.worldcup.BackWorldCup.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import com.worldcup.BackWorldCup.model.Team;

public class GameRequest {

	 @NotBlank
	 @Size(max = 40)
	 private String date;
	 
	 @NotBlank
	 @Size(max = 40)
	 private String score;
	 
	 @NotBlank
	  @Size(max = 100)
	  private String stadium;
	  
	  @NotBlank
	  @Size(max = 100)
	  private Team homeTeam;
	  
	  @NotBlank
	  @Size(max = 100)
	  private Team awayTeam;
	 
	 
	  public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
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

	

	
}
