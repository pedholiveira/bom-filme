package br.com.infnet.bomfilme.model;

/**
 * Representa um tipo de m�dia de um filme.
 * 
 * @author Pedro Henrique
 */
//TODO - Pedro Henrique - Transformar o tipo de m�dia em um enum.
public class Midia {
	private String tipo;
	private Integer quantidade;

	public Midia() {
	}

	public Midia(String tipo, Integer quantidade) {
		this.tipo = tipo;
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
