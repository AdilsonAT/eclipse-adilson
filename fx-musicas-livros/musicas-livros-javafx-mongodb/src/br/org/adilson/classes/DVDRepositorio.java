package br.org.adilson.classes;

import java.util.ArrayList;
import java.util.List;

import br.org.adilson.entidades.DVD;

public class DVDRepositorio implements DVDInterface<DVD> {

	private static List<DVD> DVDs = new ArrayList<DVD>();
	
	public List<DVD> selecionar() {
		return DVDs;
	}

	public void inserir(DVD entidade) {
		DVDs.add(entidade);
	}

	public void atualizar(DVD entidade) {
	}

	public void excluir(DVD entidade) {
		DVDs.remove(entidade);
	}

}
