package br.com.agileschedule.api.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.agileschedule.model.Evento;


public class EventoDTO {

	private Long id;

	private String titulo;

	private String descricao;

	private LocalDate diainicial;

	private LocalDate diafinal;

	private LocalTime horainicial;

	private LocalTime horafinal;


	public EventoDTO() { }

	public EventoDTO(Evento evento){ 
		this.id = evento.getId();
		this.titulo = evento.getTitulo();
		this.diainicial = evento.getDiaInicial();
		this.diafinal = evento.getDiaFinal();
		this.horainicial = evento.getHoraInicial();
		this.horafinal = evento.getHoraFinal();
		this.descricao = evento.getDescricao();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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
		this.diainicial = diaInicial;
	}

	public void setDiaFinal(LocalDate diaFinal) {
		this.diafinal = diaFinal;
	}

	public void setHoraInicial(LocalTime hrInicial) {
		this.horainicial = hrInicial;
	}

	public void setHoraFinal(LocalTime hrFinal) {
		this.horafinal = hrFinal;
	}
}
