package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.UserCategory;

public interface StockService {
	UserCategory findByUserName(String name);
    void saveUser(UserCategory userCategory);
    void deleteUser(String name);
    List<UserCategory> findUsers(String name);
}
