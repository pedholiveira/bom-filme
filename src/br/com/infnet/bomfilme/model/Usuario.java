package br.com.infnet.bomfilme.model;

import java.util.List;

/**
 * Representa um usuário do sistema.
 * 
 * @author Pedro Henrique
 */
public class Usuario {
	private String nome;
	private Endereco endereco;
	private String cpf;
	private String email;
	private String identidade; // TODO - Mudar para lista de identidades.
	private List<String> telefones;
	private Login login;
	// TODO - Incluir atributo para lista de dependentes.
	
	public Usuario() {
	}
	
	public Usuario(String nome, Endereco endereco, String cpf, String email,
			String identidade, List<String> telefones, Login login) {
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.email = email;
		this.identidade = identidade;
		this.telefones = telefones;
		this.login = login;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
