package br.com.infnet.bomfilme.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.infnet.bomfilme.model.Endereco;
import br.com.infnet.bomfilme.model.Exemplar;
import br.com.infnet.bomfilme.model.Filme;
import br.com.infnet.bomfilme.model.Login;
import br.com.infnet.bomfilme.model.Profissional;
import br.com.infnet.bomfilme.model.Usuario;
import br.com.infnet.bomfilme.model.constant.Categoria;
import br.com.infnet.bomfilme.model.constant.Papel;
import br.com.infnet.bomfilme.model.constant.TipoMidia;

/**
 * Utilitário responsável por mockar os dados no sistema.
 *  
 * @author Pedro Henrique
 */
public class MockUtil {
	private static Map<String, Filme> filmesCadastrados = new HashMap<String, Filme>();
	private static Map<String, Profissional> profissionaisCadastrados = new HashMap<String, Profissional>();
	
	private static List<Usuario> usuariosCadastrados = new ArrayList<Usuario>();
	
	static {
		carregarProfissionais();
		carregarFilmes();
		carregarExemplares();
		
		carregarUsuario();
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
	
	public static List<Usuario> getUsuarios() {
		return usuariosCadastrados;
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
		filmesCadastrados.get("inception").getExemplares().add(new Exemplar(Calendar.getInstance(), TipoMidia.DVD, 60.9));
		filmesCadastrados.get("inception").getExemplares().add(new Exemplar(Calendar.getInstance(), TipoMidia.DVD, 60.9));
		filmesCadastrados.get("inception").getExemplares().add(new Exemplar(Calendar.getInstance(), TipoMidia.DVD, 60.9));
		filmesCadastrados.get("inception").getExemplares().add(new Exemplar(Calendar.getInstance(), TipoMidia.BLURAY, 90.9));
		filmesCadastrados.get("inception").getExemplares().add(new Exemplar(Calendar.getInstance(), TipoMidia.BLURAY, 90.9));
		
		filmesCadastrados.get("ilhaDoMedo").getExemplares().add(new Exemplar(Calendar.getInstance(), TipoMidia.DVD, 40.9));
		filmesCadastrados.get("ilhaDoMedo").getExemplares().add(new Exemplar(Calendar.getInstance(), TipoMidia.DVD, 40.9));
		filmesCadastrados.get("ilhaDoMedo").getExemplares().add(new Exemplar(Calendar.getInstance(), TipoMidia.DVD, 40.9));
		filmesCadastrados.get("ilhaDoMedo").getExemplares().add(new Exemplar(Calendar.getInstance(), TipoMidia.BLURAY, 70.9));
	}
	
	/**
	 * Carrega os dados do usuário que será mockado.
	 */
	private static void carregarUsuario() {
		Endereco endereco = new Endereco("Rua Teste", "Complemento teste", 
										"Bairro Teste", "123456", "Rio de Janeiro", 
										"RJ");
		Login login = new Login("login", "senha");
		Login admin = new Login("admin", "admin", true);
		
		usuariosCadastrados.add(new Usuario("Pedro Henrique", endereco, "123.456.789.12", "ped.holiveira@gmail.com", "12.345.678-9", Arrays.asList("12345678"), login));
		usuariosCadastrados.add(new Usuario("Administrador", endereco, "123.456.789.12", "admin@gmail.com", "12.345.678-9", Arrays.asList("12345678"), admin));
	}
	
}
