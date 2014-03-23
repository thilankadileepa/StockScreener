package org.sixtynine.stock.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.sixtynine.stock.entity.BaseEntity;
import org.sixtynine.stock.service.GenericService;
import org.sixtynine.stock.service.StockPersistentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * main interface for persistent layer operations
 * 
 * @author Thilanka
 *
 */
public class StockPersistentServiceImpl implements StockPersistentService {

	@Autowired
	@Qualifier("genericService")
	private GenericService genericService;

	@Override
	public void saveOrUpdate(BaseEntity entity) {
		genericService.saveOrUpdate(entity);
	}

	@Override
	public void delete(BaseEntity entity) {
		genericService.delete(entity);
	}

	@Override
	public BaseEntity findById(int id, Class<? extends BaseEntity> clazz) {
		return genericService.findById(id, clazz);
	}

	@Override
	public List<BaseEntity> findByCriteria(Criterion criterion,
			Class<? extends BaseEntity> clazz) {
		return genericService.findByCriteria(criterion, clazz);
	}

	@Override
	public List<BaseEntity> findAll(Class<? extends BaseEntity> clazz) {
		return genericService.findAll(clazz);
	}	
	
}
