package org.sixtynine.stock.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FILTER_CATEGORY")
public class FilterCategory {

	private int id;
	private String filterType;

	private Set<Filter> filter;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "FILTER_TYPE", nullable = false, length = 200)
	public String getFilterType() {
		return filterType;
	}

	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

	@Override
	public boolean equals(Object obj) {
		return (id == ((FilterCategory) obj).getId());
	}

	@OneToMany(mappedBy = "filterCategory")  
	public Set<Filter> getFilter() {
		return filter;
	}

	public void setFilter(Set<Filter> filter) {
		this.filter = filter;
	}

}
