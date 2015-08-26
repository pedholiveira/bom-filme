package br.com.infnet.bomfilme.model;

import java.util.List;

/**
 * Entidade relacionada aos filmes cadastrados
 * 
 * @author Pedro Henrique
 */
public class Filme {
	private String nome;
	private String nomeOriginal;
	private String anoProducao;
	private String duracao;
	private String categoria;
	private Integer censura;
	private String estudioPrincipal;
	private Double precoAluguel;
	private List<Profissional> profissionais;

	public Filme() {
	}

	public Filme(String nome, String nomeOriginal, String anoProducao,
			String duracao, String categoria, Integer censura,
			String estudioPrincipal, Double precoAluguel,
			List<Profissional> profissionais) {
		this.nome = nome;
		this.nomeOriginal = nomeOriginal;
		this.anoProducao = anoProducao;
		this.duracao = duracao;
		this.categoria = categoria;
		this.censura = censura;
		this.estudioPrincipal = estudioPrincipal;
		this.precoAluguel = precoAluguel;
		this.profissionais = profissionais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeOriginal() {
		return nomeOriginal;
	}

	public void setNomeOriginal(String nomeOriginal) {
		this.nomeOriginal = nomeOriginal;
	}

	public String getAnoProducao() {
		return anoProducao;
	}

	public void setAnoProducao(String anoProducao) {
		this.anoProducao = anoProducao;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getCensura() {
		return censura;
	}

	public void setCensura(Integer censura) {
		this.censura = censura;
	}

	public String getEstudioPrincipal() {
		return estudioPrincipal;
	}

	public void setEstudioPrincipal(String estudioPrincipal) {
		this.estudioPrincipal = estudioPrincipal;
	}

	public Double getPrecoAluguel() {
		return precoAluguel;
	}

	public void setPrecoAluguel(Double precoAluguel) {
		this.precoAluguel = precoAluguel;
	}

	public List<Profissional> getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}
	
	//TODO - Finalizar equals.
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(this.nomeOriginal.equals(((Filme) obj).getNomeOriginal())) {
			return true;
		}
		
		return false;
	}
}