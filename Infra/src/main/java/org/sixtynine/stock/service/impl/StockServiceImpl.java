package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.UserCategoryDao;
import org.sixtynine.stock.entity.UserCategory;
import org.sixtynine.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("stockService")
@Transactional(readOnly = true)
public class StockServiceImpl implements StockService {

	@Autowired
	private UserCategoryDao userCategoryDao;

	@Override
	public UserCategory findByUserName(String userName) {
		return userCategoryDao.findById(userName);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUser(UserCategory userCategory) {
		userCategoryDao.saveUserCategory(userCategory);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(String userName) {
		UserCategory user = userCategoryDao.findById(userName);
		if (user != null) {
			userCategoryDao.delete(user);
		}
	}

	@Override
	public List<UserCategory> findUsers(String user) {
		return userCategoryDao.findUserCategories(user);
	}
}
