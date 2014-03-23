package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.sixtynine.stock.dao.GenericDao;
import org.sixtynine.stock.entity.BaseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Thilanka
 * 
 */
@Repository
public class GenericDaoImpl extends AbstractDaoImpl<BaseEntity, Integer>
		implements GenericDao {

	protected GenericDaoImpl() {
		super(BaseEntity.class);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveOrUpdate(BaseEntity e) {
		super.saveOrUpdate(e);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(BaseEntity e) {
		super.delete(e);
	}
	
	@Override
	public BaseEntity findById(Integer id, Class<BaseEntity> clazz) {
		return super.findById(id, clazz);
	}

	@Override
	public List<BaseEntity> findByCriteria(Criterion criterion,
			Class<BaseEntity> clazz) {
		return findByCriteria(criterion, clazz);
	}

	
}
