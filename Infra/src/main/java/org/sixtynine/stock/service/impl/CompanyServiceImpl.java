package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.CompanyDao;
import org.sixtynine.stock.entity.Company;
import org.sixtynine.stock.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public Company findById(int id) {
		return companyDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveCompany(Company company) {
		companyDao.saveCompany(company);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteCompany(int id) {
		Company company = companyDao.findById(id);
		if (company != null) {
			companyDao.delete(company);
		}
	}

	@Override
	public List<Company> findCompany(String name) {
		return companyDao.findCompanyies(name);
	}

}
