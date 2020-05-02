package br.org.adilson.classes;

import java.util.ArrayList;
import java.util.List;

import br.org.adilson.entidades.Livro;

public class LivroRepositorio implements LivroInterface<Livro> {

	private static List<Livro> livros = new ArrayList<Livro>();
	
	public List<Livro> selecionar() {
		return livros;
	}

	public void inserir(Livro entidade) {
		livros.add(entidade);
	}

	public void atualizar(Livro entidade) {
	}

	public void excluir(Livro entidade) {
		livros.remove(entidade);
	}

}
