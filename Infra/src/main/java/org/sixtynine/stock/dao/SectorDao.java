package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.Sector;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Thilan
 *
 */

@Transactional(readOnly = true)
public interface SectorDao extends AbstractDao<Sector, Integer> {

	void saveSector(Sector sector);

	List<Sector> findSectors(String sectorName);

}
