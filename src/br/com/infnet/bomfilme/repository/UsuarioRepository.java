package br.com.infnet.bomfilme.repository;

import br.com.infnet.bomfilme.model.Login;
import br.com.infnet.bomfilme.model.Usuario;

/**
 * Reposit�rio de dados da classe {@link Usuario}.
 * 
 * @author Pedro Henrique
 */
public interface UsuarioRepository {
	/**
	 * Retorna um usu�rio cadastrado a partir do seu login.
	 * 
	 * @param login
	 * @return Um objeto do tipo {@link Usuario}.
	 */
	public Usuario getUsuarioByLogin(Login login);
}
