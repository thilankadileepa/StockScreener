package org.sixtynine.stock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.entity.QuarterlyShareData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class QuarterlyShareDataServiceTest {

	@Autowired
	private QuarterlyShareDataService quarterlyShareDataService;
	
	@Autowired
	private CompanyService companyService;
	
	@After
	public void tearDown() throws Exception {
		QuarterlyShareData quarterlyShareData = createQuarterlyShareData();
		quarterlyShareDataService.deleteQuarterlyShareData(quarterlyShareData.getId());;
	}

	@Test
	public void testSaveQuarterlyShareData() throws Exception {
		QuarterlyShareData quarterlyShareData = createQuarterlyShareData();
		QuarterlyShareData found = quarterlyShareDataService.findById(quarterlyShareData.getId());
		assertEquals(quarterlyShareData, found);
	}

	private QuarterlyShareData createQuarterlyShareData() {
		QuarterlyShareData quarterlyShareData= new QuarterlyShareData();
		quarterlyShareData.setAverageEquity(12.50);
		quarterlyShareData.setAverageTotalAsse(58024.25);
		quarterlyShareData.setCash(1825.22);
		quarterlyShareData.setCompany(companyService.findById(16));
		quarterlyShareData.setDebt(10087400.00);
		quarterlyShareData.setRevenues(8000.89);
		quarterlyShareData.setEbitda(13800.36);
		quarterlyShareData.setInstOwnership(10245.55);
		quarterlyShareData.setPercentOwnbyInsiders(85702.22);
		quarterlyShareData.setProfit(780025.00);
		quarterlyShareData.setProfitAfterTax(8600.25);
		quarterlyShareData.setQuarterCode("Q1");
		quarterlyShareData.setRevenues(58005.65);
		quarterlyShareData.setSharesInFreefloat(78.25);
		quarterlyShareData.setWeightedAverage(65.88);
		quarterlyShareDataService.saveQuarterlyShareData(quarterlyShareData);		
		return quarterlyShareData;
	}

	@Test
	public void testSearchQuarterlyShareData() throws Exception {
		createQuarterlyShareData();
		List<QuarterlyShareData> quarterlyShareData = quarterlyShareDataService.findQuarterlyShareData(1);
		assertEquals(1, quarterlyShareData.size());
		assertEquals("1", quarterlyShareData.iterator().next().getId());
	}

	@Test
	public void testDeleteQuarterlyShareData() throws Exception {
		QuarterlyShareData quarterlyShareData = createQuarterlyShareData();
		assertNotNull(quarterlyShareDataService.findById(quarterlyShareData.getId()));
		quarterlyShareDataService.deleteQuarterlyShareData(quarterlyShareData.getId());
		assertNull(quarterlyShareDataService.findById(quarterlyShareData.getId()));
	}

	@Test
	public void testUpdateQuarterlyShareData() throws Exception {
		QuarterlyShareData quarterlyShareData = createQuarterlyShareData();
		QuarterlyShareData quarterlyShareData01 = quarterlyShareDataService.findById(quarterlyShareData.getId());
		assertNotNull(quarterlyShareData01);
		assertEquals(1, quarterlyShareData01.getId());

		quarterlyShareData01.setCash(1500088.00);
		quarterlyShareDataService.saveQuarterlyShareData(quarterlyShareData01);

		/*DailySectorData found = dailySectorDataService.findById(dailySectorData01.getId());
		assertNotNull(found);
		assertEquals("Edited", found.getName());*/

	}
	
}
