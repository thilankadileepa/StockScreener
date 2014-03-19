package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.sixtynine.stock.dao.CompanyDao;
import org.sixtynine.stock.entity.Company;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDaoImpl extends AbstractDaoImpl<Company , Integer> implements CompanyDao {

	protected CompanyDaoImpl() {
		super(Company.class);
	}

	@Override
	public void saveCompany(Company company) {
		saveOrUpdate(company);
	}

	@Override
	public List<Company> findCompanyies(String companyName) {
		return findByCriteria(Restrictions.like("name", companyName, MatchMode.START));
	}

}
