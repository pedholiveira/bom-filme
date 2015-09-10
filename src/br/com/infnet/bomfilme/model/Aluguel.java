package br.com.infnet.bomfilme.model;

import java.time.LocalDate;

public class Aluguel {
	private Filme filme;
	private String tipoMidia;
	private LocalDate dataAluguel;
	private LocalDate dataDevolucao;

	public Aluguel() {
	}
	
	public Aluguel(Filme filme, String tipoMidia) {
		this.filme = filme;
		this.tipoMidia = tipoMidia;
		this.dataAluguel = LocalDate.now();
		this.dataDevolucao = LocalDate.now().plusDays(3);
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public String getTipoMidia() {
		return tipoMidia;
	}

	public void setTipoMidia(String tipoMidia) {
		this.tipoMidia = tipoMidia;
	}

	public LocalDate getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(LocalDate dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

}