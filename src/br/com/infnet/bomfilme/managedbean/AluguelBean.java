package br.com.infnet.bomfilme.managedbean;

import java.time.LocalDate;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.infnet.bomfilme.model.Aluguel;

@ManagedBean(name="aluguelBean")
@ViewScoped
public class AluguelBean {
	@ManagedProperty(value="#{userSessionBean}")
	private UserSessionBean userSessionBean;

	public void estenderPrazoAluguel(Aluguel aluguel) {
		LocalDate dataDevolucao = aluguel.getDataDevolucao().plusDays(3);
		userSessionBean.getUsuarioLogado()
						.getFilmesAlugados()
						.stream()
						.filter(a -> a.equals(aluguel))
						.forEach(a -> a.setDataDevolucao(dataDevolucao));
		
		FacesContext.getCurrentInstance()
					.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
												"Prazo do aluguel estendido com sucesso!", null));
	}

	public List<Aluguel> listarAlugueisUsuario() {
		if(userSessionBean.getUsuarioLogado() != null) {
			return userSessionBean.getUsuarioLogado().getFilmesAlugados();
		}
		
		return null;
	}
	
	public UserSessionBean getUserSessionBean() {
		return userSessionBean;
	}

	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}
}
