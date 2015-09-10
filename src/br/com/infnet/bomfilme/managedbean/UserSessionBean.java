package br.com.infnet.bomfilme.managedbean;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.infnet.bomfilme.model.Login;
import br.com.infnet.bomfilme.model.Usuario;
import br.com.infnet.bomfilme.service.UsuarioService;

/**
 * JSF Session Bean para controle de autenticação. 
 * 
 * @author Pedro Henrique
 */
@ManagedBean(name="userSessionBean")
@SessionScoped
public class UserSessionBean {
	private Usuario usuarioLogado;
	
	@Inject
	private Login login;
	
	@Inject
	private UsuarioService service;
	
	/**
	 * Verifica se existe algum usuário logado ou não no sistema.
	 * 
	 * @return True se existir algum {@link Usuario} logado, e false caso contrário.
	 */
	public boolean isLogado() {
		if(usuarioLogado != null)
			return true;
		
		return false;
	}
	
	/**
	 * Realiza o login a partir dos dados de {@link Login} inseridos.
	 */
	public String logar() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String,String> params = context.getExternalContext().getRequestParameterMap();
		String proceed = params.get("proceed");
		
		Usuario usuario = service.getUsuarioByLogin(login);
		if(usuario != null) {
			usuarioLogado = usuario;
			
			if(proceed != null) {
				return proceed;
			}
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
														"Login ou senha inválidos.", null));
		}
		
		return "";
	}
	
	/**
	 * Realiza o logout do usuário no sistema.
	 */
	public void logout() {
		usuarioLogado = null;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public Login getLogin() {
		return login;
	}
	
	public void setLogin(Login login) {
		this.login = login;
	}
}
