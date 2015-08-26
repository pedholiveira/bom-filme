package br.com.infnet.bomfilme.filtro;

/**
 * Filtro da busca de filmes.
 * 
 * @author Pedro Henrique
 */
public class FiltroFilme {
	private String nome;
	private String nomeOriginal;
	private String nomeDiretor;
	private String nomeAtor;

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

	public String getNomeAtor() {
		return nomeAtor;
	}

	public void setNomeAtor(String nomeAtor) {
		this.nomeAtor = nomeAtor;
	}
}