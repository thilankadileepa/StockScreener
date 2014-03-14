package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.DailyShareDataDao;
import org.sixtynine.stock.entity.DailyShareData;
import org.sixtynine.stock.service.DailyShareDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyShareDataServiceImpl implements DailyShareDataService {

	@Autowired
	private DailyShareDataDao dailyShareDataDao;
	
	@Override
	public DailyShareData findById(int id) {
		return dailyShareDataDao.findById(id);
	}

	@Override
	public void saveDailyShareData(DailyShareData dailyShareData) {
		dailyShareDataDao.saveDailyShareData(dailyShareData);
	}

	@Override
	public void deleteDailyShareData(int id) {
		DailyShareData dailyShareData = dailyShareDataDao.findById(id);
		if (dailyShareData != null) {
			dailyShareDataDao.delete(dailyShareData);
		}
	}

	@Override
	public List<DailyShareData> findDailyShareData(int id) {
		return dailyShareDataDao.findDailyShareDatas(id);
	}

}
