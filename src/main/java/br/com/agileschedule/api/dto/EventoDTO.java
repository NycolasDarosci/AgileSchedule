package br.com.agileschedule.api.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.agileschedule.api.model.Evento;

public class EventoDTO {

	private Long id;

	private String titulo;

	private String descricao;

	private LocalDate diaInicial;

	private LocalDate diaFinal;

	private LocalTime horaInicial;

	private LocalTime horaFinal;


	public EventoDTO() { }

	public EventoDTO(Evento evento){ 
		this.id = evento.getId();
		this.titulo = evento.getTitulo();
		this.diaInicial = evento.getDiaInicial();
		this.diaFinal = evento.getDiaFinal();
		this.horaInicial = evento.getHoraInicial();
		this.horaFinal = evento.getHoraFinal();
		this.descricao = evento.getDescricao();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}	

	public void setDiaInicial(LocalDate diaInicial) {
		this.diaInicial = diaInicial;
	}

	public void setDiaFinal(LocalDate diaFinal) {
		this.diaFinal = diaFinal;
	}

	public void setHoraInicial(LocalTime hrInicial) {
		this.horaInicial = hrInicial;
	}

	public void setHoraFinal(LocalTime hrFinal) {
		this.horaFinal = hrFinal;
	}
}
