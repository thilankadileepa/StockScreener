package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.DailyShareData;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface DailyShareDataDao extends AbstractDao<DailyShareData, Integer> {

	void saveDailyShareData(DailyShareData dailyShareData);

	List<DailyShareData> findDailyShareDatas(int companyId);
	
}
