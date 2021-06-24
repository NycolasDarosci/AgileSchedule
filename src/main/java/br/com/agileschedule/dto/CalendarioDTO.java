package br.com.agileschedule.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class CalendarioDTO {

	private LocalDate diaInicial;

	private LocalDate diaFinal;

	private LocalTime hrInicial;

	private LocalTime hrFinal;

	private String descricao;

	public CalendarioDTO() {
	}

	public CalendarioDTO(LocalDate diaInicial, LocalDate diaFinal, LocalTime hrInicial, LocalTime hrFinal,
			String descricao) {
		this.diaInicial = diaInicial;
		this.diaFinal = diaFinal;
		this.hrInicial = hrInicial;
		this.hrFinal = hrFinal;
		this.descricao = descricao;
	}

	public LocalDate getDiaInicial() {
		return diaInicial;
	}

	public LocalDate getDiaFinal() {
		return diaFinal;
	}

	public LocalTime getHrInicial() {
		return hrInicial;
	}

	public LocalTime getHrFinal() {
		return hrFinal;
	}

	public String getDescricao() {
		return descricao;
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

	public void setHrInicial(LocalTime hrInicial) {
		this.hrInicial = hrInicial;
	}

	public void setHrFinal(LocalTime hrFinal) {
		this.hrFinal = hrFinal;
	}

}
