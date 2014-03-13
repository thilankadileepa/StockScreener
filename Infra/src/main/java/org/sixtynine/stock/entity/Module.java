package org.sixtynine.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Thilan
 *
 */

@Entity
@Table(name = "MODULE")
public class Module {
	
	private int id;
	private String name;
	
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
	
	
	

}
