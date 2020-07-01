package CenariosBusPay;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CenarriosBusPay {

	public static void main(String[] args) throws IOException {

		FileWriter comparacao = new FileWriter("C:\\Users\\Adilson\\Documents\\TestePlanHP\\comparacaopaybus.txt");
		PrintWriter gravarComparacao = new PrintWriter(comparacao);
		gravarComparacao.printf("Payroll;"+"Status Payroll;"+"Bysiness;"+"Status Business"+"\n");
		
		FileWriter lstPay = new FileWriter("C:\\Users\\Adilson\\Documents\\TestePlanHP\\lstpay.txt");
		PrintWriter gravarLstPay = new PrintWriter(lstPay);
		
		FileWriter lstBus = new FileWriter("C:\\Users\\Adilson\\Documents\\TestePlanHP\\lstbus.txt");
		PrintWriter gravarLstBus = new PrintWriter(lstBus);

		FileInputStream ios = new FileInputStream(
				"C:\\Users\\Adilson\\Documents\\TestePlanHP\\E2E F1 Comp.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(ios);
		XSSFSheet sheet = workbook.getSheetAt(0);

		List<Payroll> listaPayroll = new ArrayList<Payroll>();
		List<Payroll> listaBusiness = new ArrayList<Payroll>();
		Payroll payroll;
		Payroll business;
		String payrollS = "payroll";
		String cenario = null;
		String cenarioP = null;
		String cenarioB = null;
		String statusB = null;
		int i = 0;

		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

//			if (row.getRowNum() > 5)				break;

			String path = row.getCell(0).getStringCellValue();
			i = path.toLowerCase().indexOf(payrollS.toLowerCase());
			String name = row.getCell(1).getStringCellValue().toLowerCase();
			cenario = row.getCell(3).getStringCellValue();

			if (i != -1 || name.equals(payrollS) || cenario.endsWith("PY")) {
				listaPayroll.add(new Payroll(cenario.substring(3, cenario.length()),
						row.getCell(5).getStringCellValue(), null, null));
				gravarLstPay.printf(cenario.substring(3, cenario.length())+" "+
						row.getCell(5).getStringCellValue()+"\n");
			} else {
				listaBusiness.add(new Payroll(null, null, cenario.substring(3, cenario.length()),
						row.getCell(5).getStringCellValue()));
				gravarLstBus.printf(cenario.substring(3, cenario.length())+" "+
						row.getCell(5).getStringCellValue()+"\n");
			}
		}

		Iterator<Payroll> itPayroll = listaPayroll.iterator();
		while (itPayroll.hasNext()) {
			payroll = itPayroll.next();
			cenario = payroll.getCenarioPay();
			if (cenario.endsWith("PY")) {
				Iterator<Payroll> itBusiness = listaBusiness.iterator();
				loopbusiness: 
				while (itBusiness.hasNext()) {
					business = itBusiness.next();
					cenarioP = cenario.substring(0, cenario.length() - 2);
					cenarioB = business.getCenarioBus();
					if (cenarioP.equals(cenarioB)) {
						payroll.setCenarioBus(cenarioB);
						payroll.setStatusBus(business.getStatusBus());
						break loopbusiness;
					}
				}
			}else {
				payroll.setCenarioBus(null);
				payroll.setStatusBus(null);
			}
			gravarComparacao.printf(payroll.getCenarioPay() + ";" + payroll.getStatusPay() + ";"
					+ payroll.getCenarioBus() + ";" + payroll.getStatusBus()+"\n");
		}
		ios.close();
		comparacao.close();
		lstPay.close();
		lstBus.close();
	}
}
