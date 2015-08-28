package br.com.infnet.bomfilme.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.infnet.bomfilme.model.CarrinhoItem;
import br.com.infnet.bomfilme.model.Filme;

@ManagedBean(name="carrinhoBean")
@SessionScoped
public class CarrinhoBean {
	private List<CarrinhoItem> itens;
	
	@PostConstruct
	public void construct() {
		itens = new ArrayList<CarrinhoItem>();
	}
	
	public void incluirItemCarrinho(Filme filme, String tipoMidia) {
		CarrinhoItem item = new CarrinhoItem(filme, tipoMidia);
		itens.add(item);
	}
	
	public List<CarrinhoItem> getItens() {
		return itens;
	}
}
