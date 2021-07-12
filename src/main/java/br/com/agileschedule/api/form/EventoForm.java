package br.com.agileschedule.api.form;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.ValidationException;
import javax.validation.constraints.NotBlank;

import br.com.agileschedule.api.model.Evento;

public class EventoForm {

	@NotBlank
	private String titulo;

	private String descricao;

	@NotBlank
	private LocalDate diainicial;

	private LocalDate diafinal;

	@NotBlank
	private LocalTime horainicial;

	private LocalTime horafinal;


	public EventoForm() {
		if(this.diainicial.isAfter(this.diafinal)) {
			throw new ValidationException("Dia final não pode ser anterior ao dia inicial.");
		}
	}
	public String getTitulo() {
		return this.titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDate getDiaInicial() {
		return diainicial;
	}

	public LocalDate getDiaFinal() {
		return diafinal;
	}

	public LocalTime getHoraInicial() {
		return horainicial;
	}

	public LocalTime getHoraFinal() {
		return horafinal;
	}

	public Evento toEvento() {
		return new Evento(this);
	}
}
