package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.QuarterlyShareData;

public interface QuarterlyShareDataService {

	QuarterlyShareData findById(int id);

	void saveQuarterlyShareData(QuarterlyShareData quarterlyShareData);

	void deleteQuarterlyShareData(int id);

	List<QuarterlyShareData> findQuarterlyShareData(int companyId);
	
}
