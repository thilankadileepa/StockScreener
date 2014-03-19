package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.IntradayShareData;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface IntradayShareDataDao extends
		AbstractDao<IntradayShareData, Integer> {
	
	void saveIntradayShareData(IntradayShareData intradayShareData);

	List<IntradayShareData> findIntradayShareData(int company);

}
