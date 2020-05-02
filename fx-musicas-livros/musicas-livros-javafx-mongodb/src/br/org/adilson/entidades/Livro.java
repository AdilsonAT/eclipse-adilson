package br.org.adilson.entidades;

import java.io.Serializable;

public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tipo;
	private String livro;
	private String pasta;

	public Livro() {
	}

	public Livro(String tipo, String livro, String pasta) {
		super();
		this.tipo = tipo;
		this.livro = livro;
		this.pasta = pasta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLivro() {
		return livro;
	}

	public void setLivro(String livro) {
		this.livro = livro;
	}

	public String getPasta() {
		return pasta;
	}

	public void setPasta(String pasta) {
		this.pasta = pasta;
	}
}