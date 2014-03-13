package org.sixtynine.stock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.entity.UserCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * test cases for user category service
 * 
 * @author Thilanka
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class UserCategoryServiceTest {

	@Autowired
	private UserCategoryService stockService;


	@After
	public void tearDown() throws Exception {
		UserCategory userCategory = createUser("Namal");
		stockService.deleteUserCategory(userCategory.getId());
	}

	@Test
	public void testSaveUser() throws Exception {
		UserCategory userCategory = createUser("Thilanka");
		UserCategory found = stockService
				.findById(userCategory.getId());
		assertEquals(userCategory, found);
	}

	private UserCategory createUser(String name) {
		UserCategory userCategory = new UserCategory(name);
		stockService.saveUserCategory(userCategory);
		
		return userCategory;
	}

	@Test
	public void testSearchUser() throws Exception {
		createUser("Saminda");
		List<UserCategory> users = stockService.findUserCategories("Saminda");
		assertEquals(1, users.size());
		assertEquals("Saminda", users.iterator().next().getName());
	}

	@Test
	public void testDeleteUser() throws Exception {
		UserCategory userCategory = createUser("Hasantha");
		assertNotNull(stockService.findById(userCategory.getId()));
		stockService.deleteUserCategory(userCategory.getId());
		assertNull(stockService.findById(userCategory.getId()));
	}

	@Test
	public void testUpdateUser() throws Exception {
		UserCategory userCategory = createUser("Dhanusha");
		UserCategory user01 = stockService.findById(userCategory.getId());
		assertNotNull(user01);
		assertEquals("Dhanusha", user01.getName());

		user01.setName("Edited");
		stockService.saveUserCategory(user01);

		UserCategory found = stockService.findById(user01.getId());
		assertNotNull(found);
		assertEquals("Edited", found.getName());

	}
}