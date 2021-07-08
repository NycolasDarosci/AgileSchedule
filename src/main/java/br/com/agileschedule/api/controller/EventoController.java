package br.com.agileschedule.api.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.agileschedule.api.dto.EventoDTO;
import br.com.agileschedule.api.form.EventoForm;
import br.com.agileschedule.api.service.EventoService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

	@Autowired
	EventoService eventoService;


	@GetMapping("/listEventos")
	public ResponseEntity<List<EventoDTO>> listEventoController() throws NotFoundException {

		return ResponseEntity.ok(eventoService.listEventoService());
	}


	@PostMapping("/newEvento")
	public ResponseEntity<EventoDTO> newEventoController(@RequestBody @Valid EventoForm eventoForm, UriComponentsBuilder builder) throws NotFoundException {
		
		//Criando o evento e o retornando em DTO
		EventoDTO eventoDTO = eventoService.newEventoService(eventoForm);

		//Criando um recurso com o id do evento criado
		URI uri = builder.path("/evento/{id}").buildAndExpand(eventoDTO.getId()).toUri();
		
		return ResponseEntity.created(uri).body(eventoDTO);
	}


	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EventoDTO> updateEventoController
	(@PathVariable(value = "id") Long id, @Valid @RequestBody EventoForm eventoForm) 
	throws NotFoundException {

		return ResponseEntity.ok(eventoService.updateEventoService(id, eventoForm));
	}


	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> deleteEventoController(@PathVariable(value = "id") Long id) throws NotFoundException {

		eventoService.deleteEventoService(id);
		return ResponseEntity.noContent().build();
	}
}
