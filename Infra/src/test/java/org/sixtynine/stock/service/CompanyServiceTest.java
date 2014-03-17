package org.sixtynine.stock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class CompanyServiceTest {

	private static final Logger logger = Logger
			.getLogger(CompanyServiceTest.class);

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private SectorService sectorService;

	@After
	public void tearDown() throws Exception {
		Company company = createCompany("Jhon Kills");
		companyService.deleteCompany(company.getId());
	}

	@Test
	public void testSaveCompany() throws Exception {
		Company company = createCompany("Uniliver");
		
		logger.info("company Name :" + company.getName() + "-" + company.getId());
		
		Company found = companyService.findById(company.getId());
		assertEquals(company, found);
	}

	private Company createCompany(String name) {
		Company company = new Company(name);
		
		company.setSector(sectorService.findById(24));
		companyService.saveCompany(company);

		return company;
	}

	@Test
	public void testSearchCompany() throws Exception {
		createCompany("EAP");
		List<Company> company = companyService.findCompany("EAP");
		assertEquals("EAP", company.iterator().next().getName());
	}

	@Test
	public void testDeleteCompany() throws Exception {
		Company company = createCompany("Sixtynine79");
		assertNotNull(companyService.findById(company.getId()));
		companyService.deleteCompany(company.getId());
		assertNull(companyService.findById(company.getId()));
	}

	@Test
	public void testUpdateUser() throws Exception {
		Company company = createCompany("WSO2");
		Company company01 = companyService.findById(company.getId());
		assertNotNull(company01);
		assertEquals("WSO2", company01.getName());

		company01.setName("Codegen");
		companyService.saveCompany(company01);

		Company found = companyService.findById(company01.getId());
		assertNotNull(found);
		assertEquals("Codegen", found.getName());

	}
	
}
