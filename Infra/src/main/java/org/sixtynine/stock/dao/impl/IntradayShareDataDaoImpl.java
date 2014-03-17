package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.sixtynine.stock.dao.IntradayShareDataDao;
import org.sixtynine.stock.entity.IntradayShareData;
import org.springframework.stereotype.Repository;

@Repository
public class IntradayShareDataDaoImpl extends AbstractDaoImpl<IntradayShareData , Integer> implements
		IntradayShareDataDao {

	protected IntradayShareDataDaoImpl() {
		super(IntradayShareData.class);
	}

	@Override
	public void saveIntradayShareData(IntradayShareData intradayShareData) {
		saveOrUpdate(intradayShareData);
	}

	@Override
	public List<IntradayShareData> findIntradayShareData(int company) {
		return findByCriteria(Restrictions.eq("companyId", company));
	}

}
