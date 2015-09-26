package br.com.infnet.bomfilme.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import br.com.infnet.bomfilme.filtro.FiltroFilme;
import br.com.infnet.bomfilme.model.Aluguel;
import br.com.infnet.bomfilme.model.Exemplar;
import br.com.infnet.bomfilme.model.Filme;
import br.com.infnet.bomfilme.model.Papel;
import br.com.infnet.bomfilme.model.Profissional;
import br.com.infnet.bomfilme.model.Reserva;
import br.com.infnet.bomfilme.model.StatusExemplar;
import br.com.infnet.bomfilme.model.Usuario;
import br.com.infnet.bomfilme.repository.FilmeRepository;
import br.com.infnet.bomfilme.repository.UsuarioRepository;
import br.com.infnet.bomfilme.util.MockUtil;

public class FilmeDAO implements FilmeRepository {
	@Inject
	private UsuarioRepository usuarioRepository;
	
	private static List<Filme> filmesCadastrados;
	private static List<Profissional> profissionaisCadastrados;
	
	static {
		filmesCadastrados = MockUtil.getFilmes();
		profissionaisCadastrados = MockUtil.getProfissionais();
	}
	
	@Override
	public List<Filme> pesquisarFilmes(FiltroFilme filtro) {
		List<Filme> filmesEncontrados = filmesCadastrados; 
				
		if(filtro.getNome() != null) {
			filmesEncontrados = filmesEncontrados
									.stream()
									.filter(f -> f.getNome().equals(filtro.getNome()))
									.collect(Collectors.toList());
		}
		
		if(filtro.getNomeOriginal() != null) {
			filmesEncontrados = filmesEncontrados
									.stream()
									.filter(f -> f.getNomeOriginal().equals(filtro.getNomeOriginal()))
									.collect(Collectors.toList());
		}
		
		if(filtro.getNomeDiretor() != null) {
			Profissional diretor = buscarDiretorPorNome(filtro.getNomeDiretor());
			
			filmesEncontrados = filmesEncontrados
									.stream()
									.filter(f -> f.getProfissionais().contains(diretor))
									.collect(Collectors.toList());
		}
		
		if(filtro.getNomeAtor() != null) {
			Profissional ator = buscarAtorPorNome(filtro.getNomeAtor());
			
			filmesEncontrados = filmesEncontrados
									.stream()
									.filter(f -> f.getProfissionais().contains(ator))
									.collect(Collectors.toList());
		}
		
		return filmesEncontrados;
	}

	@Override
	public Set<Profissional> listarAtores() {
		Set<Profissional> atores = profissionaisCadastrados
									.stream()
									.filter(p -> p.getPapel().equals(Papel.ATOR))
									.collect(Collectors.toCollection(HashSet::new));
		return atores;
	}

	@Override
	public Profissional buscarDiretorPorNome(String nome) {
		Profissional diretor = profissionaisCadastrados
									.stream()
									.filter(p -> p.getPapel().equals(Papel.DIRETOR) && p.getNome().equals(nome))
									.findFirst()
									.orElse(null);
		return diretor;
	}

	@Override
	public Profissional buscarAtorPorNome(String nome) {
		Profissional ator = profissionaisCadastrados
									.stream()
									.filter(p -> p.getPapel().equals(Papel.ATOR) && p.getNome().equals(nome))
									.findFirst()
									.orElse(null);
		return ator;
	}

	@Override
	public void alugarFilmes(Usuario usuario, Filme filme, String tipoMidia) {
		Aluguel aluguel = new Aluguel(filme, tipoMidia);

		for (int i = 0; i < filmesCadastrados.size(); i++) {
			if(filmesCadastrados.get(i).equals(filme)) {
				for (int y = 0; y < filmesCadastrados.get(i).getExemplares().size(); y++) {
					if(filmesCadastrados.get(i).getExemplares().get(y).getTipoMidia().equals(tipoMidia)) {
						usuarioRepository.incluirAluguel(usuario, aluguel);
						filmesCadastrados.get(i).getExemplares().get(y).setStatus(StatusExemplar.ALUGADO);
						
						return;
					}
				}
				
				break;
			}
		}
	}

	@Override
	public void reservarFilme(Reserva reserva) {
		Filme filme = reserva.getFilme();
		Exemplar exemplar = reserva.getExemplar();
		
		for (int i = 0; i < filmesCadastrados.size(); i++) {
			if(filmesCadastrados.get(i).equals(filme)) {
				for (int y = 0; y < filmesCadastrados.get(i).getExemplares().size(); y++) {
					if(filmesCadastrados.get(i).getExemplares().get(y).equals(exemplar)) {
						filmesCadastrados.get(i).getExemplares().get(y).setStatus(StatusExemplar.RESERVADO);
						
						return;
					}
				}
				
				break;
			}
		}
	}
}
