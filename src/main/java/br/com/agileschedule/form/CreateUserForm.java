package br.com.agileschedule.form;

import javax.validation.constraints.NotBlank;

import br.com.agileschedule.model.User;

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
	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public User toUser() {
		User user = new User();
		user.setNome(this.nome);
		user.setEmail(this.email);
		//Senha criptografada no método setSenha
		user.setSenha(this.senha);
		return user;
	}
}
