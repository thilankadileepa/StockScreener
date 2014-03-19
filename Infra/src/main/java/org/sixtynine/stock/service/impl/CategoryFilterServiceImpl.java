package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.CategoryFilterDao;
import org.sixtynine.stock.entity.CategoryFilter;
import org.sixtynine.stock.service.CategoryFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryFilterServiceImpl implements CategoryFilterService {

	@Autowired
	private CategoryFilterDao categoryFilterDao;
	
	@Override
	public CategoryFilter findById(int id) {
		return categoryFilterDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveCategoryFilter(CategoryFilter categoryFilter) {
		categoryFilterDao.saveCategoryFilter(categoryFilter);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteCategoryFilter(int id) {
		CategoryFilter categoryFilter = categoryFilterDao.findById(id);
		if (categoryFilter != null) {
			categoryFilterDao.delete(categoryFilter);
		}
	}

	@Override
	public List<CategoryFilter> findCategoryFilters(int filterId) {
		return categoryFilterDao.findCategoryFilters(filterId);
	}

}
