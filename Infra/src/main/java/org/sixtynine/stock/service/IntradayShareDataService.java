package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.IntradayShareData;

public interface IntradayShareDataService {

	IntradayShareData findById(int id);

	void saveUserCategory(IntradayShareData intradayShareData);

	void deleteIntradayShareData(int id);

	List<IntradayShareData> findIntradayShareData(int companyId);
	
}
