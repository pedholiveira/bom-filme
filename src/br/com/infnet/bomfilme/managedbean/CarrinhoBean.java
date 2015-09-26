package br.com.infnet.bomfilme.managedbean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.infnet.bomfilme.model.CarrinhoItem;
import br.com.infnet.bomfilme.model.Usuario;
import br.com.infnet.bomfilme.service.CarrinhoService;

@ManagedBean(name="carrinhoBean")
@SessionScoped
public class CarrinhoBean {
	@ManagedProperty(value="#{userSessionBean}")
	private UserSessionBean userSessionBean;
	
	@Inject
	private CarrinhoService service;
	
	private List<CarrinhoItem> itens;
	
	@PostConstruct
	public void construct() {
		itens = new ArrayList<CarrinhoItem>();
	}
	
	public String alugarFilmes(Usuario usuario) {
		service.alugarFilmes(usuario, itens);
		itens.clear();
		
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
									"Filmes alugados com sucesso.", null));
		
		return "filmes";
	}
	
	public String calcularDataDevolucao() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public double calcularTotalAluguel() {
		return itens.stream()
					.mapToDouble(i -> i.getFilme().getPrecoAluguel())
					.sum();
	}
	
	public String validarAluguel() {
		if(userSessionBean.getUsuarioLogado() != null) {
			return "confirmar-aluguel";
		}
		
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, 
									"É necessário estar logado, para alugar um filme.", null));
		return null;
	}
	
	public List<CarrinhoItem> getItens() {
		return itens;
	}

	public UserSessionBean getUserSessionBean() {
		return userSessionBean;
	}

	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}
}
