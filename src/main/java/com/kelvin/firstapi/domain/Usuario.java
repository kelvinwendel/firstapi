package com.kelvin.firstapi.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 * Classe para representação de Usuário no domínio de negócio.
 */
@Entity(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "O campo nome é obrigatório")
	@Length(min = 3, max = 75, message = "O nome deve conter 3 a 75 caracteres")
	private String nome;

	@NotEmpty(message = "O campo login é obrigatório")
	@Length(min = 3, max = 20, message = "O login deve conter 3 a 20 caracteres")
	private String login;

	@NotEmpty(message = "O campo senha é obrigatório")
	@Length(min = 6, max = 20, message = "A senha deve conter 6 a 20 caracteres")
	private String senha;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nome, String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
