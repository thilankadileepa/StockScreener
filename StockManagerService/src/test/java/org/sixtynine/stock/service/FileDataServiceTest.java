package org.sixtynine.stock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.service.file.FileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class FileDataServiceTest {

	@Autowired
	ApplicationContext context;

	@Test
	public void testPing() {

		FileDataService fileDataService = (FileDataService) context
				.getBean("fileDataService");

		fileDataService.ping();

	}

	@Test
	public void testProcess() {
		FileDataService fileDataService = (FileDataService) context
				.getBean("fileDataService");

		fileDataService.process("Daily data upload 25 Mar 2014.xlsx");
	}
}
