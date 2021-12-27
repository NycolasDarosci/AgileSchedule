package br.com.agileschedule.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CalendarRequest {

    @NotBlank
    private String description;

    @NotBlank
    private String initialDay;

    @NotBlank
    private String finalDay;

    @NotBlank
    private String initialHour;

    @NotBlank
    private String finalHour;


}
