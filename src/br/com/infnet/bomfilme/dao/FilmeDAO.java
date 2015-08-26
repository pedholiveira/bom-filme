package br.com.infnet.bomfilme.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import br.com.infnet.bomfilme.filtro.FiltroFilme;
import br.com.infnet.bomfilme.model.Exemplar;
import br.com.infnet.bomfilme.model.Filme;
import br.com.infnet.bomfilme.model.Papel;
import br.com.infnet.bomfilme.model.Profissional;
import br.com.infnet.bomfilme.repository.FilmeRepository;
import br.com.infnet.bomfilme.util.MockUtil;

public class FilmeDAO implements FilmeRepository {

	private static List<Filme> filmesCadastrados;
	private static List<Profissional> profissionaisCadastrados;
	private static List<Exemplar> exemplaresCadastrados;
	
	@PostConstruct
	public void carregarMocks() {
		filmesCadastrados = MockUtil.getFilmes();
		profissionaisCadastrados = MockUtil.getProfissionais();
		exemplaresCadastrados = MockUtil.getExemplares();
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
		
		//TODO - Corrigir o filtro para procurar pelo papel do profissional.
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
	public List<Exemplar> lerExemplares(Filme filme) {
		List<Exemplar> exemplares = exemplaresCadastrados.stream()
									.filter(e -> e.getFilme().equals(filme))
									.collect(Collectors.toCollection(ArrayList::new));
		return exemplares;
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
}
