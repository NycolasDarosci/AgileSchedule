package br.com.agileschedule.api.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.agileschedule.api.dto.UserDTO;
import br.com.agileschedule.api.form.CreateUserForm;
import br.com.agileschedule.api.form.UpdateUserForm;
import br.com.agileschedule.api.service.UserService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute("User")
	public UpdateUserForm userForm() {
		return new UpdateUserForm();
	}

	@PostMapping("/newUser")
	public ResponseEntity<UserDTO> newUserController
	(@ModelAttribute ("User") @Valid CreateUserForm cUserForm, UriComponentsBuilder builder) throws NotFoundException {
		
		UserDTO user = userService.newUserService(cUserForm);
		URI uri = builder.path("/cadastro/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}


	@PutMapping("/updateUser")
	@Transactional
	public ResponseEntity<UserDTO> updateUserController
	(@RequestBody UpdateUserForm updUserForm) throws NotFoundException {
		
		return ResponseEntity.ok(userService.updateUserService(updUserForm));
	}

	@PatchMapping("/updateTokenAlura")
	@Transactional
	public ResponseEntity<Void> updateTokenAluraController
	(@RequestBody @Valid UpdateUserForm updUserForm) throws NotFoundException {

		userService.updateTokenAluraService(updUserForm);
		return ResponseEntity.ok().build();
	}


	@PatchMapping("/disableUser")
	@Transactional
	public ResponseEntity<Void> disableUserController
	(@RequestParam(required = true) Long idUser) throws NotFoundException {
		
		userService.disableUserService(idUser);
		return ResponseEntity.ok().build();
	}
	

	

}
