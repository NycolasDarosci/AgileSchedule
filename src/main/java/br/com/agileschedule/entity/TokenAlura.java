package br.com.agileschedule.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TokenAlura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "TokenAlura")
	private String TokenAlura;

	@OneToOne
	private User user;

	public TokenAlura() {
		super();
	}

	public TokenAlura(Long id, String tokenAlura) {
		super();
		this.id = id;
		TokenAlura = tokenAlura;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTokenAlura() {
		return TokenAlura;
	}

	public void setTokenAlura(String tokenAlura) {
		TokenAlura = tokenAlura;
	}

}
