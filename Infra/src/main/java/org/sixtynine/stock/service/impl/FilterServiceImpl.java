package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.FilterDao;
import org.sixtynine.stock.entity.Filter;
import org.sixtynine.stock.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FilterServiceImpl implements FilterService {

	@Autowired
	private FilterDao filterDao;
	
	@Override
	public Filter findById(int id) {
		return filterDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveFilter(Filter filter) {
		filterDao.saveFilter(filter);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteFilter(int id) {
		Filter filter = filterDao.findById(id);
		if (filter != null) {
			filterDao.delete(filter);
		}
	}

	@Override
	public List<Filter> findFilters(int moduleId) {
		return filterDao.findFilters(moduleId);
	}

}
