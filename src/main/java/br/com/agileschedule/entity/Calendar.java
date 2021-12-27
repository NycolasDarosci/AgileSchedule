package br.com.agileschedule.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Calendar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "diaInicial")
	private String initialDay;

	@Column(name = "diaFinal")
	private String finalDay;

	@Column(name = "hrInicial")
	private String initialHour;

	@Column(name = "hrFinal")
	private String finalHour;

	@Column(name = "descricao")
	private String description;

}
