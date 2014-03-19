package org.sixtynine.stock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.entity.CategoryModule;
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
public class CategoryModuleServiceTest {

	private static final Logger logger = Logger
			.getLogger(CategoryModuleServiceTest.class);

	@Autowired
	private CategoryModuleService categoryModuleService;
	
	@Autowired
	private ModuleService moduleService;

	@Autowired
	private UserCategoryService userCategoryService;
	
	@After
	public void tearDown() throws Exception {
		CategoryModule categoryModule = createCategoryModule();
		
		categoryModuleService.deleteCategoryModule(categoryModule.getId());
	}

	@Test
	public void testSaveCategoryModule() throws Exception {
		CategoryModule categoryModule = createCategoryModule();
		
		logger.info("Filter Name :" + categoryModule.getModule().getName() + "-" + categoryModule.getId());
		
		CategoryModule found = categoryModuleService.findById(categoryModule.getId());
		assertEquals(categoryModule, found);
	}

	private CategoryModule createCategoryModule() {
		CategoryModule categoryModule = new CategoryModule();
		categoryModule.setUserCategory(userCategoryService.findById(1));
		categoryModule.setModule(moduleService.findById(1));
		categoryModuleService.saveCategoryModule(categoryModule);

		return categoryModule;
	}

	@Test
	public void testSearchCategoryModule() throws Exception {
		createCategoryModule();
		List<CategoryModule> categoryModule = categoryModuleService.findCategoryModules(1);
		assertEquals(1, categoryModule.iterator().next().getModule().getId());
	}

	@Test
	public void testDeleteFilter() throws Exception {
		CategoryModule categoryModule = createCategoryModule();
		assertNotNull(categoryModuleService.findById(categoryModule.getId()));
		categoryModuleService.deleteCategoryModule(categoryModule.getId());
		assertNull(categoryModuleService.findById(categoryModule.getId()));
	}

	
}