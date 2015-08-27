package br.com.infnet.bomfilme.model;

/**
 * Representa um item do carrinho de compras.
 *  
 * @author Pedro Henrique
 */
public class CarrinhoItem {
	private Filme filme;
	private String tipoMidia;

	public CarrinhoItem() {
	}
	
	public CarrinhoItem(Filme filme, String tipoMidia) {
		this.filme = filme;
		this.tipoMidia = tipoMidia;
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
}
