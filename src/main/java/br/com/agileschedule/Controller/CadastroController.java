package br.com.agileschedule.Controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.agileschedule.DTO.UserDto;
import br.com.agileschedule.Entity.User;
import br.com.agileschedule.Form.UserForm;
import br.com.agileschedule.Repository.UserRepository;

@Controller
public class CadastroController {

	
	@Autowired
	private UserRepository useR;
	
	@PostMapping("/cadastro")
	public ResponseEntity<?> newUser(@RequestBody @Valid UserForm userF,
			UriComponentsBuilder builder){
		User user = userF.toForm(useR);
        URI uri = builder.path("/cadastro/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDto().EntidDTO(user));
	}
}
