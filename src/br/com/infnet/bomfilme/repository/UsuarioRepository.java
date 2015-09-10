package br.com.infnet.bomfilme.repository;

import br.com.infnet.bomfilme.model.Aluguel;
import br.com.infnet.bomfilme.model.Login;
import br.com.infnet.bomfilme.model.Usuario;

/**
 * Repositório de dados da classe {@link Usuario}.
 * 
 * @author Pedro Henrique
 */
public interface UsuarioRepository {
	/**
	 * Retorna um usuário cadastrado a partir do seu login.
	 * 
	 * @param login
	 * @return Um objeto do tipo {@link Usuario}.
	 */
	public Usuario getUsuarioByLogin(Login login);
	
	/**
	 * Insere um aluguel na lista de alugueis do usuario.
	 * 
	 * @param user
	 * @param aluguel
	 */
	public void incluirAluguel(Usuario user, Aluguel aluguel);
}
