package com.worldcup.BackWorldCup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worldcup.BackWorldCup.model.Role;
import com.worldcup.BackWorldCup.model.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	 Optional<Role> findByName(RoleName roleName);
}
