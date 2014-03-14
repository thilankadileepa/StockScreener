package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.DailySectorDataDao;
import org.sixtynine.stock.dao.ModuleDao;
import org.sixtynine.stock.entity.DailySectorData;
import org.sixtynine.stock.entity.Module;
import org.sixtynine.stock.service.DailySectorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DailySectorDataServiceImpl implements DailySectorDataService {

	@Autowired
	private DailySectorDataDao dailySectorDataDao;
	
	@Override
	public DailySectorData findById(int id) {
		return dailySectorDataDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveDailySectorData(DailySectorData dailySectorData) {
		dailySectorDataDao.saveDailySectorData(dailySectorData);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteDailySectorData(int id) {
		DailySectorData dailySectorData = dailySectorDataDao.findById(id);
		if (dailySectorData != null) {
			dailySectorDataDao.delete(dailySectorData);
		}
	}

	@Override
	public List<DailySectorData> findDailySectorData(int id) {
		return dailySectorDataDao.findDailySectorDatas(id);
	}

}
