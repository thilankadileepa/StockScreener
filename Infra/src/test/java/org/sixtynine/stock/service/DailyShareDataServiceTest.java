package org.sixtynine.stock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.entity.DailyShareData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class DailyShareDataServiceTest {

	@Autowired
	private DailyShareDataService dailyShareDataService;
	
	@After
	public void tearDown() throws Exception {
		DailyShareData dailyShareData = createDailyShareData();
		dailyShareDataService.deleteDailyShareData(dailyShareData.getId());;
	}

	@Test
	public void testSaveDailyShareData() throws Exception {
		DailyShareData dailyShareData = createDailyShareData();
		DailyShareData found = dailyShareDataService.findById(dailyShareData.getId());
		assertEquals(dailyShareData, found);
	}

	private DailyShareData createDailyShareData() {
		DailyShareData dailyShareData = new DailyShareData();
		dailyShareData.setSharePrice(1250.50);
		dailyShareData.setDate(new Date());
		dailyShareData.setNoOfTrade(6200.22);
		dailyShareData.setCompanyId(1);
		dailyShareData.setTurnOver(9000.25);
		dailyShareData.setVolume(8000.89);
		dailyShareData.setLow(105.89);
		dailyShareData.setHigh(155.58);
		dailyShareData.setOpeningPrice(108.89);
		dailyShareData.setLow(105.89);
		dailyShareDataService.saveDailyShareData(dailyShareData);		
		return dailyShareData;
	}

	@Test
	public void testSearchDailySectorData() throws Exception {
		createDailyShareData();
		List<DailyShareData> dailyShareData = dailyShareDataService.findDailyShareData(1);
		assertEquals(1, dailyShareData.size());
		assertEquals("1", dailyShareData.iterator().next().getId());
	}

	@Test
	public void testDeleteDailySectorData() throws Exception {
		DailyShareData dailyShareData = createDailyShareData();
		assertNotNull(dailyShareDataService.findById(dailyShareData.getId()));
		dailyShareDataService.deleteDailyShareData(dailyShareData.getId());
		assertNull(dailyShareDataService.findById(dailyShareData.getId()));
	}

	@Test
	public void testUpdateDailySectorData() throws Exception {
		DailyShareData dailyShareData = createDailyShareData();
		DailyShareData dailyShareData01 = dailyShareDataService.findById(dailyShareData.getId());
		assertNotNull(dailyShareData01);
		assertEquals(1, dailyShareData01.getId());

		dailyShareData01.setLow(2500.00);
		dailyShareDataService.saveDailyShareData(dailyShareData01);

		/*DailySectorData found = dailySectorDataService.findById(dailySectorData01.getId());
		assertNotNull(found);
		assertEquals("Edited", found.getName());*/

	}
	
}
