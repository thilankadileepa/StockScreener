package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.Sector;

/**
 * @author Thilan
 *
 */

public interface SectorService {

	Sector findById(int id);
	
	void saveSector(Sector sector);
	
	void deleteSector(int id);
	
	List<Sector> findSector(String name);
}
