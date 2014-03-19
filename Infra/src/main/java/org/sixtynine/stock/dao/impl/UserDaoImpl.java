package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.sixtynine.stock.dao.UserDao;
import org.sixtynine.stock.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User , Integer> implements UserDao {

	protected UserDaoImpl() {
		super(User.class);
	}

	@Override
	public void saveUser(User user) {
		saveOrUpdate(user);
	}

	@Override
	public List<User> findUser(String name) {
		return findByCriteria(Restrictions.like("name", name, MatchMode.START));
	}

}
