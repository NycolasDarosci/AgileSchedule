package br.com.agileschedule.controller;
import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.agileschedule.entity.Calendario;
import br.com.agileschedule.form.CalendarioForm;


@Controller
public class TokenAluraController {

	//@Autowired
	//private TokenAluraRepository tokenAluraR;
	
//	@Autowired
//	private TokenAluraConverter Talura;
//	
//	@PostMapping("/token")
//	public ResponseEntity<TokenAlura> tokenAlura(@RequestBody @Valid TokenAluraForm tokenform, 
//			UriComponentsBuilder builder){
//		try {
//
//			TokenAlura token = Talura.toTokenAlura(tokenform);
//			
//			tokenAluraR.save(token);
//			URI uri = builder.path("/tokenalura/{id}").buildAndExpand(token.getId()).toUri();
//
//			return ResponseEntity.created(uri).body(TokenAluraConverter);
//
//		} catch (DataIntegrityViolationException SQL) {
//			return null; 
//					//ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não Foi Possivel Adicionar ao Calendario");
//		
//	}
//	
	}
