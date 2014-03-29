package org.sixtynine.stock.service.file;

import org.apache.poi.ss.usermodel.Cell;

/**
 * @author Thilanka
 *
 */
public abstract class ExcelProcessor {
	
	public abstract void process(String filePath);

	public Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			return cell.getNumericCellValue();
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		}

		return null;
	}
}
