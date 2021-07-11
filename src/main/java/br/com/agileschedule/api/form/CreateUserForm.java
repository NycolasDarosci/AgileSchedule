package br.com.agileschedule.api.form;

import javax.validation.constraints.NotBlank;

import br.com.agileschedule.api.model.User;
import br.com.agileschedule.api.repository.PerfilRepository;
import br.com.agileschedule.api.repository.UserRepository;
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
	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public User toUser(UserRepository userRepository, PerfilRepository perfilRepository) throws NotFoundException {
		User user = new User(nome, email, senha);
		user.getPerfis().add(perfilRepository.findByDescricao("Cliente").get());
		userRepository.save(user);
		return user;
	}

	

	
}
