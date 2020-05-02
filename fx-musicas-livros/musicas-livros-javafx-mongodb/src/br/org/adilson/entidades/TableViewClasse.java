package br.org.adilson.entidades;

import java.io.Serializable;

public class TableViewClasse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String coluna01;
	private String coluna02;
		
	public TableViewClasse() {
		super();
	}

	public TableViewClasse(String coluna01, String coluna02) {
		super();
		this.coluna01 = coluna01;
		this.coluna02 = coluna02;
	}

	public String getColuna01() {
		return coluna01;
	}

	public void setColuna01(String coluna01) {
		this.coluna01 = coluna01;
	}

	public String getColuna02() {
		return coluna02;
	}

	public void setColuna02(String coluna02) {
		this.coluna02 = coluna02;
	}	
}
