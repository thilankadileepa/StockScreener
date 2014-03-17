package org.sixtynine.stock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.entity.IntradayShareData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class IntradayShareDataServiceTest {

	@Autowired
	private IntradayShareDataService intradayShareDataService;
	
	@Autowired
	private CompanyService companyService;
	
	@After
	public void tearDown() throws Exception {
		IntradayShareData intradayShareData = createIntradayShareData();
		intradayShareDataService.deleteIntradayShareData(intradayShareData.getId());;
	}

	@Test
	public void testSaveIntradayShareData() throws Exception {
		IntradayShareData intradayShareData = createIntradayShareData();
		IntradayShareData found = intradayShareDataService.findById(intradayShareData.getId());
		assertEquals(intradayShareData, found);
	}

	private IntradayShareData createIntradayShareData() {
		IntradayShareData intradayShareData= new IntradayShareData();
		intradayShareData.setClosingPrice(12.50);
		intradayShareData.setLastTradedPrice(125.25);
		intradayShareData.setPercentageChange(25.22);
		intradayShareData.setCompany(companyService.findById(16));
		intradayShareData.setShareVolume(1000000.00);
		intradayShareData.setTime(new Date());
		intradayShareData.setTradeVolume(500000.00);
		intradayShareData.setTurnover(87.00);
		intradayShareData.setValueChange(69.98);
		intradayShareDataService.saveIntradayShareData(intradayShareData);		
		return intradayShareData;
	}

	@Test
	public void testSearchIntradayShareData() throws Exception {
		createIntradayShareData();
		List<IntradayShareData> intradayShareData = intradayShareDataService.findIntradayShareData(1);
		assertEquals(1, intradayShareData.size());
		assertEquals("1", intradayShareData.iterator().next().getId());
	}

	@Test
	public void testDeleteIntradayShareData() throws Exception {
		IntradayShareData intradayShareData = createIntradayShareData();
		assertNotNull(intradayShareDataService.findById(intradayShareData.getId()));
		intradayShareDataService.deleteIntradayShareData(intradayShareData.getId());
		assertNull(intradayShareDataService.findById(intradayShareData.getId()));
	}

	@Test
	public void testUpdateIntradayShareData() throws Exception {
		IntradayShareData intradayShareData = createIntradayShareData();
		IntradayShareData intradayShareData01 = intradayShareDataService.findById(intradayShareData.getId());
		assertNotNull(intradayShareData01);
		assertEquals(1, intradayShareData01.getId());

		intradayShareData01.setShareVolume(85000.00);
		intradayShareDataService.saveIntradayShareData(intradayShareData01);

		/*DailySectorData found = dailySectorDataService.findById(dailySectorData01.getId());
		assertNotNull(found);
		assertEquals("Edited", found.getName());*/

	}
	
}
