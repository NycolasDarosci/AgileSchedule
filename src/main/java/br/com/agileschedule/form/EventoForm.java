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
	private LocalDate diainicial;

	private LocalDate diafinal;

	@NotBlank
	private LocalTime horainicial;

	private LocalTime horafinal;


//	public EventoForm() {
//		if(this.diainicial.isAfter(this.diafinal)) {
//			throw new ValidationException("Dia final não pode ser anterior ao dia inicial.");
//		}
	//}
	public String gettitulo() {
		return this.titulo;
	}

	public String getdescricao() {
		return descricao;
	}

	public LocalDate getdiainicial() {
		return diainicial;
	}

	public LocalDate getdiafinal() {
		return diafinal;
	}

	public LocalTime gethorainicial() {
		return horainicial;
	}

	public LocalTime gethorafinal() {
		return horafinal;
	}

	public Evento toevento() {
		return new Evento(this);
	}

    public Evento toEvento() {
		return new Evento(this);
	}
}
