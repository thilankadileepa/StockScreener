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
@Table(name = "USER_CATEGORY")
public class UserCategory {

	private int id;
	private String name;
	private Set<User> user ;
	private Set<CategoryModule> categoryModule ;

	public UserCategory() {
	}

	public UserCategory(String name) {
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
		return (id==((UserCategory)obj).getId());
	}

	@OneToMany(mappedBy = "userCategory")  
	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	@OneToMany(mappedBy = "userCategory")  
	public Set<CategoryModule> getCategoryModule() {
		return categoryModule;
	}

	public void setCategoryModule(Set<CategoryModule> categoryModule) {
		this.categoryModule = categoryModule;
	}
	
	
	
}
