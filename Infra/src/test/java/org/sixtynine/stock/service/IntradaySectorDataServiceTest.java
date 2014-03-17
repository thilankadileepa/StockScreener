package org.sixtynine.stock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.entity.IntradaySectorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class IntradaySectorDataServiceTest {

	@Autowired
	private IntradaySectorDataService intradaySectorDataService;
	
	@Autowired
	private SectorService sectorService;
	
	@After
	public void tearDown() throws Exception {
		IntradaySectorData intradaySectorData = createIntradaySectorData();
		intradaySectorDataService.deleteIntradaySectorData(intradaySectorData.getId());;
	}

	@Test
	public void testSaveIntradaySectorData() throws Exception {
		IntradaySectorData intradaySectorData = createIntradaySectorData();
		IntradaySectorData found = intradaySectorDataService.findById(intradaySectorData.getId());
		assertEquals(intradaySectorData, found);
	}

	private IntradaySectorData createIntradaySectorData() {
		IntradaySectorData intradaySectorData = new IntradaySectorData();
		intradaySectorData.setPercentageChange(0.050);
		intradaySectorData.setSequence(1);
		Date today = new Date();
		intradaySectorData.setTime(today);
		intradaySectorData.setSector(sectorService.findById(24));
		intradaySectorData.setValue(9000.25);
		intradaySectorData.setValueChange(58.89);
		intradaySectorDataService.saveIntradaySectorData(intradaySectorData);
		return intradaySectorData;
	}

	@Test
	public void testSearchIntradaySectorData() throws Exception {
		createIntradaySectorData();
		List<IntradaySectorData> intradaySectorData = intradaySectorDataService.findIntradaySectorData(sectorService.findById(24));
		assertEquals(24, intradaySectorData.size());
		assertEquals("24", intradaySectorData.iterator().next().getId());
	}

	@Test
	public void testDeleteDailySectorData() throws Exception {
		IntradaySectorData intradaySectorData = createIntradaySectorData();
		assertNotNull(intradaySectorDataService.findById(intradaySectorData.getId()));
		intradaySectorDataService.deleteIntradaySectorData(intradaySectorData.getId());
		assertNull(intradaySectorDataService.findById(intradaySectorData.getId()));
	}

	@Test
	public void testUpdateDailySectorData() throws Exception {
		IntradaySectorData intradaySectorData = createIntradaySectorData();
		IntradaySectorData intradaySectorData01 = intradaySectorDataService.findById(intradaySectorData.getId());
		assertNotNull(intradaySectorData01);
		assertEquals(1, intradaySectorData01.getId());

		intradaySectorData01.setValue(2500.00);
		intradaySectorDataService.saveIntradaySectorData(intradaySectorData01);

		/*DailySectorData found = dailySectorDataService.findById(dailySectorData01.getId());
		assertNotNull(found);
		assertEquals("Edited", found.getName());*/

	}
	
}
