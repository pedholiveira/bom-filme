package br.com.infnet.bomfilme.model;

/**
 * Representa um profissional participante de um filme.
 * 
 * @author Pedro Henrique
 */
public class Profissional {
	private String nome;
	private String dataNascimento;
	private String paisOrigem;
	private String papel; // TODO - Verificar se esta em local correto.

	public Profissional() {
	}

	public Profissional(String nome, String dataNascimento, String paisOrigem, String papel) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.paisOrigem = paisOrigem;
		this.papel = papel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public String getPapel() {
		return papel;
	}
	
	public void setPapel(String papel) {
		this.papel = papel;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (((Profissional) obj).getNome().equals(this.nome)) {
			if (((Profissional) obj).getDataNascimento().equals(this.dataNascimento)) {
				if (((Profissional) obj).getPaisOrigem().equals(this.paisOrigem)) {
					if (((Profissional) obj).getPapel().equals(this.papel)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public int hashCode() {
		int seed = 31;
		int hash = 1;

		hash = seed * hash + ((nome == null) ? 0 : nome.hashCode());
		hash = seed * hash + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		hash = seed * hash + ((paisOrigem == null) ? 0 : paisOrigem.hashCode());
		hash = seed * hash + ((papel == null) ? 0 : papel.hashCode());
		
		return hash;
	}

}