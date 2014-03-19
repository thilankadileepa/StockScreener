package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.AnnualShareData;

public interface AnnualShareDataDao extends
		AbstractDao<AnnualShareData, Integer> {
	
	void saveAnnualShareData(AnnualShareData annualShareData);
	List<AnnualShareData> findAnnualShareData(int companyId);

}
