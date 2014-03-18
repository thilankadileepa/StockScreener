package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.User;

public interface UserService {

	User findById(int id);

	void saveUser(User user);

	void deleteUser(int id);

	List<User> findUsers(String name);
	
}
