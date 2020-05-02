package br.org.adilson.entidades;

import java.io.Serializable;

public class Disco implements Serializable {

	private static final long serialVersionUID = 1L;

	private String musica;
	private String pasta;

	public Disco() {
	}

	public Disco(String musica, String pasta) {
		this.musica = musica;
		this.pasta = pasta;
	}

	public String getMusica() {
		return musica;
	}

	public void setMusica(String musica) {
		this.musica = musica;
	}

	public String getPasta() {
		return pasta;
	}

	public void setPasta(String pasta) {
		this.pasta = pasta;
	}

}