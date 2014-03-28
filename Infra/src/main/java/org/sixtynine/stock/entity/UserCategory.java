package org.sixtynine.stock.entity;

/**
 * @author Thilan
 * this is user category 
 *
 */

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USER_CATEGORY")
public class UserCategory extends BaseEntity {

	private int id;
	
	@NotEmpty
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

	/*
	 * 
	 * one to many relation ship this is one side annotation.. this mapped with User class and there is userCategory variable
	 * 
	 * */	
	@OneToMany(mappedBy = "userCategory")  
	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	/*
	 * 
	 * one to many relation ship this is one side annotation.. this mapped with CategoryModule class and there is userCategory variable
	 * 
	 * */
	@OneToMany(mappedBy = "userCategory")  
	public Set<CategoryModule> getCategoryModule() {
		return categoryModule;
	}

	public void setCategoryModule(Set<CategoryModule> categoryModule) {
		this.categoryModule = categoryModule;
	}
	
	
	
}
