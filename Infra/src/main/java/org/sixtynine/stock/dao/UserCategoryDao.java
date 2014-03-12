package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.UserCategory;

public interface UserCategoryDao extends AbstractDao<UserCategory, String> {
	void saveUserCategory(UserCategory userCategory);
	List<UserCategory> findUserCategories(String userName);
}