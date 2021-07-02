package br.com.agileschedule.form;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import br.com.agileschedule.entity.User;
import br.com.agileschedule.repository.UserRepository;

public class UserForm {

	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@NotBlank
	private String senha;

	public UserForm(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public UserForm() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setUserName(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public User toForm(UserRepository useR, @Valid UserForm userF) {
		User user = new User(nome, email, senha, null);
		useR.save(user);
		return user;
	}

}
