package br.org.adilson.classes;

import java.util.ArrayList;
import java.util.List;

import br.org.adilson.entidades.TableViewClasse;

public class TableViewRepositorio implements TableViewInterface<TableViewClasse>{

	private static List<TableViewClasse> TVC = new ArrayList<TableViewClasse>();

	public List<TableViewClasse> selecionar() {
			return TVC;
		}

	public void inserir(TableViewClasse entidade) {
		TVC.add(entidade);
	}

	public void atualizar(TableViewClasse entidade) {
	}

	public void excluir(TableViewClasse entidade) {
		TVC.remove(entidade);
	}
}
