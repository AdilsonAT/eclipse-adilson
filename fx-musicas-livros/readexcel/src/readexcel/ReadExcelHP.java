package readexcel;

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

import lombok.Cleanup;

public class ReadExcelHP {

	public List<String> criar() throws IOException {

		List<String> lista = new ArrayList<>();

		// Recuperando o arquivo
		@Cleanup // fecha o arquivo após usado
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Adilson\\eclipse-adilson\\fx-musicas-livros\\readexcel\\src\\resources\\HP.xlsx");
		Workbook workbook = new XSSFWorkbook(file);

		// Setando a aba
		Sheet sheet = workbook.getSheetAt(0);

		// Setando as linhas
		List<Row> rows = (List<Row>) toList(sheet.iterator());

		// Remover os cabeçalhos
		rows.remove(0);

		rows.forEach(row -> {
			// Setando as celulas
			List<Cell> cells = (List<Cell>) toList(row.cellIterator());
			String texto = cells.get(3).getStringCellValue();
			int inicio = texto.indexOf("BRA");
			if (inicio > -1) {
				String textoSubs;
				int fim = texto.indexOf(" ");
				if (fim > -1) {
					textoSubs = texto.substring(inicio, fim - 1);
				} else {
					textoSubs = texto.substring(inicio, texto.length());
				}
//				System.out.println(textoSubs);
				lista.add(textoSubs);
			}
		});

		return lista;
	}

	public List<?> toList(Iterator<?> iterator) {
		return IteratorUtils.toList(iterator);
	}
}
