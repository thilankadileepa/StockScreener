package org.sixtynine.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ANNUAL_SHARE_DATA")
public class AnnualShareData {

	private int id;
	private int year;
	private double netProfit;
	private double numberOfShares;
	private double revenues;
	private double ebitda;
	private double dividents;
	private Company company;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(name = "YEAR", unique = true, nullable = false)
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Column(name = "NET_PROFIT", unique = true, nullable = false)
	public double getNetProfit() {
		return netProfit;
	}

	public void setNetProfit(double netProfit) {
		this.netProfit = netProfit;
	}

	@Column(name = "NUMBER_OF_SHARES", unique = true, nullable = false)
	public double getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(double numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	@Column(name = "REVENUES", unique = true, nullable = false)
	public double getRevenues() {
		return revenues;
	}

	public void setRevenues(double revenues) {
		this.revenues = revenues;
	}

	@Column(name = "EBITDA", unique = true, nullable = false)
	public double getEbitda() {
		return ebitda;
	}

	public void setEbitda(double ebitda) {
		this.ebitda = ebitda;
	}

	@Column(name = "DIVIDENTS", unique = true, nullable = false)
	public double getDividents() {
		return dividents;
	}

	public void setDividents(double dividents) {
		this.dividents = dividents;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (id==((AnnualShareData)obj).getId());
	}

	@ManyToOne  
	@JoinColumn(name = "COMPANY_ID")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	

}
