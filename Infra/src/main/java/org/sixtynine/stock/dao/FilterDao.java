package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.Filter;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface FilterDao extends AbstractDao<Filter, Integer> {

	void saveFilter(Filter filter);

	List<Filter> findFilters(int module);
}
