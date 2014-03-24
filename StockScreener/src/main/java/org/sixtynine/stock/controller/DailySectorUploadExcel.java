package org.sixtynine.stock.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import com.sun.rowset.internal.Row;

public class DailySectorUploadExcel {

	public static void main(String[] args) {
		try {
			// DailySectorData dailSec = null;

			FileInputStream file = new FileInputStream(new File(
					"daily_sector_data.xlsx"));

//			// Create Workbook instance holding reference to .xlsx file
//			XSSFWorkbook workbook = new XSSFWorkbook(file);
//
//			// Get first/desired sheet from the workbook
//			XSSFSheet sheet = workbook.getSheetAt(0);
//
//			// Iterate through each rows one by one
//			Iterator<Row> rowIterator = sheet.iterator();
//			while (rowIterator.hasNext()) {
//
//				Row row = rowIterator.next();
//				int lst = row.getLastCellNum();
//				// for(int i = 0; i < lst; i++){
//				// System.out.print(row.getCell()+" - ");
//				// dailSec.setNoOfTrade(row.getCell(1));
//				System.out.println(row.getCell(0));
//				System.out.println(row.getCell(1));
//				System.out.println(row.getCell(2));
//				System.out.println(row.getCell(3));
//				System.out.println(row.getCell(4));
//
//				// }
//				System.out.println("");
//			}
//			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
