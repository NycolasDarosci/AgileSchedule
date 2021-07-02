package br.com.agileschedule.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.agileschedule.entity.User;
import br.com.agileschedule.form.TokenAluraForm;
import javassist.NotFoundException;

@Service
public class UserService {

	public User tokenAlura(TokenAluraForm tokenF) throws NotFoundException {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user.setTokenAlura(tokenF.getTokenALura());
		return user;

	}

	public void findByToken() {

	}

}
