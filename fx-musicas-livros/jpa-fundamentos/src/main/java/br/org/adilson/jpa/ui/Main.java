package br.org.adilson.jpa.ui;

import java.util.List;

import br.org.adilson.jpa.models.Pessoa;
import br.org.adilson.jpa.services.impl.PessoaService;
import br.org.adilson.jpa.services.interfaces.CrudService;

public class Main {

	public static void main(String[] args) {
		CrudService<Pessoa, Integer> pessoaService = new PessoaService();
		System.out.println("*** Gerenciamento de Pessoas ***");
		System.out.println(" > Lista de pessoas cadastradas: \n");
		try {
			List<Pessoa> pessoas = pessoaService.all();
			pessoas.forEach(pessoa -> {System.out.println(String.format(" - (%d) %s, %s - %d anos", pessoa.getId(),
					pessoa.getNome(), pessoa.getSobrenome(), pessoa.getIdade()));
			});
		} catch (Exception e) {
			System.out.println("Houve um erro ao utilizar a JPS: " + e.getMessage());
		}
	}

}
