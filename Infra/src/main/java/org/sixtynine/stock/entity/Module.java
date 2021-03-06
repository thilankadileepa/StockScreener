package org.sixtynine.stock.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Thilan
 *
 */

@Entity
@Table(name = "MODULE")
public class Module extends BaseEntity{
	
	private int id;
	
	@NotEmpty
	private String name;
	private Set<Filter> filter ;
	private Set<CategoryModule> categoryModule ;
	
	public Module() {
	}

	public Module(String name) {
		this.name = name;
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

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String userName) {
		this.name = userName;
	}

	@Override
	public boolean equals(Object obj) {
		return (id==((Module)obj).getId());
	}

	@OneToMany(mappedBy = "module")  
	public Set<Filter> getFilter() {
		return filter;
	}

	public void setFilter(Set<Filter> filter) {
		this.filter = filter;
	}

	@OneToMany(mappedBy = "module")  
	public Set<CategoryModule> getCategoryModule() {
		return categoryModule;
	}

	public void setCategoryModule(Set<CategoryModule> categoryModule) {
		this.categoryModule = categoryModule;
	}
	
	
	

}
