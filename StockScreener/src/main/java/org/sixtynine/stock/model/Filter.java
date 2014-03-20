package org.sixtynine.stock.model;

public class Filter {

	private int id;
	private String filterValues;

	private Module module;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilterValues() {
		return filterValues;
	}

	public void setFilterValues(String filterValues) {
		this.filterValues = filterValues;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}
