package org.sixtynine.stock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.entity.AnnualShareData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class AnnualShareDataServiceTest {

	@Autowired
	private AnnualShareDataService annualShareDataService;
	
	@Autowired
	private CompanyService companyService;
	
	@After
	public void tearDown() throws Exception {
		AnnualShareData annualShareData = createAnnualShareData();
		annualShareDataService.deleteAnnualShareData(annualShareData.getId());;
	}

	@Test
	public void testSaveAnnualShareData() throws Exception {
		AnnualShareData annualShareData = createAnnualShareData();
		AnnualShareData found = annualShareDataService.findById(annualShareData.getId());
		assertEquals(annualShareData, found);
	}

	private AnnualShareData createAnnualShareData() {
		AnnualShareData annualShareData= new AnnualShareData();
		annualShareData.setDividents(12.50);
		annualShareData.setEbitda(125.25);
		annualShareData.setNetProfit(1825751.22);
		annualShareData.setCompany(companyService.findById(16));
		annualShareData.setNumberOfShares(10000.00);
		annualShareData.setRevenues(8000.89);
		annualShareData.setYear(13);
		annualShareDataService.saveAnnualShareData(annualShareData);		
		return annualShareData;
	}

	@Test
	public void testSearchAnnualShareData() throws Exception {
		createAnnualShareData();
		List<AnnualShareData> annualShareData = annualShareDataService.findAnnualShareData(1);
		assertEquals(1, annualShareData.size());
		assertEquals("1", annualShareData.iterator().next().getId());
	}

	@Test
	public void testDeleteAnnualShareData() throws Exception {
		AnnualShareData annualShareData = createAnnualShareData();
		assertNotNull(annualShareDataService.findById(annualShareData.getId()));
		annualShareDataService.deleteAnnualShareData(annualShareData.getId());
		assertNull(annualShareDataService.findById(annualShareData.getId()));
	}

	@Test
	public void testUpdateAnnualShareData() throws Exception {
		AnnualShareData annualShareData = createAnnualShareData();
		AnnualShareData annualShareData01 = annualShareDataService.findById(annualShareData.getId());
		assertNotNull(annualShareData01);
		assertEquals(1, annualShareData01.getId());

		annualShareData01.setNumberOfShares(15000.00);
		annualShareDataService.saveAnnualShareData(annualShareData01);

		/*DailySectorData found = dailySectorDataService.findById(dailySectorData01.getId());
		assertNotNull(found);
		assertEquals("Edited", found.getName());*/

	}
	
}
