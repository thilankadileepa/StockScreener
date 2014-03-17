package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.AnnualShareData;

public interface AnnualShareDataService {

	AnnualShareData findById(int id);

	void saveAnnualShareData(AnnualShareData annualShareData);

	void deleteAnnualShareData(int id);

	List<AnnualShareData> findAnnualShareData(int companyId);
	
}
