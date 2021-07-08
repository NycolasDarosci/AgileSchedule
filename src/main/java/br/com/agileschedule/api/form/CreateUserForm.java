package br.com.agileschedule.api.form;

import javax.validation.constraints.NotBlank;

import br.com.agileschedule.api.model.User;
import javassist.NotFoundException;

public class CreateUserForm {

	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@NotBlank
	private String senha;

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public User toUser() throws NotFoundException {
		User user = new User();
		user.setNome(this.nome);
		user.setEmail(this.email);
		user.setSenha(this.senha);
		return user;
	}
}
