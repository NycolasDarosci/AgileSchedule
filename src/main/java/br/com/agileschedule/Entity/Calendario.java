package br.com.agileschedule.Entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calendario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "diaInicial")
	private LocalDate diaInicial;

	@Column(name = "diaFinal")
	private LocalDate diaFinal;

	@Column(name = "hrInicial")
	private LocalTime hrInicial;

	@Column(name = "hrFinal")
	private LocalTime hrFinal;

	@Column(name = "descricao")
	private String descricao;

	public Calendario(LocalDate diaInicial, LocalDate diaFinal, LocalTime hrInicial, LocalTime hrFinal,
			String descricao) {
		super();
		this.diaInicial = diaInicial;
		this.diaFinal = diaFinal;
		this.hrInicial = hrInicial;
		this.hrFinal = hrFinal;
		this.descricao = descricao;
	}

	public Calendario() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDiaInicial() {
		return diaInicial;
	}

	public void setDiaInicial(LocalDate diaInicial) {
		this.diaInicial = diaInicial;
	}

	public LocalDate getDiaFinal() {
		return diaFinal;
	}

	public void setDiaFinal(LocalDate diaFinal) {
		this.diaFinal = diaFinal;
	}

	public LocalTime getHrInicial() {
		return hrInicial;
	}

	public void setHrInicial(LocalTime hrInicial) {
		this.hrInicial = hrInicial;
	}

	public LocalTime getHrFinal() {
		return hrFinal;
	}

	public void setHrFinal(LocalTime hrFinal) {
		this.hrFinal = hrFinal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
