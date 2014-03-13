package org.sixtynine.stock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.entity.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class ModuleServiceTest {

	@Autowired
	private ModuleService moduleService;
	
	@After
	public void tearDown() throws Exception {
		Module module = createModule("Test00");
		moduleService.deleteModule(module.getId());
	}

	@Test
	public void testSaveModule() throws Exception {
		Module module = createModule("Test01");
		Module found = moduleService.findById(module.getId());
		assertEquals(module, found);
	}

	private Module createModule(String name) {
		Module module= new Module(name);
		moduleService.saveModule(module);		
		return module;
	}

	@Test
	public void testSearchModule() throws Exception {
		createModule("Test00");
		List<Module> module = moduleService.findModules("Test00");
		assertEquals(1, module.size());
		assertEquals("Test00", module.iterator().next().getName());
	}

	@Test
	public void testDeleteModule() throws Exception {
		Module module = createModule("Test03");
		assertNotNull(moduleService.findById(module.getId()));
		moduleService.deleteModule(module.getId());
		assertNull(moduleService.findById(module.getId()));
	}

	@Test
	public void testUpdateModule() throws Exception {
		Module module = createModule("Test04");
		Module module01 = moduleService.findById(module.getId());
		assertNotNull(module01);
		assertEquals("Test04", module01.getName());

		module01.setName("Edited");
		moduleService.saveModule(module01);

		Module found = moduleService.findById(module01.getId());
		assertNotNull(found);
		assertEquals("Edited", found.getName());

	}
	
	
}
