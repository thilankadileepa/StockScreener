package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.sixtynine.stock.dao.QuarterlyShareDataDao;
import org.sixtynine.stock.entity.QuarterlyShareData;

public class QuarterlyShareDataDaoImpl extends AbstractDaoImpl<QuarterlyShareData , Integer> implements
		QuarterlyShareDataDao {

	protected QuarterlyShareDataDaoImpl() {
		super(QuarterlyShareData.class);
	}
	

	@Override
	public void saveQuarterlyShareData(QuarterlyShareData quarterlyShareData) {
		saveOrUpdate(quarterlyShareData);
	}

	@Override
	public List<QuarterlyShareData> findQuarterlyShareData(int companyId) {
		return findByCriteria(Restrictions.eq("companyId", companyId));
	}

}
