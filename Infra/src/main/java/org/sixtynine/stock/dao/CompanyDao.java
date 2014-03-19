package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.Company;

public interface CompanyDao extends AbstractDao<Company, Integer> {

	void saveCompany(Company company);

	List<Company> findCompanyies(String companyName);
}
