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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "COMPANY")
public class Company extends BaseEntity{

	private int id;
	
	@Size(min=3) 
	private String code;
	
	@NotEmpty
	private String name;
	private Sector sector;
	
	private Set<AnnualShareData> annualShareData;
	private Set<IntradayShareData> intradayShareData;
	private Set<QuarterlyShareData> quarterlyShareData;
	private Set<DailyShareData> dailyShareData;
	
	private char largeCap;
	private char asi;
	private char snp;

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
		return (id == ((Company) obj).getId());
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

	@OneToMany(mappedBy = "company")
	public Set<DailyShareData> getDailyShareData() {
		return dailyShareData;
	}

	public void setDailyShareData(Set<DailyShareData> dailyShareData) {
		this.dailyShareData = dailyShareData;
	}

	@Column(name = "LARGE_CAP_COMPANY", nullable = false, length = 1)
	public char getLargeCap() {
		return largeCap;
	}

	public void setLargeCap(char largeCap) {
		this.largeCap = largeCap;
	}

	@Column(name = "ASI", nullable = false, length = 1)
	public char getAsi() {
		return asi;
	}

	public void setAsi(char asi) {
		this.asi = asi;
	}

	
	@Column(name = "SANDPP", nullable = false, length = 1)
	public char getSnp() {
		return snp;
	}

	public void setSnp(char snp) {
		this.snp = snp;
	}
	
	

}
