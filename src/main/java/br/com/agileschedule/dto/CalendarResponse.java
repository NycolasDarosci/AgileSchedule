package br.com.agileschedule.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CalendarResponse {

	private String id;

	private String description;

	private LocalDate initialDay;

	private LocalDate finalDay;

	private LocalTime initialHour;

	private LocalTime finalHour;




}
