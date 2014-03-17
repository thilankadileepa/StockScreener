package org.sixtynine.stock.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company {

	private int id;
	private String code;
	private String name;
	private Sector sector;
	private Set<AnnualShareData> annualShareData;
	private Set<IntradayShareData> intradayShareData ;
	private Set<QuarterlyShareData> quarterlyShareData ;
	
	public Company() {
	}

	public Company(String name) {
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
	
	@Column(name = "NAME", nullable = false, length = 30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne  
	@JoinColumn(name = "SECTOR_ID")
	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (id==((Company)obj).getId());
	}

	@OneToMany(mappedBy = "company")   
	public Set<AnnualShareData> getAnnualShareData() {
		return annualShareData;
	}

	public void setAnnualShareData(Set<AnnualShareData> annualShareData) {
		this.annualShareData = annualShareData;
	}

	@OneToMany(mappedBy = "company")   
	public Set<IntradayShareData> getIntradayShareData() {
		return intradayShareData;
	}

	public void setIntradayShareData(Set<IntradayShareData> intradayShareData) {
		this.intradayShareData = intradayShareData;
	}

	@OneToMany(mappedBy = "company")  
	public Set<QuarterlyShareData> getQuarterlyShareData() {
		return quarterlyShareData;
	}

	public void setQuarterlyShareData(Set<QuarterlyShareData> quarterlyShareData) {
		this.quarterlyShareData = quarterlyShareData;
	}
	
	

	
}
