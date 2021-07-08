package br.com.agileschedule.api.dto;

public class UserDTO {

	private Long id;
	private String nome;
	private String email;
	private String tokenAlura;

	public UserDTO(Long id, String nome, String email, String tokenAlura) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.tokenAlura = tokenAlura;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTokenAlura() {
		return this.tokenAlura;
	}

	public void setTokenAlura(String tokenAlura) {
		this.tokenAlura = tokenAlura;
	}
}
