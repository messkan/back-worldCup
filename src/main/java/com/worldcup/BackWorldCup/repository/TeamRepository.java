package com.worldcup.BackWorldCup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worldcup.BackWorldCup.model.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
