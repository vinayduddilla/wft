package com.senslytics.data.manager.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.senslytics.data.camel.CamelHelper;

public class ExcelFileReader {

	static String[] excelFormats = { ".xls", ".xlsb", ".xlsm", ".xlsx" };
	static String fileName = "c:\\files\\FileDataMnemonics.xlsx";

	public static void main(String[] args) throws IOException {
		try {
			System.out.println("Reading file.. ");
			//readFile(fileName);
			System.out.println("File reading complete");
			CamelHelper.getInstance().camelBoot();
			Thread.sleep(5*60*60);
			CamelHelper.getInstance().getCamelContext().stop();
		} catch (InvalidFormatException ife) {
			ife.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readFile(String fileName) throws IOException, InvalidFormatException {

		File file = new File(fileName);
		Workbook workBook = WorkbookFactory.create(file);
		for (int sheetNumber = 0; sheetNumber < workBook.getNumberOfSheets(); sheetNumber++) {
			Sheet sheet = workBook.getSheetAt(sheetNumber);
			Iterator<Row> it = sheet.iterator();
			System.out.println("Sheet number - " + sheetNumber + " - "  + workBook.getSheetName(sheetNumber) );
			while (it.hasNext()) {
				Row row = it.next();
				int cellNumbers = row.getPhysicalNumberOfCells();
				String preparedRow = "";
				for (int cellNumber = 0; cellNumber < cellNumbers; cellNumber++) {
					preparedRow +=  "       " + row.getCell(cellNumber);
				}
				System.out.println(preparedRow);
			}

		}
	}

}
