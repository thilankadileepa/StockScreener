package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.User;

public interface UserDao extends AbstractDao<User, Integer> {

	void saveUser(User user);

	List<User> findUser(String name);
}
