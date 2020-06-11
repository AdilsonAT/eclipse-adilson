package Comparador;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Comparador {

//	public static void main(String[] args) throws IOException {

	public List<String> Compara(String pathPlan, String pathHP, int coluna, String prefixo) throws IOException {
		
		List<String> totais = new ArrayList<String>();
		// Instancia Plan e HP
		ReadExcelPlan plan = new ReadExcelPlan();
		List<String> plano = plan.criar(pathPlan, coluna, prefixo);
		ReadExcelHP HP = new ReadExcelHP();
		List<String> hp = HP.criar(pathHP, prefixo);
		//Instancia saida txt
		pathPlan = pathPlan.replaceAll(".xlsx", "_PlanoHP.txt");
		FileWriter comparacao = new FileWriter(pathPlan);
		PrintWriter gravarComparacao = new PrintWriter(comparacao);
		gravarComparacao.printf("Plano x HP\n");
		// 
		int iguais = 0;
		int diferentes = 0;
		//Compara
		for (int x = 0; x < plano.size(); x++) {
			boolean achou = false;
			loop: for (int y = 0; y < hp.size(); y++) {
				String strPlan = plano.get(x).toString();
				String strHP = hp.get(y).toString();
				if (strPlan.equals(strHP)) {
					achou = true;
					iguais++;
					break loop;
				}
			}
			if (achou == false) {
				diferentes++;
				gravarComparacao.printf(plano.get(x) + "\n");
			}
		}
		// Grava totais 
		gravarComparacao.printf("Lidos Planejamento            : " + plano.size() + "\n");
		gravarComparacao.printf("Lidos HP                      : " + hp.size() + "\n");
		gravarComparacao.printf("Encontrados do plano na HP    : " + iguais + "\n");
		gravarComparacao.printf("Não encontrados do plano na HP: " + diferentes + "\n");
		comparacao.close();
		// Devolve totais
		totais.add(Integer.toString(plano.size()));
		totais.add(Integer.toString(hp.size()));
		totais.add(Integer.toString(iguais));
		totais.add(Integer.toString(diferentes));
		
		pathHP = pathHP.replaceAll(".xlsx", "_HPPlan.txt");
		comparacao = new FileWriter(pathHP);
		gravarComparacao = new PrintWriter(comparacao);
		gravarComparacao.printf("HP x Plano\n");
		iguais = 0;
		diferentes = 0;
		for (int x = 0; x < hp.size(); x++) {
			boolean achou = false;
			loop: for (int y = 0; y < plano.size(); y++) {
				String strHP = hp.get(x).toString();
				String strPlan = plano.get(y).toString();
				if (strHP.equals(strPlan)) {
					achou = true;
					iguais++;
					break loop;
				}
			}
			if (achou == false) {
				diferentes++;
				gravarComparacao.printf(hp.get(x) + "\n");
			}
		}
		gravarComparacao.printf("Lidos HP                      : " + hp.size() + "\n");
		gravarComparacao.printf("Lidos Planejamento            : " + plano.size() + "\n");
		gravarComparacao.printf("Encontrados da HP no plano    : " + iguais + "\n");
		gravarComparacao.printf("Não encontrados da HP no plano: " + diferentes + "\n");
		comparacao.close();
		totais.add(Integer.toString(hp.size()));
		totais.add(Integer.toString(plano.size()));
		totais.add(Integer.toString(iguais));
		totais.add(Integer.toString(diferentes));
		
		return totais;
	}
}