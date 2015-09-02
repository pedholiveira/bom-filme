package br.com.infnet.bomfilme.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import br.com.infnet.bomfilme.model.Login;
import br.com.infnet.bomfilme.model.Usuario;
import br.com.infnet.bomfilme.service.UsuarioService;

/**
 * JSF Session Bean para controle de autentica��o. 
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
	 * Verifica se existe algum usu�rio logado ou n�o no sistema.
	 * 
	 * @return True se existir algum {@link Usuario} logado, e false caso contr�rio.
	 */
	public boolean isLogado() {
		if(usuarioLogado != null)
			return true;
		
		return false;
	}
	
	/**
	 * Realiza o login a partir dos dados de {@link Login} inseridos.
	 */
	public void logar() {
		Usuario usuario = service.getUsuarioByLogin(login);
		
		if(usuario != null) {
			usuarioLogado = usuario;
		} else {
			//TODO - Exibir mensagem de erro ao usu�rio.
		}
	}
	
	/**
	 * Realiza o logout do usu�rio no sistema.
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
