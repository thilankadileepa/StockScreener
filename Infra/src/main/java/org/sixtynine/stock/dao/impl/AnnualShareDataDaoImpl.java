package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.sixtynine.stock.dao.AnnualShareDataDao;
import org.sixtynine.stock.entity.AnnualShareData;
import org.springframework.stereotype.Repository;

@Repository
public class AnnualShareDataDaoImpl extends
		AbstractDaoImpl<AnnualShareData, Integer> implements AnnualShareDataDao {

	protected AnnualShareDataDaoImpl() {
		super(AnnualShareData.class);
	}
	
	@Override
	public void saveAnnualShareData(AnnualShareData annualShareData) {
		saveOrUpdate(annualShareData);
	}

	@Override
	public List<AnnualShareData> findAnnualShareData(int companyId) {
		return findByCriteria(Restrictions.eq("companyId", companyId));
	}

}
