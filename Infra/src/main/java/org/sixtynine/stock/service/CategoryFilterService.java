package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.CategoryFilter;

public interface CategoryFilterService {

	
	CategoryFilter findById(int id);

	void saveCategoryFilter(CategoryFilter categoryFilter);

	void deleteCategoryFilter(int id);

	List<CategoryFilter> findCategoryFilters(int filterId);
}
