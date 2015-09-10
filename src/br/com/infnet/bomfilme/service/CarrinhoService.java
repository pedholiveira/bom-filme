package br.com.infnet.bomfilme.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.infnet.bomfilme.model.CarrinhoItem;
import br.com.infnet.bomfilme.model.Filme;
import br.com.infnet.bomfilme.model.Usuario;
import br.com.infnet.bomfilme.repository.FilmeRepository;

/**
 * Classe para manipulação das regras de negócio referentes a um {@link Filme}.
 * 
 * @author Pedro Henrique
 */
@RequestScoped
public class CarrinhoService {
	@Inject
	private FilmeRepository repository;
	
	/**
	 * Realiza o aluguel dos itens presentes no carrinho.
	 * 
	 * @param itensCarrinho
	 */
	public void alugarFilmes(Usuario usuario, List<CarrinhoItem> itensCarrinho) {
		for (CarrinhoItem item : itensCarrinho) {
			repository.alugarFilmes(usuario, item.getFilme(), item.getTipoMidia());
		}
	}
}
