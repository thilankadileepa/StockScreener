package org.sixtynine.stock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.entity.User;
import org.sixtynine.stock.entity.UserCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * test cases for user service
 * 
 * @author Thilan
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class UserServiceTest {

	private static final Logger logger = Logger
			.getLogger(UserServiceTest.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserCategoryService userCategoryService;

	@After
	public void tearDown() throws Exception {
		User user = createUser("Namal");
		userService.deleteUser(user.getId());
	}

	@Test
	public void testSaveUser() throws Exception {
		User user = createUser("Nimantha");		
		logger.info("User Category Name :" + user.getUserName() + "-" + user.getId());
		
		User found = userService.findById(user.getId());
		assertEquals(user, found);
	}

	private User createUser(String name) {
		User user = new User(name);
		user.setUser(user);
		user.setUserCategory(userCategoryService.findById(1));
		userService.saveUser(user);
		return user;
	}

	@Test
	public void testSearchUser() throws Exception {
		createUser("Saminda");
		List<User> users = userService.findUsers("Saminda");
		assertEquals("Saminda", users.iterator().next().getUserName());
	}

	@Test
	public void testDeleteUser() throws Exception {
		User user = createUser("Hasantha");
		assertNotNull(userService.findById(user.getId()));
		userService.deleteUser(user.getId());
		assertNull(userService.findById(user.getId()));
	}

	@Test
	public void testUpdateUser() throws Exception {
		User user = createUser("Dhanusha");
		User user01 = userService.findById(user.getId());
		assertNotNull(user01);
		assertEquals("Dhanusha", user01.getUserName());

		user01.setUserName("Edited");
		userService.saveUser(user01);

		User found = userService.findById(user01.getId());
		assertNotNull(found);
		assertEquals("Edited", found.getUserName());

	}
}