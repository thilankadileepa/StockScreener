package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.CategoryModule;

public interface CategoryModuleService {

	CategoryModule findById(int id);

	void saveCategoryModule(CategoryModule categoryModule);

	void deleteCategoryModule(int id);

	List<CategoryModule> findCategoryModules(int moduleId);
	
}
