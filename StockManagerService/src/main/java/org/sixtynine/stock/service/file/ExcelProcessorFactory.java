package org.sixtynine.stock.service.file;

/**
 * @author Thilanka
 *
 */
public interface ExcelProcessorFactory {
	
	public static final String FILE_TYPE_INTRADAY_SHARE = "INTRADAY_SHARE";
	
	ExcelProcessor getExcelProcessor(String fileType);
}
