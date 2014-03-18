package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.Filter;

public interface FilterService {

	Filter findById(int id);

	void saveFilter(Filter filter);

	void deleteFilter(int id);

	List<Filter> findFilters(int moduleId);
	
}
