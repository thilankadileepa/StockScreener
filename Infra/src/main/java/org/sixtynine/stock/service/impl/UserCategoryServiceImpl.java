package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.UserCategoryDao;
import org.sixtynine.stock.entity.UserCategory;
import org.sixtynine.stock.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserCategoryServiceImpl implements UserCategoryService {

	@Autowired
	private UserCategoryDao userCategoryDao;

	@Override
	public UserCategory findById(int id) {
		return userCategoryDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUser(UserCategory userCategory) {
		userCategoryDao.saveUserCategory(userCategory);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(int id) {
		UserCategory user = userCategoryDao.findById(id);
		if (user != null) {
			userCategoryDao.delete(user);
		}
	}

	@Override
	public List<UserCategory> findUsers(String user) {
		return userCategoryDao.findUserCategories(user);
	}
}
