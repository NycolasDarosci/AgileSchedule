package br.com.agileschedule.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.agileschedule.dto.UserDTO;
import br.com.agileschedule.form.UpdateUserForm;
import br.com.agileschedule.service.UserService;
import javassist.NotFoundException;

@Controller
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ModelAndView pageIndex() {
		return new ModelAndView("index");
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
