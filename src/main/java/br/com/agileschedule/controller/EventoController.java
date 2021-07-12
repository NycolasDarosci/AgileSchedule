package br.com.agileschedule.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.agileschedule.dto.EventoDTO;
import br.com.agileschedule.form.EventoForm;
import br.com.agileschedule.service.EventoService;
import javassist.NotFoundException;

@Controller
@RequestMapping("/eventosss")
public class EventoController {

	@Autowired
	EventoService eventoService;

	@ModelAttribute("evento")
    public EventoForm formEvento() {
        return new EventoForm();
    }

	@PostMapping
	public String newEventoController(@ModelAttribute ("evento") EventoForm eventoForm, UriComponentsBuilder builder) throws NotFoundException {
		
		//Criando o evento e o retornando em DTO
		EventoDTO eventoDTO = eventoService.newEventoService(eventoForm);

		//Criando um recurso com o id do evento criado
		URI uri = builder.path("/eventosss/{id}").buildAndExpand(eventoDTO.getId()).toUri();
		
		ResponseEntity.created(uri).body(eventoDTO);
		return "index";
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
