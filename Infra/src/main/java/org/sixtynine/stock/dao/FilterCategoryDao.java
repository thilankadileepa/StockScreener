package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.FilterCategory;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Thilan
 *
 */

@Transactional(readOnly = true)
public interface FilterCategoryDao extends AbstractDao<FilterCategory, Integer>{

	void saveFilterCategory(FilterCategory filterCategory);

	List<FilterCategory> findFilterCategories(String filterCategory);
	
}
