package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.SectorDao;
import org.sixtynine.stock.entity.Sector;
import org.sixtynine.stock.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Thilan
 *
 */

@Service
public class SectorServiceImpl implements SectorService {

	@Autowired
	private SectorDao sectorDao;
	
	@Override
	public Sector findById(int id) {
		return sectorDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveSector(Sector sector) {
		sectorDao.saveSector(sector);

	}

	@Override
	@Transactional(readOnly = false)
	public void deleteSector(int id) {
		Sector sector = sectorDao.findById(id);
		if (sector != null) {
			sectorDao.delete(sector);
		}
	}

	@Override
	public List<Sector> findSector(String sectorName) {
		return sectorDao.findSectors(sectorName);
	}

}
