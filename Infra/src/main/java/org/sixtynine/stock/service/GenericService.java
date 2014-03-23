package org.sixtynine.stock.service;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.sixtynine.stock.entity.BaseEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * generic operations
 * 
 * @author Thilanka
 * 
 */
@Transactional
public interface GenericService {
	public void saveOrUpdate(BaseEntity entity);
	
	public void delete(BaseEntity entity);
	
	public void delete(int id,Class clazz);

	public BaseEntity findById(int id, Class<? extends BaseEntity> clazz);
	
	public List<BaseEntity> findByCriteria(Criterion criterion, Class<? extends BaseEntity> clazz);
	
	public List<BaseEntity> findAll(Class<? extends BaseEntity> clazz);
}
