package Comparador;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelPlan {

	public List<String> criar(String pathPlan, int coluna, String prefixo) throws IOException {

		List<String> lista = new ArrayList<>();

		// Recuperando o arquivo
//		FileInputStream file = new FileInputStream("C:\\Users\\Adilson\\Documents\\Planejamento.xlsx");
		FileInputStream file = new FileInputStream(pathPlan);
		Workbook workbook = new XSSFWorkbook(file);

		// Setando a aba
		Sheet sheet = workbook.getSheetAt(0);

		// Setando as linhas
		@SuppressWarnings("unchecked")
		List<Row> rows = (List<Row>) toList(sheet.iterator());

//		// Remover os cabe鏰lhos
//		rows.remove(0);

		rows.forEach(row -> {
			// Setando as celulas
			@SuppressWarnings("unchecked")
			List<Cell> cells = (List<Cell>) toList(row.cellIterator());
			String texto = cells.get(coluna - 1).getStringCellValue();
			int inicio = texto.indexOf(prefixo);
			if (inicio != -1) {
				String textoSubs;
				int fim = texto.indexOf("-");
				if (fim != -1) {
					textoSubs = texto.substring(inicio, fim);
				} else {
					textoSubs = texto.substring(inicio, texto.length());
				}
				textoSubs = textoSubs.replaceAll(" ", "");
				lista.add(textoSubs);
			}
//			else {
//				lista.add(texto);
//			}
		});

		workbook.close();
		return lista;
	}

	public List<?> toList(Iterator<?> iterator) {
		return IteratorUtils.toList(iterator);
	}
}
