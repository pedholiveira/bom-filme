package br.com.infnet.bomfilme.model;

/**
 * Mantém os diferentes status que uma mídia pode assumir.
 * 
 * @author Pedro Henrique
 */
public interface StatusExemplar {
	public static final String DISPONIVEL = "disponivel";
	public static final String ALUGADO = "alugado";
	public static final String RESERVADO = "reservado";
}
