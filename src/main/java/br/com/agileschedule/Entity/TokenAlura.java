package br.com.agileschedule.Entity;

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

	public TokenAlura() {
		super();
	}

	public TokenAlura(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
