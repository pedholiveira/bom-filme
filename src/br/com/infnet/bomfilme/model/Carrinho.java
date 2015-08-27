package br.com.infnet.bomfilme.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa o carrinho de compras usado para o aluguel de filmes.
 * 
 * @author Pedro Henrique
 */
public class Carrinho {
	private List<CarrinhoItem> itens;
	
	public Carrinho() {
		itens = new ArrayList<CarrinhoItem>();
	}

	public List<CarrinhoItem> getItens() {
		return itens;
	}

	public void setItens(List<CarrinhoItem> itens) {
		this.itens = itens;
	}
}
