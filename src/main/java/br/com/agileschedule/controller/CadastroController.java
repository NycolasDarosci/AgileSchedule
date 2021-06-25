package br.com.agileschedule.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.agileschedule.dto.UserDTO;
import br.com.agileschedule.entity.User;
import br.com.agileschedule.form.UserForm;
import br.com.agileschedule.repository.UserRepository;

@Controller
public class CadastroController {

	@Autowired
	private UserRepository useR;

	@PostMapping("/cadastro")
	public ResponseEntity<?> newUser(@RequestBody @Valid UserForm userF, UriComponentsBuilder builder) {
		User user = userF.toForm(useR);
		URI uri = builder.path("/cadastro/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserDTO().EntidDTO(user));
	}
}
