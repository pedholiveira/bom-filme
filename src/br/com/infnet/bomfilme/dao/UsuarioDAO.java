package br.com.infnet.bomfilme.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import br.com.infnet.bomfilme.model.Login;
import br.com.infnet.bomfilme.model.Usuario;
import br.com.infnet.bomfilme.repository.UsuarioRepository;
import br.com.infnet.bomfilme.util.MockUtil;

public class UsuarioDAO implements UsuarioRepository {

	public List<Usuario> usuariosCadastrados;
	
	@PostConstruct
	public void carregarUsuarios() {
		usuariosCadastrados = MockUtil.getUsuarios();
	}
	
	@Override
	public Usuario getUsuarioByLogin(Login login) {
		Usuario usuario = usuariosCadastrados
								.stream()
								.filter(u -> u.getLogin().equals(login))
								.findAny()
								.orElse(null);
		
		return usuario;
	}

}
