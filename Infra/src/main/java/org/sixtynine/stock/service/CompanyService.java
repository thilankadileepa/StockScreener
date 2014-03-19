package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.Company;

public interface CompanyService {

	Company findById(int id);

	void saveCompany(Company company);

	void deleteCompany(int id);

	List<Company> findCompany(String name);
	
}
