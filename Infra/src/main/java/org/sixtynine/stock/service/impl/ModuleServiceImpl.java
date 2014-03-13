package org.sixtynine.stock.service.impl;

import java.util.List;

import org.sixtynine.stock.dao.ModuleDao;
import org.sixtynine.stock.entity.Module;
import org.sixtynine.stock.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Thilan
 *
 */

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleDao moduleDao;
	
	@Override
	public Module findById(int id) {
		return moduleDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveModule(Module module) {
		moduleDao.saveModule(module);
		
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteModule(int id) {
		Module module = moduleDao.findById(id);
		if (module != null) {
			moduleDao.delete(module);
		}
	}

	@Override
	public List<Module> findModules(String module) {
		return moduleDao.findModules(module);
	}

}
