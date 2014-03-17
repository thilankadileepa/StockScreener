package org.sixtynine.stock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.entity.DailySectorData;
import org.sixtynine.stock.entity.Sector;
import org.sixtynine.stock.service.impl.SectorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class DailySectorDataTest {

	@Autowired
	private DailySectorDataService dailySectorDataService;
	
	@Autowired
	private SectorService sectorService;
	
	@After
	public void tearDown() throws Exception {
		DailySectorData dailySectorData = createDailySectorData();
		dailySectorDataService.deleteDailySectorData(dailySectorData.getId());;
	}

	@Test
	public void testSaveDailySectorData() throws Exception {
		DailySectorData dailySectorData = createDailySectorData();
		DailySectorData found = dailySectorDataService.findById(dailySectorData.getId());
		assertEquals(dailySectorData, found);
	}

	private DailySectorData createDailySectorData() {
		DailySectorData dailySectorData= new DailySectorData();
		dailySectorData.setClosingValue(1250.50);
		dailySectorData.setDate(new Date());
		dailySectorData.setNoOfTrades(6200.22);
		System.out.println(sectorService.findById(24).getName());
		dailySectorData.setSector(sectorService.findById(24));
		dailySectorData.setTurnOver(9000.25);
		dailySectorData.setVolume(8000.89);
		dailySectorDataService.saveDailySectorData(dailySectorData);		
		return dailySectorData;
	}

	@Test
	public void testSearchDailySectorData() throws Exception {
		createDailySectorData();
		List<DailySectorData> dailySectorData = dailySectorDataService.findDailySectorData(1);
		assertEquals(1, dailySectorData.size());
		assertEquals("1", dailySectorData.iterator().next().getId());
	}

	@Test
	public void testDeleteDailySectorData() throws Exception {
		DailySectorData dailySectorData = createDailySectorData();
		assertNotNull(dailySectorDataService.findById(dailySectorData.getId()));
		dailySectorDataService.deleteDailySectorData(dailySectorData.getId());
		assertNull(dailySectorDataService.findById(dailySectorData.getId()));
	}

	@Test
	public void testUpdateDailySectorData() throws Exception {
		DailySectorData dailySectorData = createDailySectorData();
		DailySectorData dailySectorData01 = dailySectorDataService.findById(dailySectorData.getId());
		assertNotNull(dailySectorData01);
		assertEquals(1, dailySectorData01.getId());

		dailySectorData01.setNoOfTrades(2500.00);
		dailySectorDataService.saveDailySectorData(dailySectorData01);

		/*DailySectorData found = dailySectorDataService.findById(dailySectorData01.getId());
		assertNotNull(found);
		assertEquals("Edited", found.getName());*/

	}
	
}
