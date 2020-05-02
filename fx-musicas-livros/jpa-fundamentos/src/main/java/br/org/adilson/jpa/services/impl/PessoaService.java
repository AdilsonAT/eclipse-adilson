package br.org.adilson.jpa.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.org.adilson.jpa.models.Pessoa;
import br.org.adilson.jpa.services.interfaces.CrudService;
import br.org.adilson.jpa.utils.JpaUtils;

public class PessoaService implements CrudService<Pessoa, Integer> {

	@Override
	public List<Pessoa> all() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			pessoas = em.createQuery("from Pessoa", Pessoa.class).getResultList();	// jpql
			return pessoas;
		}finally {
			if(em != null) {
				em.close();
			}
		}
	}

	@Override
	public Pessoa byId(Integer id) {
		return null;
	}

	@Override
	public Pessoa insert(Pessoa entity) {
		return null;
	}

	@Override
	public Pessoa update(Pessoa entity) {
		return null;
	}

	@Override
	public void delete(Pessoa entity) {
	
	}

	@Override
	public void deleteById(Integer id) {
		
	}
}
