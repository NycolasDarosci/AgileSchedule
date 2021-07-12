package br.com.agileschedule.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.agileschedule.dto.EventoDTO;
import br.com.agileschedule.dto.UserDTO;
import br.com.agileschedule.form.EventoForm;
import br.com.agileschedule.form.UpdateUserForm;
import br.com.agileschedule.model.Evento;
import br.com.agileschedule.repository.EventoRepository;
import br.com.agileschedule.service.EventoService;
import br.com.agileschedule.service.UserService;
import javassist.NotFoundException;

@Controller
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	EventoService eventoService;
	
	
	@GetMapping
	public ModelAndView pageIndex(Model model) {
		eventoss();
		newEventoForm();
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String newEventoController(@ModelAttribute ("EventoForm")EventoForm eventoForm, UriComponentsBuilder builder) throws NotFoundException {
		
		//Criando o evento e o retornando em DTO
		EventoDTO eventoDTO = eventoService.newEventoService(eventoForm);

		//Criando um recurso com o id do evento criado
		URI uri = builder.path("/api/{id}").buildAndExpand(eventoDTO.getId()).toUri();
		
		ResponseEntity.created(uri).body(eventoDTO);
		return "index";
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
	
	@ModelAttribute("Evento")
	public EventoForm newEventoForm(){
		return new EventoForm();
	}
	
	@ModelAttribute("eventoss")
	public List<Evento> eventoss(){
		List<Evento> eventos = eventoRepository.findAll();
		return eventos;
	}
		
		

}
