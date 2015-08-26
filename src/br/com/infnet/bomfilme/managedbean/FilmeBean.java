package br.com.infnet.bomfilme.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.infnet.bomfilme.filtro.FiltroFilme;
import br.com.infnet.bomfilme.model.Filme;
import br.com.infnet.bomfilme.repository.FilmeRepository;

@ManagedBean(name = "filmeBean")
@ViewScoped
public class FilmeBean {
	private List<Filme> filmes;
	
	@Inject
	private FiltroFilme filtro;

	@Inject
	private FilmeRepository repository;
	
	public void pesquisar() {
		filmes = repository.pesquisarFilmes(filtro);
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