package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.UserCategory;

public interface StockService {

	UserCategory findById(int id);

	void saveUser(UserCategory userCategory);

	void deleteUser(int id);

	List<UserCategory> findUsers(String name);
}
