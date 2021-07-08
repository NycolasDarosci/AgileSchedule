package br.com.agileschedule.api.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.agileschedule.api.dto.UserDTO;
import br.com.agileschedule.api.repository.TipoUserRepository;
import javassist.NotFoundException;

@Entity(name = "User")
public class User implements UserDetails {

	@Autowired
	TipoUserRepository tipoUserRepository;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "senha", nullable = false)
	private String senha;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "User_Has_TipoUser",
		joinColumns = @JoinColumn(name = "idUser"),
		inverseJoinColumns = @JoinColumn(name = "idTipoUser")
	)
	private List<TipoUser> tipoUser = new ArrayList<TipoUser>();

	@Column(name = "tokenAlura")
	private String tokenAlura;

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private Evento evento;

	@Column(name = "ativo")
	private boolean ativo;

	public User() throws NotFoundException {
		//Ao criar um usuário, por padrão seu tipo de usuário 
		//será definido como usuário Comum
		Optional<TipoUser> tipo = tipoUserRepository.findByDescricao("comum");
		if(tipo.isEmpty()){
			//Caso não tenha feito a inserção primária no banco de dados
			//será jogada uma exception
			throw new NotFoundException("TipoUsuario comum não encontrado, realize a "+
			"inserção no banco de dados.");
		}
		this.tipoUser.add(tipo.get());
	 }

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

	public List<TipoUser> getTipoUser() {
		return this.tipoUser;
	}

	public void setTipoUser(List<TipoUser> tipoUser) {
		this.tipoUser = tipoUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.tipoUser;
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
