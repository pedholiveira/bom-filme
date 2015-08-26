package br.com.infnet.bomfilme.model;

import java.util.Calendar;
import java.util.List;

/**
 * Representa uma locação feita.
 * 
 * @author Pedro Henrique
 */
public class Locacao {
	private Usuario usuario;
	private List<Exemplar> exemplares;
	private Calendar dataAluguel;
	private Calendar dataDevolucao;
	private Double valorTotal;
	private String desconto;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Exemplar> getExemplares() {
		return exemplares;
	}

	public void setExemplares(List<Exemplar> exemplares) {
		this.exemplares = exemplares;
	}

	public Calendar getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(Calendar dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getDesconto() {
		return desconto;
	}

	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}

}
