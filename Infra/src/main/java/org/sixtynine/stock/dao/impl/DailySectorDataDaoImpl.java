package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.sixtynine.stock.dao.DailySectorDataDao;
import org.sixtynine.stock.entity.DailySectorData;
import org.sixtynine.stock.entity.Module;
import org.springframework.stereotype.Repository;

@Repository
public class DailySectorDataDaoImpl extends AbstractDaoImpl<DailySectorData, Integer> implements
		DailySectorDataDao {

	protected DailySectorDataDaoImpl() {
		super(DailySectorData.class);
	}
	
	@Override
	public void saveDailySectorData(DailySectorData dailySectorData) {
		saveOrUpdate(dailySectorData);
	}

	@Override
	public List<DailySectorData> findDailySectorDatas(int sectorid) {
		return findByCriteria(Restrictions.eq("sectorId", sectorid));
	}

}
