package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.DailyShareData;


public interface DailyShareDataService {

	DailyShareData findById(int id);
	
	void saveDailyShareData(DailyShareData dailyShareData);
	
	void deleteDailyShareData(int id);
	
	List<DailyShareData> findDailyShareData(int id);
}
