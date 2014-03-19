package org.sixtynine.stock.entity;


/**
 * @author Thilan
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

@Entity
@Table(name = "SECTOR")
public class Sector {

	private int id;
	private String code;
	private String name;
	private Set<DailySectorData> dailySectorData;	
	private Set<Company> company;
	private Set<IntradaySectorData> intradaySectorData;
	
	
	public Sector() {
	}

	public Sector(String name) {
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
	
	@Column(name = "CODE", nullable = false, length = 30)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (id==((Sector)obj).getId());
	}

	@OneToMany(mappedBy = "sector")   
	public Set<DailySectorData> getDailySectorData() {
		return dailySectorData;
	}

	public void setDailySectorData(Set<DailySectorData> dailySectorData) {
		this.dailySectorData = dailySectorData;
	}

	@OneToMany(mappedBy = "sector")   
	public Set<Company> getCompany() {
		return company;
	}

	public void setCompany(Set<Company> company) {
		this.company = company;
	}

	@OneToMany(mappedBy = "sector")   
	public Set<IntradaySectorData> getIntradaySectorData() {
		return intradaySectorData;
	}

	public void setIntradaySectorData(Set<IntradaySectorData> intradaySectorData) {
		this.intradaySectorData = intradaySectorData;
	}
	
	
	
}
