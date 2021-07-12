package br.com.agileschedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.agileschedule.model.User;
import br.com.agileschedule.repository.UserRepository;



public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userR;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User usuario = userR.findByEmail(email);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario não localizado");
		}
		return new CustomUserDetails(usuario);
	}

}