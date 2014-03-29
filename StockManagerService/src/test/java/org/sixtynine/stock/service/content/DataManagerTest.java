package org.sixtynine.stock.service.content;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sixtynine.stock.Constants.CommonData;
import org.sixtynine.stock.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class DataManagerTest {

	@Autowired
	ApplicationContext context;

	@Test
	public void testInit() {
		DataManagerService service = (DataManagerService) context
				.getBean("dataManagerService");
		
		service.init();
		
		List<BaseEntity> companyList = service.getData(CommonData.COMPANY.toString());
		assert(companyList.size() > 0);
	}
}
