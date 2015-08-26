package br.com.infnet.bomfilme.repository;

import java.util.List;
import java.util.Set;

import br.com.infnet.bomfilme.filtro.FiltroFilme;
import br.com.infnet.bomfilme.model.Exemplar;
import br.com.infnet.bomfilme.model.Filme;
import br.com.infnet.bomfilme.model.Profissional;

/**
 * Repositório de dados da classe {@link Filme}.
 * 
 * @author Pedro Henrique
 */
public interface FilmeRepository {
	/**
	 * Lista os filmes cadastrados a partir de um filtro. 
	 * 
	 * @param filtro
	 * @return Um {@link List} de {@link Filme}
	 */
	public List<Filme> pesquisarFilmes(FiltroFilme filtro);
	
	/**
	 * Retorna todos os atores cadastrados.
	 * 
	 * @return Um {@link List} de {@link Profissional}
	 */
	public Set<Profissional> listarAtores();
	
	/**
	 * Retorna, a partir de um filme, uma lista com todos os exemplares cadastrados.
	 * 
	 * @return Um {@link List} de {@link Exemplar}
	 */
	public List<Exemplar> lerExemplares(Filme filme);
}
