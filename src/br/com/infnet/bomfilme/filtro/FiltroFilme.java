package br.com.infnet.bomfilme.filtro;

import br.com.infnet.bomfilme.model.Profissional;

/**
 * Filtro da busca de filmes.
 * 
 * @author Pedro Henrique
 */
public class FiltroFilme {
	private String nome;
	private String nomeOriginal;
	private String nomeDiretor;
	private Profissional ator = new Profissional();

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

	public String getNomeDiretor() {
		return nomeDiretor;
	}

	public void setNomeDiretor(String nomeDiretor) {
		this.nomeDiretor = nomeDiretor;
	}

	public Profissional getAtor() {
		return ator;
	}

	public void setAtor(Profissional ator) {
		this.ator = ator;
	}
}