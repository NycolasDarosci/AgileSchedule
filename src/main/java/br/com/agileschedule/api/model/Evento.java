package br.com.agileschedule.api.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.agileschedule.api.dto.EventoDTO;
import br.com.agileschedule.api.form.EventoForm;

@Entity(name = "Evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name= "titulo")
	private String titulo;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "dia_inicial")
	private LocalDate diainicial;

	@Column(name = "dia_final")
	private LocalDate diafinal;

	@Column(name = "hora_inicial")
	private LocalTime horainicial;

	@Column(name = "hora_final")
	private LocalTime horafinal;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Evento(EventoForm eForm) {

		this.diainicial = eForm.getDiaInicial();
		this.diafinal = eForm.getDiaFinal();
		this.horainicial = eForm.getHoraInicial();
		this.horafinal = eForm.getHoraFinal();
		this.descricao = eForm.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDiaInicial() {
		return diainicial;
	}

	public void setDiaInicial(LocalDate diaInicial) {
		this.diainicial = diaInicial;
	}

	public LocalDate getDiaFinal() {
		return diafinal;
	}

	public void setDiaFinal(LocalDate diaFinal) {
		this.diafinal = diaFinal;
	}

	public LocalTime getHoraInicial() {
		return horainicial;
	}

	public void setHoraInicial(LocalTime horaInicial) {
		this.horainicial = horaInicial;
	}

	public LocalTime getHoraFinal() {
		return horafinal;
	}

	public void setHoraFinal(LocalTime horaFinal) {
		this.horafinal = horaFinal;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public EventoDTO toDTO() {
		return new EventoDTO(this);
	}
	
	
	public static List<EventoDTO> toListDTO(List<Evento> eventos) {

        List<EventoDTO> eventosDTO = new ArrayList<EventoDTO>();
        for (Evento evento : eventos) {
            
            EventoDTO eventoDTO = new EventoDTO();
            
            eventoDTO.setId(evento.id);
            eventoDTO.setTitulo(evento.titulo);
            eventoDTO.setDescricao(evento.descricao);
            eventoDTO.setDiaInicial(evento.diainicial);
            eventoDTO.setDiaFinal(evento.diafinal);
            eventoDTO.setHoraInicial(evento.horainicial);
            eventoDTO.setHoraFinal(evento.horafinal);

            eventosDTO.add(eventoDTO);
        }

        return eventosDTO;
    }
}
