package br.com.infnet.bomfilme.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.infnet.bomfilme.model.Sugestao;
import br.com.infnet.bomfilme.service.SugestaoService;

/**
 * Backing Bean da tela de sugestão de filmes.
 * 
 * @author Pedro Henrique
 */
@ManagedBean(name="sugestaoBean")
@RequestScoped
public class SugestaoBean {
	@ManagedProperty(value="#{userSessionBean}")
	private UserSessionBean userSessionBean;
	
	@Inject
	private SugestaoService service;
	@Inject
	private Sugestao sugestao;
	
	/**
	 * Grava a sugestão enviada pelo cliente no banco.
	 */
	public void gravar() {
		sugestao.setUsuario(userSessionBean.getUsuarioLogado());
		service.gravar(sugestao);
		FacesContext.getCurrentInstance().addMessage(null, 
								new FacesMessage(FacesMessage.SEVERITY_INFO, 
													"Obrigado pela sugestão!.", null));
	}

	public Sugestao getSugestao() {
		return sugestao;
	}

	public void setSugestao(Sugestao sugestao) {
		this.sugestao = sugestao;
	}

	public UserSessionBean getUserSessionBean() {
		return userSessionBean;
	}

	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}
}
