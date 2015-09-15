package br.com.infnet.bomfilme.managedbean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.infnet.bomfilme.model.CarrinhoItem;
import br.com.infnet.bomfilme.model.Filme;
import br.com.infnet.bomfilme.model.Usuario;
import br.com.infnet.bomfilme.service.CarrinhoService;

@ManagedBean(name="carrinhoBean")
@SessionScoped
public class CarrinhoBean {
	@Inject
	private CarrinhoService service;
	
	private List<CarrinhoItem> itens;
	
	@PostConstruct
	public void construct() {
		itens = new ArrayList<CarrinhoItem>();
	}
	
	public void incluirItemCarrinho(Filme filme, String tipoMidia) {
		CarrinhoItem item = new CarrinhoItem(filme, tipoMidia);
		itens.add(item);
		
		FacesContext.getCurrentInstance().addMessage("lista-filmes", new FacesMessage(FacesMessage.SEVERITY_INFO, "Filme incluído no carrinho!", null));
	}
	
	public String alugarFilmes(Usuario usuario) {
		service.alugarFilmes(usuario, itens);
		itens.clear();
		
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
	
	public List<CarrinhoItem> getItens() {
		return itens;
	}
}
