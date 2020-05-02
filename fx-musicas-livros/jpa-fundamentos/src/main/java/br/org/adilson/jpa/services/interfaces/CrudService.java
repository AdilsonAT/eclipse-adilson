package br.org.adilson.jpa.services.interfaces;

import java.util.List;

public interface CrudService<T, K> {	// <T, K> generics
	List<T> all();
	T byId(K id);	
	T insert(T entity);
	T update(T entity);
	void delete(T entity);
	void deleteById(K id);
}
