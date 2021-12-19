package br.com.agileschedule.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Calender {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "diaInicial")
	private LocalDate initialDay;

	@Column(name = "diaFinal")
	private LocalDate finalDay;

	@Column(name = "hrInicial")
	private LocalTime initialHour;

	@Column(name = "hrFinal")
	private LocalTime finalHour;

	@Column(name = "descricao")
	private String description;

}
