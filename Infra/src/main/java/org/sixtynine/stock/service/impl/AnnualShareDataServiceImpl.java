package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.AnnualShareDataDao;
import org.sixtynine.stock.entity.AnnualShareData;
import org.sixtynine.stock.service.AnnualShareDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnnualShareDataServiceImpl implements AnnualShareDataService {

	@Autowired
	private AnnualShareDataDao annualShareDataDao;
	
	@Override
	public AnnualShareData findById(int id) {
		return annualShareDataDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveAnnualShareData(AnnualShareData annualShareData) {
		annualShareDataDao.saveAnnualShareData(annualShareData);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteAnnualShareData(int id) {
		AnnualShareData annualShareData = annualShareDataDao.findById(id);
		if (annualShareData != null) {
			annualShareDataDao.delete(annualShareData);
		}
	}

	@Override
	public List<AnnualShareData> findAnnualShareData(int companyId) {
		return annualShareDataDao.findAnnualShareData(companyId);
	}

}
