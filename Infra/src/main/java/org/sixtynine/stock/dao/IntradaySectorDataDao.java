package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.IntradaySectorData;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface IntradaySectorDataDao extends AbstractDao<IntradaySectorData, Integer> {

	void saveIntradaySectorData(IntradaySectorData intradaySectorData);
	List<IntradaySectorData> findIntradaySectorData(int sectorId);
	
}
