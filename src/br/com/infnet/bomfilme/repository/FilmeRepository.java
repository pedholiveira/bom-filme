package br.com.infnet.bomfilme.repository;

import java.util.List;
import java.util.Set;

import br.com.infnet.bomfilme.filtro.FiltroFilme;
import br.com.infnet.bomfilme.model.Exemplar;
import br.com.infnet.bomfilme.model.Filme;
import br.com.infnet.bomfilme.model.Profissional;
import br.com.infnet.bomfilme.model.Reserva;
import br.com.infnet.bomfilme.model.Usuario;

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
	 * @return Um {@link List} de {@link Filme}.
	 */
	public List<Filme> pesquisarFilmes(FiltroFilme filtro);
	
	/**
	 * Retorna todos os atores cadastrados.
	 * 
	 * @return Um {@link List} de {@link Profissional}.
	 */
	public Set<Profissional> listarAtores();
	
	/**
	 * Retorna um diretor a partir do seu nome.
	 * 
	 * @param nome
	 * @return Um objeto do tipo {@link Profissional}.
	 */
	public Profissional buscarDiretorPorNome(String nome);

	/**
	 * Retorna um ator a partir do seu nome.
	 * 
	 * @param nome
	 * @return Um objeto do tipo {@link Profissional}.
	 */
	public Profissional buscarAtorPorNome(String nome);
	
	/**
	 * Atualiza as informações de um filme para ser feito o aluguel.
	 * 
	 * @param usuario
	 * @param filme
	 * @param tipoMidia
	 */
	public void alugarFilmes(Usuario usuario, Filme filme, String tipoMidia);

	/**
	 * Realiza a reserva do {@link Exemplar} de um {@link Filme}.
	 * 
	 * @param reserva - Objeto do tipo {@link Reserva}
	 */
	public void reservarFilme(Reserva reserva);
}
