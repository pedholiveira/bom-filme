package br.com.infnet.bomfilme.model;

import javax.validation.constraints.NotNull;

public class Login {
	@NotNull(message="O campo login é obrigatório.")
	private String login;
	@NotNull(message="O campo senha é obrigatório.")
	private String senha;
	
	private boolean admin = false;

	public Login() {
	}
	
	public Login(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public Login(String login, String senha, boolean admin) {
		this.login = login;
		this.senha = senha;
		this.admin = admin;
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
