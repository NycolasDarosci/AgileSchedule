package br.com.agileschedule.form;

import javax.validation.constraints.NotNull;

public class TokenAluraForm {

	@NotNull
	private String TokenAlura;

	public TokenAluraForm(@NotNull String tokenAlura) {
		super();
		TokenAlura = tokenAlura;
	}

	public void setTokenAlura(String tokenAlura) {
		TokenAlura = tokenAlura;
	}

}