package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.FilterCategoryDao;
import org.sixtynine.stock.entity.FilterCategory;
import org.sixtynine.stock.service.FilterCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FilterCategoryServiceImpl implements FilterCategoryService {

	@Autowired
	private FilterCategoryDao filterCategoryDao;
	
	@Override
	public FilterCategory findById(int id) {
		return filterCategoryDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveFilterCategory(FilterCategory filterCategory) {
		filterCategoryDao.saveFilterCategory(filterCategory);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteFilterCategory(int id) {
		FilterCategory filterCategory = filterCategoryDao.findById(id);
		if (filterCategory != null) {
			filterCategoryDao.delete(filterCategory);
		}
	}

	@Override
	public List<FilterCategory> findFilterCategory(String name) {
		return filterCategoryDao.findFilterCategories(name);
	}

}
