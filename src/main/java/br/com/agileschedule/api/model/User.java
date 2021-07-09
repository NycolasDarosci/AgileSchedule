package br.com.agileschedule.api.model;

import java.util.ArrayList;
import java.util.Collection;
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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.agileschedule.api.dto.UserDTO;


@Entity(name = "User")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "senha", nullable = false)
	private String senha;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "User_Has_Perfil",
		joinColumns = @JoinColumn(name = "idUser"),
		inverseJoinColumns = @JoinColumn(name = "idPerfil")
	)
	private List<Perfil> perfis = new ArrayList<Perfil>();

	@Column(name = "tokenAlura")
	private String tokenAlura;

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Evento> evento;

	@Column(name = "ativo")
	private boolean ativo;

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

	@Override
	public String getUsername() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	public void setSenha(String senha) {
		//Sempre que uma senha for definida, ela será criptografada.
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		this.senha = bCrypt.encode(senha);
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public UserDTO toDTO() {
		return new UserDTO(this.id, this.nome, this.email, this.tokenAlura);
	}
}
