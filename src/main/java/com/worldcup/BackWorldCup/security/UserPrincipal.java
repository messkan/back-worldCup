package com.worldcup.BackWorldCup.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.worldcup.BackWorldCup.model.User;

public class UserPrincipal implements UserDetails {
	
	 

	private Long id;

	@JsonIgnore
	private String email;

	@JsonIgnore
	private String password;
	 
	private Collection<? extends GrantedAuthority> authorities;
	 

	public UserPrincipal(Long id, String email, String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	 public static UserPrincipal create(User user) {
	      
	    	List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
	        new SimpleGrantedAuthority(role.getName().name())
	         ).collect(Collectors.toList());

	    
	        return new UserPrincipal(
	                user.getId(),
	                user.getEmail(),
	                user.getPassword(),
	                 authorities
	        		);
	    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}
