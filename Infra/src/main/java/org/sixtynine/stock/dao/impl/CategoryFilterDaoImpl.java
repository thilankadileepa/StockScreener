package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.sixtynine.stock.dao.CategoryFilterDao;
import org.sixtynine.stock.entity.CategoryFilter;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryFilterDaoImpl extends AbstractDaoImpl<CategoryFilter , Integer> implements
		CategoryFilterDao {

	protected CategoryFilterDaoImpl() {
		super(CategoryFilter.class);
	}

	@Override
	public void saveCategoryFilter(CategoryFilter categoryFilter) {
		saveOrUpdate(categoryFilter);
	}

	@Override
	public List<CategoryFilter> findCategoryFilters(int filterId) {
		return findByCriteria(Restrictions.eq("filter", filterId));
	}

}
