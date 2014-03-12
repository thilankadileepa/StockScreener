package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.UserCategory;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UserCategoryDao extends AbstractDao<UserCategory, Integer> {
	void saveUserCategory(UserCategory userCategory);

	List<UserCategory> findUserCategories(String userName);
}