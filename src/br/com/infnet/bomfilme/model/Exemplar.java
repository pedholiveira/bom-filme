package br.com.infnet.bomfilme.model;

import java.util.Calendar;

/**
 * Representa um exemplar de um filme.
 * 
 * @author Pedro Henrique
 */
public class Exemplar {
	private Calendar dataAquisicao;
	private String tipoMidia; //TODO - Transformar tipo de midia em um enum.
	private Double valorAquisicao;
	private boolean alugado = false;

	public Exemplar() {
	}

	public Exemplar(Calendar dataAquisicao, String tipoMidia,
			Double valorAquisicao) {
		this.dataAquisicao = dataAquisicao;
		this.tipoMidia = tipoMidia;
		this.valorAquisicao = valorAquisicao;
	}

	public Calendar getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Calendar dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public String getTipoMidia() {
		return tipoMidia;
	}

	public void setTipoMidia(String tipoMidia) {
		this.tipoMidia = tipoMidia;
	}

	public Double getValorAquisicao() {
		return valorAquisicao;
	}

	public void setValorAquisicao(Double valorAquisicao) {
		this.valorAquisicao = valorAquisicao;
	}

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
}
