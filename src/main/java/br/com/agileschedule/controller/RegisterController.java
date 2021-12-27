package br.com.agileschedule.controller;

import br.com.agileschedule.dto.UserRequest;
import br.com.agileschedule.dto.UserResponse;
import br.com.agileschedule.repository.UserRepository;
import br.com.agileschedule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Controller
public class RegisterController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;


	@PostMapping("/register")
	public ResponseEntity<UserResponse> newUser(@RequestBody @Valid UserRequest userRequest, BindingResult bindingResult) {
		UserResponse userResponse = userService.newUser(userRequest);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(userResponse.getId()).toUri();
		return ResponseEntity.created(uri).body(userResponse);
	}
}