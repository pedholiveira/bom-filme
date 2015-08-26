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

	// TODO - Incluir atributo para lista de dependentes.
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

}
