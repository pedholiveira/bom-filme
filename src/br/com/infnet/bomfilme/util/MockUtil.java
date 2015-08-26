package br.com.infnet.bomfilme.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.infnet.bomfilme.model.Categoria;
import br.com.infnet.bomfilme.model.Exemplar;
import br.com.infnet.bomfilme.model.Filme;
import br.com.infnet.bomfilme.model.Papel;
import br.com.infnet.bomfilme.model.Profissional;
import br.com.infnet.bomfilme.model.TipoMidia;

/**
 * Utilitário responsável por mockar os dados no sistema.
 *  
 * @author Pedro Henrique
 */
public class MockUtil {
	private static Map<String, Filme> filmesCadastrados = new HashMap<String, Filme>();
	private static Map<String, Profissional> profissionaisCadastrados = new HashMap<String, Profissional>();
	private static Map<Integer, Exemplar> exemplaresCadastrados = new HashMap<Integer, Exemplar>();
	
	static {
		carregarProfissionais();
		carregarFilmes();
		carregarExemplares();
	}
	
	/**
	 * Retorna a lista com os filmes mockados no sistema.
	 * 
	 * @return Uma {@link List} de objetos do tipo {@link Filme}.
	 */
	public static List<Filme> getFilmes() {
		List<Filme> filmes = new ArrayList<Filme>();
		filmesCadastrados.forEach((key, value) -> filmes.add(value));
		return filmes;
	}
	
	/**
	 * Retorna a lista com os profissionais mockados no sistema.
	 * 
	 * @return Uma {@link List} de objetos do tipo {@link Profissional}.
	 */
	public static List<Profissional> getProfissionais() {
		List<Profissional> profissionais = new ArrayList<Profissional>();
		profissionaisCadastrados.forEach((key, value) -> profissionais.add(value));
		return profissionais;
	}
	
	/**
	 * Retorna a lista com os exemplares mockados no sistema.
	 * 
	 * @return Uma {@link List} de objetos do tipo {@link Exemplar}.
	 */
	public static List<Exemplar> getExemplares() {
		List<Exemplar> exemplares = new ArrayList<Exemplar>();
		exemplaresCadastrados.forEach((key, value) -> exemplares.add(value));
		return exemplares;
	}

	/**
	 * Carrega os dados de filmes que serão mockados.
	 */
	private static void carregarFilmes() {
		List<Profissional> profissionaisInception = Arrays.asList(profissionaisCadastrados.get("leonardoDiCaprio"), profissionaisCadastrados.get("ellenPage"), profissionaisCadastrados.get("christopherNolan"));
		List<Profissional> profissionaisIlhaDoMedo = Arrays.asList(profissionaisCadastrados.get("leonardoDiCaprio"), profissionaisCadastrados.get("martinScorsese"));
		
		Filme inception = new Filme("A Origem", "Inception", "2010", "148", Categoria.FICCAO, 14, "Warner", 9.9, profissionaisInception);
		Filme ilhaDoMedo = new Filme("A Ilha do Medo", "Shutter Island", "2012", "138", Categoria.SUSPENSE, 16, "Phoenix Pictures", 9.9, profissionaisIlhaDoMedo);
		
		filmesCadastrados.put("inception", inception);
		filmesCadastrados.put("ilhaDoMedo", ilhaDoMedo);
	}

	/**
	 * Carrega os dados dos profissionais que serão mockados.
	 */
	private static void carregarProfissionais() {
		Profissional christopherNolan = new Profissional("Christopher Nolan", "30/07/1970", "Inglês", Papel.DIRETOR);
		Profissional martinScorsese = new Profissional("Martin Scorsese", "17/11/1942", "Americano", Papel.DIRETOR);
		Profissional leornadoDiCaprio = new Profissional("Leonardo DiCaprio", "11/11/1974", "Americano", Papel.ATOR);
		Profissional ellenPage = new Profissional("Ellen Page", "21/02/1987", "Canadense", Papel.ATOR);
		
		profissionaisCadastrados.put("christopherNolan", christopherNolan);
		profissionaisCadastrados.put("martinScorsese", martinScorsese);
		profissionaisCadastrados.put("leonardoDiCaprio", leornadoDiCaprio);
		profissionaisCadastrados.put("ellenPage", ellenPage);
	}
	
	/**
	 * Carrega os dados dos exemplares que serão mockados.
	 */
	private static void carregarExemplares() {
		Filme inception = filmesCadastrados.get("inception");
		Filme ilhaDoMedo = filmesCadastrados.get("ilhaDoMedo");
		
		Exemplar exemplar1 = new Exemplar(inception, Calendar.getInstance(), TipoMidia.DVD, 60.9);
		Exemplar exemplar2 = new Exemplar(inception, Calendar.getInstance(), TipoMidia.DVD, 60.9);
		Exemplar exemplar3 = new Exemplar(inception, Calendar.getInstance(), TipoMidia.DVD, 60.9);
		Exemplar exemplar4 = new Exemplar(inception, Calendar.getInstance(), TipoMidia.BLURAY, 90.9);
		Exemplar exemplar5 = new Exemplar(inception, Calendar.getInstance(), TipoMidia.BLURAY, 90.9);
		
		Exemplar exemplar6 = new Exemplar(ilhaDoMedo, Calendar.getInstance(), TipoMidia.DVD, 40.9);
		Exemplar exemplar7 = new Exemplar(ilhaDoMedo, Calendar.getInstance(), TipoMidia.DVD, 40.9);
		Exemplar exemplar8 = new Exemplar(ilhaDoMedo, Calendar.getInstance(), TipoMidia.DVD, 40.9);
		Exemplar exemplar9 = new Exemplar(ilhaDoMedo, Calendar.getInstance(), TipoMidia.BLURAY, 70.9);
		
		exemplaresCadastrados.put(1, exemplar1);
		exemplaresCadastrados.put(2, exemplar2);
		exemplaresCadastrados.put(3, exemplar3);
		exemplaresCadastrados.put(4, exemplar4);
		exemplaresCadastrados.put(5, exemplar5);
		exemplaresCadastrados.put(6, exemplar6);
		exemplaresCadastrados.put(7, exemplar7);
		exemplaresCadastrados.put(8, exemplar8);
		exemplaresCadastrados.put(9, exemplar9);
	}
	
}
