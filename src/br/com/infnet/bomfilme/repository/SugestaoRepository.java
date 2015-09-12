package br.com.infnet.bomfilme.repository;

import br.com.infnet.bomfilme.model.Sugestao;

/**
 * Repositório de dados da classe {@link Sugestao}.
 * 
 * @author Pedro Henrique
 */
public interface SugestaoRepository {
	
	/**
	 * Grava uma sugestão de um cliente no banco.
	 * 
	 * @param sugestao - Objeto do tipo {@link Sugestao}
	 */
	public void gravar(Sugestao sugestao);
}
