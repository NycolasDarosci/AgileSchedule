package br.com.agileschedule.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.agileschedule.components.CalendarioConverter;
import br.com.agileschedule.controller.validar.Validacao;
import br.com.agileschedule.dto.CalendarioDTO;
import br.com.agileschedule.entity.Calendario;
import br.com.agileschedule.form.CalendarioForm;
import br.com.agileschedule.repository.CalendarioRepository;
import javassist.NotFoundException;

@Controller
@RequestMapping("/")
public class homeController {

	@Autowired
	private CalendarioConverter calenConverter;

	@Autowired
	private CalendarioRepository calendarioR;

	@Autowired
	private Validacao validacao;

	@GetMapping
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@GetMapping("/calendario")
	public ResponseEntity<List<CalendarioDTO>> listCalendario() {
		List<Calendario> calen = calendarioR.findAll();

		return ResponseEntity.ok(calenConverter.toListCalendarioDTO(calen));
	}

	@PostMapping("newCalendar")
	public ResponseEntity<?> criarEvento(@RequestBody @Valid CalendarioForm calenForm, UriComponentsBuilder builder) {

		// verificacao de dataInformada < data.now()
		validacao.verificarData(calenForm);

		try {
			// Convertendo o CalendarioForm para um Model Calendario
			Calendario calen = calenConverter.toCalendario(calenForm);

			calendarioR.save(calen);
			// colocando o id do calendario criado na URI
			URI uri = builder.path("/calendario/{id}").buildAndExpand(calen.getId()).toUri();

			// convertendo o Model Calendario para um Calendario DTO e o retornando
			return ResponseEntity.created(uri).body(calenConverter.toCalendarioDTO(calen));

		} catch (DataIntegrityViolationException SQL) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não Foi Possivel Adicionar ao Calendario");
		}
	}

	@PutMapping("/calendario/{id}")
	@Transactional
	public ResponseEntity<CalendarioDTO> atualizarEvento(@PathVariable(value = "id") Long id,
			@Valid @RequestBody CalendarioForm calenForm) throws NotFoundException {

		// esperando atualizar o objeto Calendario
		Calendario calen = calendarioR.findById(id).orElseThrow(() -> new NotFoundException("Evento não encontrado!"));

		calen.setDescricao(calenForm.getDescricao());
		calen.setDiaInicial(calenForm.getDiaInicial());
		calen.setDiaFinal(calenForm.getDiaFinal());
		calen.setHrInicial(calenForm.getHrInicial());
		calen.setHrFinal(calenForm.getHrFinal());

		// convertendo o model Calendario para um CalendarioDTO e retornando
		return ResponseEntity.ok(calenConverter.toCalendarioDTO(calen));
	}

	@DeleteMapping("/calendario/{id}")
	@Transactional
	public ResponseEntity<?> deletarEvento(@PathVariable(value = "id") Long id) throws NotFoundException {

		Calendario calen = calendarioR.findById(id).orElseThrow(() -> new NotFoundException("Evento não encontrado!"));
		// deletando
		calendarioR.delete(calen);
		return ResponseEntity.noContent().build();
	}
}
