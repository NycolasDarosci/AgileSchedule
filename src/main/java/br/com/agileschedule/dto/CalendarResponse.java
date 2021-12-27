package br.com.agileschedule.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CalendarResponse {

	private Long id;

	private String description;

	private String initialDay;

	private String finalDay;

	private String initialHour;

	private String finalHour;


}
