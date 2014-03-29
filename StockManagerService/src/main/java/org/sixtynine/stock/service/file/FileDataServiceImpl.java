package org.sixtynine.stock.service.file;

import org.springframework.beans.factory.annotation.Autowired;

public class FileDataServiceImpl implements FileDataService {

	@Autowired
	ExcelProcessorFactory excelProcessorFactory;

	private String fileBaseDir;

	@Override
	public void ping() {
		System.out.println("Ping......... : " + fileBaseDir);
	}

	@Override
	public void process(String fileName) {
		excelProcessorFactory.getExcelProcessor(ExcelProcessorFactory.FILE_TYPE_INTRADAY_SHARE).process(fileBaseDir + fileName);
	}

	public void setFileBaseDir(String fileBaseDir) {
		this.fileBaseDir = fileBaseDir;
	}

}
