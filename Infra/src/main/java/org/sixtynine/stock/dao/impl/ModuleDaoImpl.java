package org.sixtynine.stock.dao.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.sixtynine.stock.dao.ModuleDao;
import org.sixtynine.stock.entity.Module;
import org.springframework.stereotype.Repository;

/**
 * @author Thilan
 *
 */

@Repository
public class ModuleDaoImpl extends AbstractDaoImpl<Module, Integer> implements ModuleDao {

	protected ModuleDaoImpl() {
		super(Module.class);
	}

	@Override
	public void saveModule(Module module) {
		saveOrUpdate(module);
	}

	@Override
	public List<Module> findModules(String name) {
		return findByCriteria(Restrictions.like("name", name, MatchMode.START));
	}

}
