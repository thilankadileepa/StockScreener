package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.UserCategory;

/**
 * @author Thilanka
 *
 */
public interface UserCategoryService {

	UserCategory findById(int id);

	void saveUserCategory(UserCategory userCategory);

	void deleteUserCategory(int id);

	List<UserCategory> findUserCategories(String name);
}
