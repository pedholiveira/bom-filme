package br.com.infnet.bomfilme.model;

import javax.validation.constraints.NotNull;

public class Login {
	@NotNull(message="O campo login � obrigat�rio.")
	private String login;
	@NotNull(message="O campo senha � obrigat�rio.")
	private String senha;

	public Login() {
	}
	
	public Login(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(obj instanceof Login) {
			Login l = (Login) obj;
			
			if(l.getLogin().equals(this.login) && l.getSenha().equals(this.senha)) {
				return true;
			}
		}
		
		return false;
	}
}
