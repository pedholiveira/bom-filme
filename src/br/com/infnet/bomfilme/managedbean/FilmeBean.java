package br.com.infnet.bomfilme.managedbean;

import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.infnet.bomfilme.filtro.FiltroFilme;
import br.com.infnet.bomfilme.model.Filme;
import br.com.infnet.bomfilme.model.Profissional;
import br.com.infnet.bomfilme.service.FilmeService;

@ManagedBean(name = "filmeBean")
@ViewScoped
public class FilmeBean {
	private List<Filme> filmes;
	
	@Inject
	private FiltroFilme filtro;

	@Inject
	private FilmeService service;
	
	public void pesquisar() {
		filmes = service.pesquisarFilmes(filtro);
	}

	public Set<Profissional> lerAtores() {
		return service.listarAtores();
	}
	
	public long lerQuantidadeExemplares(Filme filme, String tipoMidia) {
		return service.lerQuantidadeExemplares(filme, tipoMidia);
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