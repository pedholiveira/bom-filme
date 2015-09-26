package br.com.infnet.bomfilme.model;

import java.time.LocalDate;

/**
 * Representa uma reserva de aluguel feita por um {@link Usuario}.
 * 
 * @author Pedro Henrique
 */
public class Reserva {
	private Filme filme;
	private Exemplar exemplar;
	private LocalDate dataReserva;

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

}
