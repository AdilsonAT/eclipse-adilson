package readexcel;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

//		// Instancia do gerenciador
//		GerenciadorCheques gerenciadorCheques = new GerenciadorCheques();
//		
//		List<Cheque> cheques = gerenciadorCheques.criar();
//		
//		gerenciadorCheques.imprimir(cheques);

		ReadExcelPlan plan = new ReadExcelPlan();
		List<String> plano = plan.criar();

		ReadExcelHP HP = new ReadExcelHP();
		List<String> hp = HP.criar();

		System.out.println(plano.size() + " " + plano);
		System.out.println(hp.size() + " " + hp);

		int iguais = 0;
		int diferentes = 0;

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
				System.out.println(plano.get(x));
			}
		}
		System.out.println(plano.size() + "; " + hp.size() + "; " + iguais + "; " + diferentes);
		System.out.println(" ");
		System.out.println("=================================================================================");
		System.out.println(" ");
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
				System.out.println(hp.get(x));
			}
		}
		System.out.println(hp.size() + "; " + plano.size() + "; " + iguais + "; " + diferentes);
	}
}
