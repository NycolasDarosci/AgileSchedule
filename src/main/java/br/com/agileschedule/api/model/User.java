package br.com.agileschedule.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.agileschedule.api.dto.UserDTO;

@Entity(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "senha", nullable = false)
	private String senha;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "User_Has_Perfil", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "perfil_id"))
	private List<Perfil> perfis = new ArrayList<Perfil>();

	@Column(name = "token_alura")
	private String tokenAlura;

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Evento> eventos = new ArrayList<Evento>();

	@Column(name = "ativo", nullable = false)
	private boolean ativo = true;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String setSenha(String senhaa) {
		// Sempre que uma senha for definida, ela será criptografada.
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		return this.senha = bCrypt.encode(senhaa);
	}

	public String getTokenAlura() {
		return this.tokenAlura;
	}

	public void setTokenAlura(String tokenAlura) {
		this.tokenAlura = tokenAlura;
	}

	public List<Perfil> getPerfis() {
		return this.perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public User(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public User() {
	}

	public UserDTO toDTO() {
		return new UserDTO(this.id, this.nome, this.email, this.tokenAlura);
	}
}
