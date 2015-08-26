package br.com.infnet.bomfilme.service;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.infnet.bomfilme.filtro.FiltroFilme;
import br.com.infnet.bomfilme.model.Filme;
import br.com.infnet.bomfilme.model.Profissional;
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
	 * Retorna a quantidade de exemplares de um tipo de mída que um filme tem.
	 * 
	 * @return
	 */
	public long lerQuantidadeExemplares(Filme filme, String tipoMidia) {
		long qtd = repository.lerExemplares(filme).stream()
				.filter(e -> e.getFilme().equals(filme))
				.filter(e -> e.getTipoMidia().equals(tipoMidia)).count();

		return qtd;
	}
}
