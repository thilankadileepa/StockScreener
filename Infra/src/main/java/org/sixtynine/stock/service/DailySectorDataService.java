package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.DailySectorData;


public interface DailySectorDataService {

	DailySectorData findById(int id);
	
	void saveDailySectorData(DailySectorData module);
	
	void deleteDailySectorData(int id);
	
	List<DailySectorData> findDailySectorData(int id);
}
