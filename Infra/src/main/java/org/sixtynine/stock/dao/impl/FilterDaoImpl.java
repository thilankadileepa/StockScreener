package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.sixtynine.stock.dao.FilterDao;
import org.sixtynine.stock.entity.Filter;
import org.springframework.stereotype.Repository;

@Repository
public class FilterDaoImpl extends AbstractDaoImpl<Filter, Integer> implements
		FilterDao {

	protected FilterDaoImpl() {
		super(Filter.class);
	}

	@Override
	public void saveFilter(Filter filter) {
		saveOrUpdate(filter);
	}

	@Override
	public List<Filter> findFilters(int filter) {
		return findByCriteria(Restrictions.eq("module", filter));
	}

}
