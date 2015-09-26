package br.com.infnet.bomfilme.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.infnet.bomfilme.model.Login;
import br.com.infnet.bomfilme.model.Usuario;
import br.com.infnet.bomfilme.service.UsuarioService;

/**
 * ManagedBean responsável por fazer o login e o logout de um usuário no
 * sistema.
 * 
 * @author Pedro Henrique
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {
	@ManagedProperty(value = "#{userSessionBean}")
	private UserSessionBean userSessionBean;

	@Inject
	private Login login;
	@Inject
	private UsuarioService service;

	/**
	 * Realiza o login a partir dos dados de {@link Login} inseridos.
	 */
	public void logar() {
		FacesContext context = FacesContext.getCurrentInstance();

		Usuario usuario = service.getUsuarioByLogin(login);
		if (usuario != null) {
			userSessionBean.setUsuarioLogado(usuario);
		} else {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Login ou senha inválidos.",
					null));
		}
	}

	/**
	 * Realiza o logout do usuário no sistema.
	 */
	public String logout() {
		userSessionBean.setUsuarioLogado(null);

		return "filmes?faces-redirect=true";
	}

	/**
	 * Verifica se existe algum usuário logado no sistema.
	 * 
	 * @return True se existir algum {@link Usuario} logado, e false caso contrário.
	 */
	public boolean isLogado() {
		return userSessionBean.getUsuarioLogado() != null;
	}
	
	public UserSessionBean getUserSessionBean() {
		return userSessionBean;
	}

	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
}
