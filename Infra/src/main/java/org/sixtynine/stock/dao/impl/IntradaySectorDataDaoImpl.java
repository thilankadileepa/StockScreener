package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.sixtynine.stock.dao.IntradaySectorDataDao;
import org.sixtynine.stock.entity.IntradaySectorData;
import org.springframework.stereotype.Repository;

@Repository
public class IntradaySectorDataDaoImpl extends
		AbstractDaoImpl<IntradaySectorData, Integer> implements
		IntradaySectorDataDao {

	protected IntradaySectorDataDaoImpl() {
		super(IntradaySectorData.class);
	}
	

	@Override
	public void saveIntradaySectorData(IntradaySectorData intradaySectorData) {
		saveOrUpdate(intradaySectorData);
	}

	@Override
	public List<IntradaySectorData> findIntradaySectorData(int sectorId) {
		return findByCriteria(Restrictions.eq("sectorId", sectorId));
	}

}
