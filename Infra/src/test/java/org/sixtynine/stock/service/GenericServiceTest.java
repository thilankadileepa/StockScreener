package org.sixtynine.stock.service;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.entity.BaseEntity;
import org.sixtynine.stock.entity.UserCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class GenericServiceTest {

	private static final Logger logger = Logger
			.getLogger(UserCategoryServiceTest.class);

	@Autowired
	private GenericService genericService;

	@Test
	public void testSave() {
		UserCategory userCategory = new UserCategory("Test User Edited");
		genericService.saveOrUpdate(userCategory);

		BaseEntity found = genericService.findById(userCategory.getId(), UserCategory.class);
		assertEquals(found.getClass(),UserCategory.class);
		UserCategory foundUserCategory = (UserCategory)found;
		assertEquals(foundUserCategory, userCategory);
	}
}
