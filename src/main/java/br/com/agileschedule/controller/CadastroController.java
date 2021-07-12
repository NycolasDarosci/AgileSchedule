package br.com.agileschedule.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.agileschedule.config.Utilitario;
import br.com.agileschedule.form.CreateUserForm;
import br.com.agileschedule.service.UserService;
import javassist.NotFoundException;


@Controller
@RequestMapping("/cadastro")
public class CadastroController {

	
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
	(@ModelAttribute ("User") CreateUserForm cUserForm, HttpServletRequest request)
			throws NotFoundException, UnsupportedEncodingException, MessagingException {
		
		userService.newUserService(cUserForm, Utilitario.getUrlSite(request));
		return "login";
	}

	@GetMapping("/verificarEmail")
	@Transactional
	public String verificarEmailController(
		@RequestParam(name = "token", required = true) String token, Model model) {
		
		boolean verificado = userService.verificarEmailService(token);
		return "login";
	}
}
