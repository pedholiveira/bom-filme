package br.com.infnet.bomfilme.managedbean;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.infnet.bomfilme.filtro.FiltroFilme;
import br.com.infnet.bomfilme.model.CarrinhoItem;
import br.com.infnet.bomfilme.model.Exemplar;
import br.com.infnet.bomfilme.model.Filme;
import br.com.infnet.bomfilme.model.Profissional;
import br.com.infnet.bomfilme.model.Reserva;
import br.com.infnet.bomfilme.model.StatusExemplar;
import br.com.infnet.bomfilme.service.FilmeService;

@ManagedBean(name = "filmeBean")
@ViewScoped
public class FilmeBean {
	@ManagedProperty(value = "#{carrinhoBean}")
	private CarrinhoBean carrinhoBean;
	@ManagedProperty(value = "#{userSessionBean}")
	private UserSessionBean userSessionBean;
	
	@Inject
	private FiltroFilme filtro;
	@Inject
	private FilmeService service;
	@Inject
	private Reserva reserva;
	
	private List<Filme> filmes;

	private Date dataReserva;
	
	public void pesquisar() {
		filmes = service.pesquisarFilmes(filtro);
	}

	public Set<Profissional> lerAtores() {
		return service.listarAtores();
	}

	public long lerQuantidadeExemplares(Filme filme, String tipoMidia) {
		long qtd = filme.getExemplares()
								.stream()
								.filter(e -> e.getTipoMidia().equals(tipoMidia) && 
												e.getStatus().equals(StatusExemplar.DISPONIVEL))
								.count();
		return qtd;
	}

	public void incluirItemCarrinho(Filme filme, String tipoMidia) {
		CarrinhoItem item = new CarrinhoItem(filme, tipoMidia);
		carrinhoBean.getItens().add(item);
		
		FacesContext.getCurrentInstance().addMessage("lista-filmes", new FacesMessage(FacesMessage.SEVERITY_INFO, "Filme incluído no carrinho!", null));
	}
	
	public void iniciarReserva(Filme filme, String tipoMidia) {
		Exemplar exemplar = filme.getExemplares()
									.stream()
									.filter(e -> e.getTipoMidia().equals(tipoMidia) &&
													e.getStatus().equals(StatusExemplar.DISPONIVEL))
									.findFirst()
									.orElse(null);
		
		reserva.setFilme(filme);
		reserva.setExemplar(exemplar);
	}
	
	public void reservar() {
		Instant instant = Instant.ofEpochMilli(this.getDataReserva().getTime());
		LocalDate dataReserva = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
		
		reserva.setDataReserva(dataReserva);
		service.reservarFilme(reserva);
		
		userSessionBean.getUsuarioLogado().getReservas().add(reserva);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
									"Reserva efetuada!.", null));
	}
	
	public List<Filme> getFilmes() {
		return filmes;
	}

	public FiltroFilme getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroFilme filtro) {
		this.filtro = filtro;
	}

	public CarrinhoBean getCarrinhoBean() {
		return carrinhoBean;
	}

	public void setCarrinhoBean(CarrinhoBean carrinhoBean) {
		this.carrinhoBean = carrinhoBean;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public UserSessionBean getUserSessionBean() {
		return userSessionBean;
	}

	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}
}