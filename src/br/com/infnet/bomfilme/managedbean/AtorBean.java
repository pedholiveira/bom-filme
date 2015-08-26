package br.com.infnet.bomfilme.managedbean;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.com.infnet.bomfilme.model.Profissional;
import br.com.infnet.bomfilme.repository.FilmeRepository;

@ManagedBean(name="atorBean")
@RequestScoped
public class AtorBean {
	private Set<Profissional> atores;
	
	@Inject
	private FilmeRepository repository;

	@PostConstruct
	public void lerAtores() {
		atores = repository.listarAtores();
	}

	public Set<Profissional> getAtores() {
		return atores;
	}

	public void setAtores(Set<Profissional> atores) {
		this.atores = atores;
	}
}
