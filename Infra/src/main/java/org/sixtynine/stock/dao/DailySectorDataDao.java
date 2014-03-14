package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.DailySectorData;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Thilan
 *
 */

@Transactional(readOnly = true)
public interface DailySectorDataDao extends AbstractDao<DailySectorData ,Integer> {

	void saveDailySectorData(DailySectorData dailySectorData);

	List<DailySectorData> findDailySectorDatas(int sectorid);
}
