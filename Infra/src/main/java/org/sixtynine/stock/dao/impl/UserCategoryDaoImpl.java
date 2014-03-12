package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.sixtynine.stock.dao.UserCategoryDao;
import org.sixtynine.stock.entity.UserCategory;
import org.springframework.stereotype.Repository;

@Repository
public class UserCategoryDaoImpl extends AbstractDaoImpl<UserCategory, Integer>
		implements UserCategoryDao {

	protected UserCategoryDaoImpl() {
		super(UserCategory.class);
	}

	@Override
	public void saveUserCategory(UserCategory userCategory) {
		saveOrUpdate(userCategory);
	}

	@Override
	public List<UserCategory> findUserCategories(String name) {
		return findByCriteria(Restrictions.like("name", name, MatchMode.START));
	}
}
