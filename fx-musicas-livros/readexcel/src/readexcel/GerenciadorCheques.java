package readexcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
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

public class GerenciadorCheques {

	public List<Cheque> criar() throws IOException {
		
		List<Cheque> cheques = new ArrayList<>();

		// Recuperando o arquivo
		@Cleanup // fecha o arquivo após usado
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Adilson\\eclipse-adilson\\fx-musicas-livros\\readexcel\\src\\resources\\Controle de Cheques.xlsx");
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
		
			// Atribui os valores para classe cheque
			Cheque cheque = new Cheque();
			cheque.setData(cells.get(0).getDateCellValue());
			cheque.setNumeroCheque((int) cells.get(1).getNumericCellValue());
			cheque.setNome(cells.get(2).getStringCellValue());
			cheque.setValor(new BigDecimal(cells.get(3).getNumericCellValue()));
			cheque.setStatus(cells.get(4).getStringCellValue());
			cheque.setQtdeParcelas((int) cells.get(5).getNumericCellValue()); 
			cheque.setFormulaTotal(cells.get(6).getCellFormula());
			cheques.add(cheque);
		});
		
		

		return cheques;
	}

	public List<?> toList(Iterator<?> iterator) {
		return IteratorUtils.toList(iterator);
	}
	
	public void imprimir(List<Cheque> cheques) {
		cheques.forEach(System.out::println);
	}
}
