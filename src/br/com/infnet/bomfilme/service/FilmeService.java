package br.com.infnet.bomfilme.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import br.com.infnet.bomfilme.dto.MidiaAlugadaDTO;
import br.com.infnet.bomfilme.filtro.FiltroFilme;
import br.com.infnet.bomfilme.filtro.FiltroMidiasAlugadas;
import br.com.infnet.bomfilme.model.Aluguel;
import br.com.infnet.bomfilme.model.Exemplar;
import br.com.infnet.bomfilme.model.Filme;
import br.com.infnet.bomfilme.model.Profissional;
import br.com.infnet.bomfilme.model.Reserva;
import br.com.infnet.bomfilme.model.Usuario;
import br.com.infnet.bomfilme.repository.FilmeRepository;
import br.com.infnet.bomfilme.repository.UsuarioRepository;

/**
 * Classe para manipulação das regras de negócio referentes a um {@link Filme}.
 * 
 * @author Pedro Henrique
 */
@RequestScoped
public class FilmeService {
	@Inject
	private FilmeRepository repository;
	@Inject
	private UsuarioRepository usuarioRepository;

	/**
	 * Lista os filmes cadastrados a partir de um filtro.
	 * 
	 * @param filtro
	 * @return Um {@link List} de {@link Filme}
	 */
	public List<Filme> pesquisarFilmes(FiltroFilme filtro) {
		return repository.pesquisarFilmes(filtro);
	}

	/**
	 * Retorna todos os atores cadastrados.
	 * 
	 * @return Um {@link Set} de {@link Profissional}
	 */
	public Set<Profissional> listarAtores() {
		return repository.listarAtores();
	}
	
	/**
	 * Realiza a reserva do {@link Exemplar} de um {@link Filme}.
	 * 
	 * @param reserva - Objeto do tipo {@link Reserva}
	 */
	public void reservarFilme(Reserva reserva) {
		repository.reservarFilme(reserva);
	}

	/**
	 * Pesquisa todas os alugueis correntes da locadora em uma faixa de data.
	 * 
	 * @param filtroMidiasAlugadas
	 * @return
	 */
	public List<MidiaAlugadaDTO> pesquisarMidiasAlugadas(FiltroMidiasAlugadas filtroMidiasAlugadas) {
		List<MidiaAlugadaDTO> dtos = new ArrayList<MidiaAlugadaDTO>(); 
		List<Usuario> usuarios = usuarioRepository.listar();
		
		Instant instantDe = Instant.ofEpochMilli(filtroMidiasAlugadas.getDe().getTime());
		LocalDate de = LocalDateTime.ofInstant(instantDe, ZoneId.systemDefault()).toLocalDate();
		
		Instant instantAte = Instant.ofEpochMilli(filtroMidiasAlugadas.getAte().getTime());
		LocalDate ate = LocalDateTime.ofInstant(instantAte, ZoneId.systemDefault()).toLocalDate();
		
		for (Usuario usuario : usuarios) {
			List<Aluguel> alugueis = usuario.getFilmesAlugados();
			
			for (Aluguel aluguel : alugueis) {
				LocalDate dataAluguel = aluguel.getDataAluguel();
				if((dataAluguel.isEqual(de) || dataAluguel.isAfter(de)) && (dataAluguel.isEqual(ate) || dataAluguel.isBefore(ate))) {
					MidiaAlugadaDTO dto = new MidiaAlugadaDTO();
					
					dto.setNomeUsuario(usuario.getNome());
					dto.setNomeFilme(aluguel.getFilme().getNome());
					dto.setTipoMidia(aluguel.getTipoMidia());
					dto.setDataAluguel(aluguel.getDataAluguel().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
					
					dtos.add(dto);
				}
			}
		}
		
		return dtos;
	}
	
	/**
	 * Verifica se o usuário logado já alugou o filme desejado antes.
	 * 
	 * @param filme
	 * @param usuarioLogado 
	 */
	public void verificarHistorico(Filme filme, Usuario usuarioLogado) {
		List<Aluguel> filmesAlugados = usuarioLogado.getFilmesAlugados();
		
		for (Aluguel aluguel : filmesAlugados) {
			if(aluguel.getFilme().equals(filme)) {
				String dataAluguel = aluguel.getDataAluguel().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				String mensagem = "Você já alugou esse filme em: " + dataAluguel;
				
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", mensagem);
		        RequestContext.getCurrentInstance().showMessageInDialog(facesMessage);
			}
		}
	}
}
