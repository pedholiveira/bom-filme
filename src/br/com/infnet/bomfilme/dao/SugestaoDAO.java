package br.com.infnet.bomfilme.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.infnet.bomfilme.model.Sugestao;
import br.com.infnet.bomfilme.repository.SugestaoRepository;

public class SugestaoDAO implements SugestaoRepository {
	private static List<Sugestao> sugestoesCadastradas = new ArrayList<Sugestao>();
	
	@Override
	public void gravar(Sugestao sugestao) {
		sugestoesCadastradas.add(sugestao);
	}
}
