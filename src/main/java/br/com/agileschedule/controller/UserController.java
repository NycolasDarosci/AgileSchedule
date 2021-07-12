package br.com.agileschedule.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.agileschedule.form.EventoForm;
import br.com.agileschedule.form.UpdateUserForm;
import br.com.agileschedule.model.Evento;
import br.com.agileschedule.repository.EventoRepository;
import br.com.agileschedule.service.EventoService;
import br.com.agileschedule.service.UserService;
import javassist.NotFoundException;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private EventoRepository eventoRepository;

	@Autowired
	EventoService eventoService;
	
	
	@GetMapping("/evento")
	public ModelAndView pageIndex(Model model) {
		eventoss();
		newEventoForm();
		newUserForm();
		return new ModelAndView("index");
	}

	@PostMapping("/updateTokenAlura")
	@Transactional
	public ResponseEntity<Void> updateTokenAluraController(@ModelAttribute ("UpdateUserForm") UpdateUserForm updUserForm)
			throws NotFoundException {

		userService.updateTokenAluraService(updUserForm);
		return ResponseEntity.ok().build();
	}

	@PatchMapping("/disableUser")
	@Transactional
	public ResponseEntity<Void> disableUserController(@RequestParam(required = true) Long idUser)
			throws NotFoundException {

		userService.disableUserService(idUser);
		return ResponseEntity.ok().build();
	}

	@ModelAttribute("Evento")
	public EventoForm newEventoForm() {
		return new EventoForm();
	}

	@ModelAttribute("eventoss")
	public List<Evento> eventoss() {
		List<Evento> eventos = eventoRepository.findAll();
		return eventos;
	}

	@ModelAttribute("UpdateUserForm")
	private UpdateUserForm newUserForm() {
		return new UpdateUserForm();
	}

}
