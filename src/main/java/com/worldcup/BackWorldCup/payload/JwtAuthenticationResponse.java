package com.worldcup.BackWorldCup.payload;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtAuthenticationResponse {
  
	
	private String accessToken;
    private String tokenType = "Bearer";
    
    private Collection<? extends GrantedAuthority> roles ;

    public JwtAuthenticationResponse(String accessToken , Collection<? extends GrantedAuthority> roles   ) {
        this.accessToken = accessToken;
       
        this.roles = roles;
        
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }
    
    



	public Collection<? extends GrantedAuthority> getRoles() {
		return roles;
	}

	public void setRoles(Collection<? extends GrantedAuthority> roles) {
		this.roles = roles;
	}

	public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
