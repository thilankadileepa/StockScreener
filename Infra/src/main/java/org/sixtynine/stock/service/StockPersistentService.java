package org.sixtynine.stock.service;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.sixtynine.stock.entity.BaseEntity;

public interface StockPersistentService {

	public void saveOrUpdate(BaseEntity entity);

	public void delete(BaseEntity entity);

	public BaseEntity findById(int id, Class<? extends BaseEntity> clazz);

	public List<BaseEntity> findByCriteria(Criterion criterion,
			Class<? extends BaseEntity> clazz);

	public List<BaseEntity> findAll(Class<? extends BaseEntity> clazz);

}
