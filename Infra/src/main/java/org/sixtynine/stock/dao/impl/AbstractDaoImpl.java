package org.sixtynine.stock.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.sixtynine.stock.dao.AbstractDao;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDaoImpl<E, I extends Serializable> implements
		AbstractDao<E, I> {

	private Class<E> entityClass;

	protected AbstractDaoImpl(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public E findById(I id) {
		return (E) getCurrentSession().get(entityClass, id);
	}

	@Override
	public E findById(I id, Class<E> clazz) {
		return (E) getCurrentSession().get(clazz, id);
	}

	@Override
	public void saveOrUpdate(E e) {
		getCurrentSession().saveOrUpdate(e);
	}

	@Override
	public void delete(E e) {
		getCurrentSession().delete(e);
	}

	@Override
	public List<E> findByCriteria(Criterion criterion) {
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		criteria.add(criterion);
		return criteria.list();
	}

	@Override
	public List<E> findByCriteria(Criterion criterion, Class<E> clazz) {
		Criteria criteria = getCurrentSession().createCriteria(clazz);
		criteria.add(criterion);
		return criteria.list();
	}

	@Override
	public List<E> findByCriteria(Class<E> clazz, Criterion... criterion) {
		Criteria criteria = getCurrentSession().createCriteria(clazz);
		for (Criterion c : criterion) {
			criteria.add(c);
		}

		return criteria.list();
	}

	@Override
	public List<E> findAll(Class<E> clazz) {
		return findByCriteria(clazz);
	}
}
