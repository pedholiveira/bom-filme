package br.com.infnet.bomfilme.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.infnet.bomfilme.model.Login;
import br.com.infnet.bomfilme.model.Usuario;
import br.com.infnet.bomfilme.repository.UsuarioRepository;

/**
 * Classe para manipulação das regras de negócio referentes a classe
 * {@link Usuario}.
 * 
 * @author Pedro Henrique
 */
@RequestScoped
public class UsuarioService {
	@Inject
	private UsuarioRepository repository;

	/**
	 * Retorna um usuário cadastrado a partir do seu login.
	 * 
	 * @param login
	 * @return Um objeto do tipo {@link Usuario}.
	 */
	public Usuario getUsuarioByLogin(Login login) {
		return repository.getUsuarioByLogin(login);
	}
}
