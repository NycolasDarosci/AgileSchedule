package br.com.agileschedule.form;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.agileschedule.model.Evento;

public class EventoForm {

	@NotBlank
	private String titulo;

	private String descricao;

	@NotBlank
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate diaInicial;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate diaFinal;

	@NotBlank
	private LocalTime horaInicial;

	private LocalTime horaFinal;

	// public EventoForm() {
	// if(this.diainicial.isAfter(this.diafinal)) {
	// throw new ValidationException("Dia final não pode ser anterior ao dia
	// inicial.");
	// }
	// }
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

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDiaInicial(LocalDate diaInicial) {
		this.diaInicial = diaInicial;
	}

	public void setDiaFinal(LocalDate diaFinal) {
		this.diaFinal = diaFinal;
	}

	public void setHoraInicial(LocalTime horaInicial) {
		this.horaInicial = horaInicial;
	}

	public void setHoraFinal(LocalTime horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Evento toevento() {
		return new Evento(this);
	}

	public Evento toEvento() {
		return new Evento(this);
	}
}
