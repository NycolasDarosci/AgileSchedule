package br.com.agileschedule.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.agileschedule.form.TokenAluraForm;
import br.com.agileschedule.service.UserService;
import javassist.NotFoundException;

@Controller
public class TokenAluraController {

	@Autowired
	private UserService userS;

	@PutMapping("/tokenalura/{id}")
	@Transactional
	public ResponseEntity<?> TokenAlura(@Valid @RequestBody TokenAluraForm tokenF) throws NotFoundException {
		userS.tokenAlura(tokenF);
		return ResponseEntity.ok().build();
	}
}
