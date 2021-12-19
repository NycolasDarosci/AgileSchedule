package br.com.agileschedule.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CalenderRequest {

	@NotBlank
	private String description;

	private LocalDate initialDay;

	private LocalDate finalDay;

	private LocalTime initialHour;

	private LocalTime finalHour;


}
