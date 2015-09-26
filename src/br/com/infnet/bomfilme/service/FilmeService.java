package br.com.infnet.bomfilme.service;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.infnet.bomfilme.filtro.FiltroFilme;
import br.com.infnet.bomfilme.model.Exemplar;
import br.com.infnet.bomfilme.model.Filme;
import br.com.infnet.bomfilme.model.Profissional;
import br.com.infnet.bomfilme.model.Reserva;
import br.com.infnet.bomfilme.repository.FilmeRepository;

/**
 * Classe para manipulação das regras de negócio referentes a um {@link Filme}.
 * 
 * @author Pedro Henrique
 */
@RequestScoped
public class FilmeService {
	@Inject
	private FilmeRepository repository;

	/**
	 * Lista os filmes cadastrados a partir de um filtro.
	 * 
	 * @param filtro
	 * @return Um {@link List} de {@link Filme}
	 */
	public List<Filme> pesquisarFilmes(FiltroFilme filtro) {
		return repository.pesquisarFilmes(filtro);
	}

	/**
	 * Retorna todos os atores cadastrados.
	 * 
	 * @return Um {@link Set} de {@link Profissional}
	 */
	public Set<Profissional> listarAtores() {
		return repository.listarAtores();
	}
	
	/**
	 * Realiza a reserva do {@link Exemplar} de um {@link Filme}.
	 * 
	 * @param reserva - Objeto do tipo {@link Reserva}
	 */
	public void reservarFilme(Reserva reserva) {
		repository.reservarFilme(reserva);
	}
}
