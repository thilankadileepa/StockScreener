package org.sixtynine.stock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.entity.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class SectorServiceTest {
	
	@Autowired
	private SectorService sectorService;
	
	@After
	public void tearDown() throws Exception {
		Sector sector = createSector("Test00");
		sectorService.deleteSector(sector.getId());
	}

	@Test
	public void testSaveSector() throws Exception {
		Sector sector = createSector("Test01");
		Sector found = sectorService.findById(sector.getId());
		assertEquals(sector, found);
	}

	private Sector createSector(String name) {
		Sector sector = new Sector(name);
		sectorService.saveSector(sector);		
		return sector;
	}

	@Test
	public void testSearchSector() throws Exception {
		createSector("Test00");
		List<Sector> sector = sectorService.findSector("Test00");
		assertEquals(1, sector.size());
		assertEquals("Test00", sector.iterator().next().getName());
	}

	@Test
	public void testDeleteModule() throws Exception {
		Sector sector = createSector("Test03");
		assertNotNull(sectorService.findById(sector.getId()));
		sectorService.deleteSector(sector.getId());
		assertNull(sectorService.findById(sector.getId()));
	}

	@Test
	public void testUpdateModule() throws Exception {
		Sector sector = createSector("Test04");
		Sector sector01 = sectorService.findById(sector.getId());
		assertNotNull(sector01);
		assertEquals("Test04", sector01.getName());

		sector01.setName("Edited");
		sectorService.saveSector(sector01);

		Sector found = sectorService.findById(sector01.getId());
		assertNotNull(found);
		assertEquals("Edited", found.getName());

	}
	

}
