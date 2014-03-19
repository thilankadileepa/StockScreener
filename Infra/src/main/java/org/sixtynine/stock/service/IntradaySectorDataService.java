package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.IntradaySectorData;
import org.sixtynine.stock.entity.Sector;

public interface IntradaySectorDataService {

	IntradaySectorData findById(int id);

	void saveIntradaySectorData(IntradaySectorData intradaySectorData);

	void deleteIntradaySectorData(int id);

	List<IntradaySectorData> findIntradaySectorData(Sector sector);
	
}
