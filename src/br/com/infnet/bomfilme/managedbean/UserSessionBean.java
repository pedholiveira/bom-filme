package br.com.infnet.bomfilme.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.infnet.bomfilme.model.Usuario;

/**
 * JSF Session Bean para controle de autenticação. 
 * 
 * @author Pedro Henrique
 */
@ManagedBean(name="userSessionBean")
@SessionScoped
public class UserSessionBean {
	private Usuario usuarioLogado;
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
}