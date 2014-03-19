package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.IntradaySectorDataDao;
import org.sixtynine.stock.entity.IntradaySectorData;
import org.sixtynine.stock.entity.Sector;
import org.sixtynine.stock.service.IntradaySectorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IntradaySectorDataServiceImpl implements IntradaySectorDataService {

	@Autowired
	private IntradaySectorDataDao intradaySectorDataDao;
	
	@Override
	public IntradaySectorData findById(int id) {
		return intradaySectorDataDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveIntradaySectorData(IntradaySectorData intradaySectorData) {
		intradaySectorDataDao.saveIntradaySectorData(intradaySectorData);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteIntradaySectorData(int id) {
		IntradaySectorData intradaySectorData = intradaySectorDataDao.findById(id);
		if (intradaySectorData != null) {
			intradaySectorDataDao.delete(intradaySectorData);
		}
	}

	@Override
	@Transactional(readOnly = false)
	public List<IntradaySectorData> findIntradaySectorData(Sector sector) {
		return intradaySectorDataDao.findIntradaySectorData(sector.getId());
	}

}
