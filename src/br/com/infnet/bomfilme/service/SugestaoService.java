package br.com.infnet.bomfilme.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.infnet.bomfilme.model.Sugestao;
import br.com.infnet.bomfilme.repository.SugestaoRepository;

/**
 * Classe respons�vel pela manipula��o das regras de neg�cio da classe
 * {@link Sugestao}.
 * 
 * @author Pedro Henrique
 */
@RequestScoped
public class SugestaoService {
	@Inject
	private SugestaoRepository repository;
	
	/**
	 * Grava uma sugest�o de um cliente no banco.
	 * 
	 * @param sugestao - Um objeto do tipo {@link Sugestao}.
	 */
	public void gravar(Sugestao sugestao) {
		repository.gravar(sugestao);
	}
}
