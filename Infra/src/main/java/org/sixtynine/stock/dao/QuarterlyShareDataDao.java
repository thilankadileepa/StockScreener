package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.QuarterlyShareData;

public interface QuarterlyShareDataDao extends
		AbstractDao<QuarterlyShareData, Integer> {

	void saveQuarterlyShareData(QuarterlyShareData quarterlyShareData);

	List<QuarterlyShareData> findQuarterlyShareData(int companyId);
	
}
