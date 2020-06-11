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

public class ReadExcelHP {

	public List<String> criar(String pathHP, String prefixo) throws IOException {

		List<String> lista = new ArrayList<>();

		// Recuperando o arquivo
//		FileInputStream file = new FileInputStream("C:\\Users\\Adilson\\Documents\\HP.xlsx");
		FileInputStream file = new FileInputStream(pathHP);
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
			String texto = cells.get(3).getStringCellValue();
			int inicio = texto.indexOf(prefixo);
			if (inicio > -1) {
				String textoSubs;
				int fim = texto.indexOf(" ");
				if (fim != -1) {
					textoSubs = texto.substring(inicio, fim);
				} else {
					textoSubs = texto.substring(inicio, texto.length());
				}
				textoSubs = textoSubs.replaceAll(" ", "");
				lista.add(textoSubs);
			}
		});

		workbook.close();
		return lista;
	}

	public List<?> toList(Iterator<?> iterator) {
		return IteratorUtils.toList(iterator);
	}
}
