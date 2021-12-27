package br.com.agileschedule.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "user")
	private String userName;

	@Column(name = "senha")
	private String password;

}
