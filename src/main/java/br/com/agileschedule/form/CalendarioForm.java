package br.com.agileschedule.form;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import br.com.agileschedule.repository.CalendarioRepository;

public class CalendarioForm {

	@NotNull
	private String descricao;

	@NotNull
	private LocalDate diaInicial;

	@NotNull
	private LocalDate diaFinal;

	@NotNull
	private LocalTime hrInicial;

	@NotNull
	private LocalTime hrFinal;

	public CalendarioForm() {

	}

	public CalendarioForm(@NotNull String descricao, @NotNull LocalDate diaInicial, @NotNull LocalDate diaFinal,
			@NotNull LocalTime hrInicial, @NotNull LocalTime hrFinal) {

		this.descricao = descricao;
		this.diaInicial = diaInicial;
		this.diaFinal = diaFinal;
		this.hrInicial = hrInicial;
		this.hrFinal = hrFinal;
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

	public String getDescricao() {
		return descricao;
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
	

	

}
