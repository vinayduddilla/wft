package com.senslytics.data.manager.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileReader {

	static String[] excelFormats = { ".xls", ".xlsb", ".xlsm", ".xlsx" };
	static String fileName = "c:/files/FileDataMnemonics.xlsx";

	public static void main(String[] args) throws IOException {
		try {
			System.out.println("Reading files ");
			readFile();
			System.out.println("Files read");
		} catch (InvalidFormatException ife) {
			ife.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readFile() throws IOException, InvalidFormatException {

		File file = new File(fileName);
		Workbook workBook = WorkbookFactory.create(file);
		for (int sheetNumber = 0; sheetNumber < workBook.getNumberOfSheets(); sheetNumber++) {
			Sheet sheet = workBook.getSheetAt(sheetNumber);
			Iterator<Row> it = sheet.iterator();
			System.out.println("Sheet number - " + sheetNumber);
			while (it.hasNext()) {
				Row r = it.next();
				int cellNumbers = r.getPhysicalNumberOfCells();
				String preparedRow = "";
				for (int cellNumber = 0; cellNumber < cellNumbers; cellNumber++) {
					preparedRow +=  "       " + r.getCell(cellNumber);
				}
				System.out.println(preparedRow);
			}

		}
	}

}
