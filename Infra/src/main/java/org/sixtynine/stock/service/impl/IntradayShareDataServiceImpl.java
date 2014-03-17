package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.IntradayShareDataDao;
import org.sixtynine.stock.entity.IntradayShareData;
import org.sixtynine.stock.service.IntradayShareDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IntradayShareDataServiceImpl implements IntradayShareDataService {

	@Autowired
	private IntradayShareDataDao intradayShareDataDao;
	
	@Override
	public IntradayShareData findById(int id) {
		return intradayShareDataDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveIntradayShareData(IntradayShareData intradayShareData) {
		intradayShareDataDao.saveIntradayShareData(intradayShareData);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteIntradayShareData(int id) {
		IntradayShareData intradayShareData = intradayShareDataDao.findById(id);
		if (intradayShareData != null) {
			intradayShareDataDao.delete(intradayShareData);
		}
	}

	@Override
	public List<IntradayShareData> findIntradayShareData(int companyId) {
		return intradayShareDataDao.findIntradayShareData(companyId);
	}

}
