package br.com.agileschedule.api.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.agileschedule.api.form.CreateUserForm;
import br.com.agileschedule.api.model.User;
import br.com.agileschedule.api.service.UserService;
import javassist.NotFoundException;


@Controller
@RequestMapping("/cadastro")
public class cadastroController {

	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("User")
	public CreateUserForm userForm() {
		return new CreateUserForm();
	}
	
	@GetMapping
	public String pageCadastro() {
		return "cadastro";
	}
	
	@PostMapping
	public String newUserController
	(@ModelAttribute ("User") CreateUserForm cUserForm, UriComponentsBuilder builder) throws NotFoundException {
		
		User user = userService.newUserService(cUserForm);
		URI uri = builder.path("/cadastro/{id}").buildAndExpand(user.getId()).toUri();
		return "login";
	}

	
	
}
