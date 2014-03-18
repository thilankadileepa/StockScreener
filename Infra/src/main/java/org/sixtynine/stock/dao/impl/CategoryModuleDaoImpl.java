package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.sixtynine.stock.dao.CategoryModuleDao;
import org.sixtynine.stock.entity.CategoryModule;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryModuleDaoImpl extends
		AbstractDaoImpl<CategoryModule, Integer> implements CategoryModuleDao {

	protected CategoryModuleDaoImpl() {
		super(CategoryModule.class);
	}

	@Override
	public void saveCategoryModule(CategoryModule categoryModule) {
		saveOrUpdate(categoryModule);
	}

	@Override
	public List<CategoryModule> findCategoryModules(int moduleId) {
		return findByCriteria(Restrictions.eq("module", moduleId));
	}

}
