package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.FilterCategory;

public interface FilterCategoryService {

	FilterCategory findById(int id);

	void saveFilterCategory(FilterCategory filterCategory);

	void deleteFilterCategory(int id);

	List<FilterCategory> findFilterCategory(String name);
	
}
