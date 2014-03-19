package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.sixtynine.stock.dao.SectorDao;
import org.sixtynine.stock.entity.Sector;
import org.springframework.stereotype.Repository;

/**
 * @author Thilan
 *
 */

@Repository
public class SectorDaoImpl extends AbstractDaoImpl<Sector, Integer> implements SectorDao{

	protected SectorDaoImpl() {
		super(Sector.class);
	}
	
	@Override
	public void saveSector(Sector sector) {
		saveOrUpdate(sector);
		
	}

	@Override
	public List<Sector> findSectors(String sectorName) {
		return findByCriteria(Restrictions.like("name", sectorName, MatchMode.START));
	}

	
	

}
