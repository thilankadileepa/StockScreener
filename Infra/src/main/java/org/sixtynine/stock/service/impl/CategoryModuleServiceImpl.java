package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.CategoryModuleDao;
import org.sixtynine.stock.entity.CategoryModule;
import org.sixtynine.stock.service.CategoryModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryModuleServiceImpl implements CategoryModuleService {

	@Autowired
	private CategoryModuleDao categoryModuleDao;
	
	@Override
	public CategoryModule findById(int id) {
		return categoryModuleDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveCategoryModule(CategoryModule categoryModule) {
		categoryModuleDao.saveCategoryModule(categoryModule);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteCategoryModule(int id) {
		CategoryModule categoryModule = categoryModuleDao.findById(id);
		if (categoryModule != null) {
			categoryModuleDao.delete(categoryModule);
		}
	}

	@Override
	public List<CategoryModule> findCategoryModules(int moduleId) {
		return categoryModuleDao.findCategoryModules(moduleId);
	}

}
