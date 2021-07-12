package br.com.agileschedule.form;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.ValidationException;
import javax.validation.constraints.NotBlank;

import br.com.agileschedule.model.Evento;

public class EventoForm {

	@NotBlank
	private String titulo;

	private String descricao;

	@NotBlank
	private LocalDate diaInicial;

	private LocalDate diaFinal;

	@NotBlank
	private LocalTime horaInicial;

	private LocalTime horaFinal;


	public EventoForm() {
		if(this.diaInicial.isAfter(this.diaFinal)) {
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
		return diaInicial;
	}

	public LocalDate getDiaFinal() {
		return diaFinal;
	}

	public LocalTime getHoraInicial() {
		return horaInicial;
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}

	public Evento toEvento() {
		return new Evento(this);
	}
}
