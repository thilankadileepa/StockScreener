package org.sixtynine.stock.service.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sixtynine.stock.Constants.CommonData;
import org.sixtynine.stock.entity.BaseEntity;
import org.sixtynine.stock.entity.Company;
import org.sixtynine.stock.service.GenericService;
import org.sixtynine.stock.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Thilanka
 *
 */
public class DataManagerService implements ManagerService {

	@Autowired
	private GenericService genericService;

	public static Map<String, List<BaseEntity>> dataMap = new HashMap<String, List<BaseEntity>>();
	public static Map<String, HashMap<Object, BaseEntity>> mapById = new HashMap<String, HashMap<Object, BaseEntity>>();

	@Override
	public void init() {
		List<BaseEntity> companyList = genericService.findAll(Company.class);
		if (companyList != null && companyList.size() > 0) {
			mapData(CommonData.COMPANY.toString(), companyList);
		}
	}

	private static void rearrange(String code, List<BaseEntity> data) {
		HashMap<Object, BaseEntity> idMap = null;
		if (mapById.containsKey(code)) {
			idMap = mapById.get(code);
		}
		if (data != null) {
			if (idMap == null) {
				idMap = new HashMap<Object, BaseEntity>();
			}
			for (BaseEntity bean : data) {
				// idMap.put( bean.get, bean );
			}

			mapById.put(code, idMap);
		}
	}

	private static void mapData(String code, List<BaseEntity> data) {
		dataMap.put(code, data);
		rearrange(code, data);
	}

	public static List<BaseEntity> getData(String param) {
		if (dataMap.containsKey(param)) {
			return dataMap.get(param);
		}
		return null;
	}

	public static BaseEntity getData(String param, int id) {
		if (mapById.containsKey(param)) {
			HashMap<Object, BaseEntity> idMap = mapById.get(param);
			if (idMap.containsKey(id)) {
				return idMap.get(id);
			}
		}
		return null;
	}

}
