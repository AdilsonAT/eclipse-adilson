package br.org.adilson.classes;

import java.util.List;

public interface LivroInterface<T> {
	List<T> selecionar();
}