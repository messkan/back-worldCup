package com.worldcup.BackWorldCup.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class TeamRequest {
	
	@NotBlank
	 @Size(max = 40)
	 private String name;
	 
	 @NotBlank
	 @Size(max = 40)
	 private int wins;
	 
	 @NotBlank
	  @Size(max = 100)
	  private int draws;
	  
	  @NotBlank
	  @Size(max = 100)
	  private int loses;

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
	  


}
