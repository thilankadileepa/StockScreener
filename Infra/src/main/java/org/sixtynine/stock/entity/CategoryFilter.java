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
@Table(name = "CATEGORY_FILTER")
public class CategoryFilter extends BaseEntity{

	private int id;
	private Filter filter;
	private UserCategory userCategory;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne 
	@JoinColumn(name = "FILTER_ID")
	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	@ManyToOne 
	@JoinColumn(name = "CATEGORY_ID")
	public UserCategory getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(UserCategory userCategory) {
		this.userCategory = userCategory;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (id==((CategoryFilter)obj).getId());
	}

}
