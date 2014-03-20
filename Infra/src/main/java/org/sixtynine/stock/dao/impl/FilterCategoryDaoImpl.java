package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.sixtynine.stock.dao.FilterCategoryDao;
import org.sixtynine.stock.entity.FilterCategory;
import org.springframework.stereotype.Repository;

/**
 * @author Thilan
 *
 */

@Repository
public class FilterCategoryDaoImpl extends
		AbstractDaoImpl<FilterCategory, Integer> implements FilterCategoryDao{

	
	protected FilterCategoryDaoImpl() {
		super(FilterCategory.class);
	}
	
	@Override
	public void saveFilterCategory(FilterCategory filterCategory) {
		saveOrUpdate(filterCategory);
	}

	@Override
	public List<FilterCategory> findFilterCategories(String filterCategory) {
		return findByCriteria(Restrictions.like("filterType", filterCategory, MatchMode.START));
	}

}
