package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.CategoryModule;

public interface CategoryModuleDao extends AbstractDao<CategoryModule, Integer> {

	void saveCategoryModule(CategoryModule categoryModule);

	List<CategoryModule> findCategoryModules(int moduleId);
	
}
