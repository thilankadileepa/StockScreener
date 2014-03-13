package org.sixtynine.stock.dao;

import java.util.List;

import org.sixtynine.stock.entity.Module;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Thilan
 *
 */

@Transactional(readOnly = true)
public interface ModuleDao extends AbstractDao<Module ,Integer>{

	void saveModule(Module module);

	List<Module> findModules(String moduleName);
}
