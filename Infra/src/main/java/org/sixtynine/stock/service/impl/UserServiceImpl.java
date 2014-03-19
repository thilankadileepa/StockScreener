package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.UserDao;
import org.sixtynine.stock.entity.User;
import org.sixtynine.stock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	
	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(int id) {
		User user = userDao.findById(id);
		if (user != null) {
			userDao.delete(user);
		}
	}

	@Override
	public List<User> findUsers(String name) {
		return userDao.findUser(name);
	}

}
