package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.sixtynine.stock.dao.DailyShareDataDao;
import org.sixtynine.stock.entity.DailyShareData;
import org.springframework.stereotype.Repository;

@Repository
public class DailyShareDataDaoImpl extends AbstractDaoImpl<DailyShareData , Integer> implements
		DailyShareDataDao {

	protected DailyShareDataDaoImpl() {
		super(DailyShareData.class);
	} 
	
	@Override
	public void saveDailyShareData(DailyShareData dailyShareData) {
		saveOrUpdate(dailyShareData);
	}

	@Override
	public List<DailyShareData> findDailyShareDatas(int companyId) {
		return findByCriteria(Restrictions.eq("companyId", companyId));
	}

}
