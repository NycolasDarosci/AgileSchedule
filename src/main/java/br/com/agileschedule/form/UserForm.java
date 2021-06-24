package br.com.agileschedule.form;

import br.com.agileschedule.entity.User;
import br.com.agileschedule.repository.UserRepository;

public class UserForm {

	private String nome;
	private String userName;
	private String senha;

	public UserForm(String nome, String userName, String senha) {
		super();
		this.nome = nome;
		this.userName = userName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public User toForm(UserRepository useR) {
		User user = new User(nome, userName, senha);
		useR.save(user);
		return user;
	}

}
