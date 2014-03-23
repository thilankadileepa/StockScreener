package org.sixtynine.stock.dao;

import org.sixtynine.stock.entity.BaseEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface GenericDao extends AbstractDao<BaseEntity, Integer> {

}
