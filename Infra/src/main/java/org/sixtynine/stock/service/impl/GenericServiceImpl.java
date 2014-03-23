package org.sixtynine.stock.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.sixtynine.stock.dao.GenericDao;
import org.sixtynine.stock.entity.BaseEntity;
import org.sixtynine.stock.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Thilanka
 * 
 */
@Service
public class GenericServiceImpl implements GenericService {

	@Autowired
	GenericDao genericDao;

	@Override
	public void saveOrUpdate(BaseEntity entity) {
		genericDao.saveOrUpdate(entity);
	}

	@Override
	public void delete(BaseEntity entity) {
		genericDao.delete(entity);
	}
	
	@Override
	public void delete(int id,Class clazz) {
		genericDao.delete(findById(id, clazz));
	}

	@Override
	public BaseEntity findById(int id, Class clazz) {
		return genericDao.findById(id, clazz);
	}

	@Override
	public List<BaseEntity> findByCriteria(Criterion criterion, Class clazz) {
		return genericDao.findByCriteria(criterion, clazz);
	}

	@Override
	public List<BaseEntity> findAll(Class clazz) {
		return genericDao.findAll(clazz);
	}
}
