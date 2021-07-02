package br.com.agileschedule.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agileschedule.form.AluraForm;
import br.com.agileschedule.form.TokenAluraForm;
import br.com.agileschedule.service.ApiAluraService;
import br.com.agileschedule.service.UserService;
import javassist.NotFoundException;

@Controller
public class TokenAluraController {

	@Autowired
	private UserService userS;

	@Autowired
	private ApiAluraService apiAlura;
	
	@PutMapping("/tokenalura/{id}")
	@Transactional
	public ResponseEntity<?> TokenAlura(@Valid @RequestBody TokenAluraForm tokenF) throws NotFoundException {
		userS.tokenAlura(tokenF);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/getAlura")
	public ResponseEntity<AluraForm> tokenAlura(){
		return ResponseEntity.ok(apiAlura.tokenAlura());		
	}
	
	
	
	
}
