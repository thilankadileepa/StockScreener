package org.sixtynine.stock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.entity.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * test cases for Filter service
 * 
 * @author Thilan
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class FilterServiceTest {

	private static final Logger logger = Logger
			.getLogger(FilterServiceTest.class);

	@Autowired
	private FilterService filterService;
	
	@Autowired
	private ModuleService moduleService;

	@After
	public void tearDown() throws Exception {
		Filter filter = createFilter();
		
		filterService.deleteFilter(filter.getId());
	}

	@Test
	public void testSaveFilter() throws Exception {
		Filter filter = createFilter();
		
		logger.info("Filter Name :" + filter.getModule().getName() + "-" + filter.getId());
		
		Filter found = filterService.findById(filter.getId());
		assertEquals(filter, found);
	}

	private Filter createFilter() {
		Filter filter = new Filter();
		filter.setFilterValues("test011,test03");
		filter.setModule(moduleService.findById(1));
		filterService.saveFilter(filter);

		return filter;
	}

	@Test
	public void testSearchFilter() throws Exception {
		createFilter();
		List<Filter> filter = filterService.findFilters(1);
		assertEquals("Saminda", filter.iterator().next().getFilterValues());
	}

	@Test
	public void testDeleteFilter() throws Exception {
		Filter filter = createFilter();
		assertNotNull(filterService.findById(filter.getId()));
		filterService.deleteFilter(filter.getId());
		assertNull(filterService.findById(filter.getId()));
	}

	@Test
	public void testUpdateFilter() throws Exception {
		Filter filter = createFilter();
		Filter filter01 = filterService.findById(filter.getId());
		assertNotNull(filter01);
		assertEquals("Dhanusha", filter01.getFilterValues());

		filter01.setFilterValues("Edited");
		filterService.saveFilter(filter01);

		Filter found = filterService.findById(filter01.getId());
		assertNotNull(found);
		assertEquals("Edited", found.getFilterValues());

	}
}