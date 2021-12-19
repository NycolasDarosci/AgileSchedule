package br.com.agileschedule.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRequest {

	@NotBlank
	private String userName;

	@NotBlank
	private String password;
	

}
