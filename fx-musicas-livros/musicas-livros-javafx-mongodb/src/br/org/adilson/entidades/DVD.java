package br.org.adilson.entidades;

import java.io.Serializable;

public class DVD implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tipo;
	private String DVD;
	private String pasta;

	public DVD() {
	}

	public DVD(String tipo, String DVD, String pasta) {
		super();
		this.tipo = tipo;
		this.DVD = DVD;
		this.pasta = pasta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDVD() {
		return DVD;
	}

	public void setDVD(String DVD) {
		this.DVD = DVD;
	}

	public String getPasta() {
		return pasta;
	}

	public void setPasta(String pasta) {
		this.pasta = pasta;
	}
}