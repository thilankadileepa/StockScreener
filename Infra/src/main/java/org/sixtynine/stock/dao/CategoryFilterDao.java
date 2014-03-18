package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.CategoryFilter;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CategoryFilterDao extends AbstractDao<CategoryFilter, Integer> {

	void saveCategoryFilter(CategoryFilter categoryFilter);

	List<CategoryFilter> findCategoryFilters(int filterId);
	
}
