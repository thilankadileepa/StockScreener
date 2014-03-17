package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.QuarterlyShareDataDao;
import org.sixtynine.stock.entity.QuarterlyShareData;
import org.sixtynine.stock.service.QuarterlyShareDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuarterlyShareDataServiceImpl implements QuarterlyShareDataService {

	@Autowired
	private QuarterlyShareDataDao quarterlyShareDataDao;
	
	@Override
	public QuarterlyShareData findById(int id) {
		return quarterlyShareDataDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveQuarterlyShareData(QuarterlyShareData quarterlyShareData) {
		quarterlyShareDataDao.saveQuarterlyShareData(quarterlyShareData);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteQuarterlyShareData(int id) {
		QuarterlyShareData quarterlyShareData = quarterlyShareDataDao.findById(id);
		if (quarterlyShareData != null) {
			quarterlyShareDataDao.delete(quarterlyShareData);
		}
	}

	@Override
	public List<QuarterlyShareData> findQuarterlyShareData(int companyId) {
		return quarterlyShareDataDao.findQuarterlyShareData(companyId);
	}

}
