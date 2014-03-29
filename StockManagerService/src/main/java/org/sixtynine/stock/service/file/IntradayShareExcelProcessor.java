package org.sixtynine.stock.service.file;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.sixtynine.stock.entity.IntradayShareData;
import org.springframework.stereotype.Component;

/**
 * @author Thilanka
 * 
 */
@Component(ExcelProcessorFactory.FILE_TYPE_INTRADAY_SHARE)
public class IntradayShareExcelProcessor extends ExcelProcessor {

	@Override
	public void process(String filePath) {
		System.out.println("IntradayShareExcelProcessor");

		try {

			File file = new File(filePath);

			// Get the workbook instance for XLS file
			Workbook workbook = WorkbookFactory.create(file);

			// Get first sheet from the workbook
			Sheet sheet = workbook.getSheetAt(0);

			// Get iterator to all the rows in current sheet
			Iterator<Row> rowIterator = sheet.iterator();
			int rowIndex = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// Get iterator to all cells of current row
				Iterator<Cell> cellIterator = row.cellIterator();

				if (rowIndex == 0) {
					Cell firstCell = row.getCell(0);
					if (firstCell == null) {
						// TODO send a error message
					}
					continue;
				}

				IntradayShareData intradayShareData = new IntradayShareData();
				int colIndex = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					Object cellVal = getCellValue(cell);
					switch (colIndex) {
					case 0:
						
						break;
					case 1:
						break;

					default:
						break;
					}

					colIndex++;
				}

				rowIndex++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
