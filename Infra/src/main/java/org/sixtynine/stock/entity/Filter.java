package org.sixtynine.stock.entity;

/**
 * @author Thilan
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "FILTER")
public class Filter extends BaseEntity{

	private int id;
	private String filterValues;
	
	private Module module;
	private FilterCategory filterCategory;
	

	public Filter(){}
	
	public Filter(String value){
		this.filterValues = value;
	}
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "FILTER_VALUES", nullable = false, length = 100)
	public String getFilterValues() {
		return filterValues;
	}

	public void setFilterValues(String filterValues) {
		this.filterValues = filterValues;
	}

	@ManyToOne 
	@JoinColumn(name = "MODULE_ID")
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (id==((Filter)obj).getId());
	}

	@ManyToOne 
	@JoinColumn(name = "FILTER_CATEGORY_ID")
	public FilterCategory getFilterCategory() {
		return filterCategory;
	}

	
	public void setFilterCategory(FilterCategory filterCategory) {
		this.filterCategory = filterCategory;
	}
	
	

}
