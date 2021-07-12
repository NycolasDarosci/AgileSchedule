package br.com.agileschedule.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import br.com.agileschedule.model.User;


public class CustomUserDetails implements UserDetails {
	
	
	private static final long serialVersionUID = 1L;
	private User userr;

	public CustomUserDetails(User userr) {
		this.userr = userr;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return userr.getPerfis();
	}

	@Override
	public String getPassword() {
		return userr.getSenha();
	}

	@Override
	public String getUsername() {
		return userr.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return userr.isAtivo();
	}

	
}
