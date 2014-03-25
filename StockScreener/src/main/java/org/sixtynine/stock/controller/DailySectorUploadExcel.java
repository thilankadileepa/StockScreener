package org.sixtynine.stock.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DailySectorUploadExcel {

	public static void main(String[] args) {
		try {
			// DailySectorData dailSec = null;

			FileInputStream file = new FileInputStream(new File(
					"daily_sector_data.xlsx"));

			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
