package org.sixtynine.stock.service;

import java.util.List;

import org.sixtynine.stock.entity.Module;

/**
 * @author Thilan
 *
 */

public interface ModuleService {

	Module findById(int id);
	
	void saveModule(Module module);
	
	void deleteModule(int id);
	
	List<Module> findModules(String name);
	
}
