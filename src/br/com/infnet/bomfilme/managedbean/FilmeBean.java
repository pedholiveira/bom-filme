package br.com.infnet.bomfilme.managedbean;

import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.infnet.bomfilme.filtro.FiltroFilme;
import br.com.infnet.bomfilme.model.Carrinho;
import br.com.infnet.bomfilme.model.CarrinhoItem;
import br.com.infnet.bomfilme.model.Filme;
import br.com.infnet.bomfilme.model.Profissional;
import br.com.infnet.bomfilme.service.FilmeService;

@ManagedBean(name = "filmeBean")
@ViewScoped
public class FilmeBean {
	@Inject
	private FiltroFilme filtro;
	
	@Inject
	private FilmeService service;

	private List<Filme> filmes;
	//TODO - Alterar o carrinho para um local com o escopo adequado.
	private Carrinho carrinho = new Carrinho(); 

	public void pesquisar() {
		filmes = service.pesquisarFilmes(filtro);
	}

	public Set<Profissional> lerAtores() {
		return service.listarAtores();
	}

	public long lerQuantidadeExemplares(Filme filme, String tipoMidia) {
		long qtd = filme.getExemplares()
								.stream()
								.filter(e -> e.getTipoMidia().equals(tipoMidia))
								.count();
		return qtd;
	}

	public void incluirItemCarrinho(Filme filme, String tipoMidia) {
		CarrinhoItem item = new CarrinhoItem(filme, tipoMidia);
		carrinho.getItens().add(item);
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public FiltroFilme getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroFilme filtro) {
		this.filtro = filtro;
	}
}