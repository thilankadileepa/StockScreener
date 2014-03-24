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
@Table(name = "QUARTERLY_SHARE_DATA")
public class QuarterlyShareData extends BaseEntity{

	private int id;
	private String quarterCode;
	private double profit;
	private double weightedAverage;
	private double averageEquity;
	private double averageTotalAsse;
	private double profitAfterTax;
	private double revenues;
	private double ebitda;
	private double cash;
	private double percentOwnbyInsiders;
	private double instOwnership;
	private double sharesInFreefloat;
	private double debt;
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

	@Column(name = "QUARTER_CODE", nullable = false, length = 100)
	public String getQuarterCode() {
		return quarterCode;
	}

	public void setQuarterCode(String quarterCode) {
		this.quarterCode = quarterCode;
	}

	@Column(name = "PROFIT", nullable = false, length = 100)
	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	@Column(name = "WEIGHTED_AVERAGE", nullable = false, length = 100)
	public double getWeightedAverage() {
		return weightedAverage;
	}

	public void setWeightedAverage(double weightedAverage) {
		this.weightedAverage = weightedAverage;
	}

	@Column(name = "AVERAGE_EQUITY", nullable = false, length = 100)
	public double getAverageEquity() {
		return averageEquity;
	}

	public void setAverageEquity(double averageEquity) {
		this.averageEquity = averageEquity;
	}

	@Column(name = "AVERAGE_TOTAL_ASSERTS", nullable = false, length = 100)
	public double getAverageTotalAsse() {
		return averageTotalAsse;
	}

	public void setAverageTotalAsse(double averageTotalAsse) {
		this.averageTotalAsse = averageTotalAsse;
	}

	@Column(name = "PROFIT_AFTER_TAX", nullable = false, length = 100)
	public double getProfitAfterTax() {
		return profitAfterTax;
	}

	public void setProfitAfterTax(double profitAfterTax) {
		this.profitAfterTax = profitAfterTax;
	}

	@Column(name = "REVENUES", nullable = false, length = 100)
	public double getRevenues() {
		return revenues;
	}

	public void setRevenues(double revenues) {
		this.revenues = revenues;
	}

	@Column(name = "EBITDA", nullable = false, length = 100)
	public double getEbitda() {
		return ebitda;
	}

	public void setEbitda(double ebitda) {
		this.ebitda = ebitda;
	}

	@Column(name = "CASH", nullable = false, length = 100)
	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	@Column(name = "PERCENT_OWNBY_INSIDERS", nullable = false, length = 100)
	public double getPercentOwnbyInsiders() {
		return percentOwnbyInsiders;
	}

	public void setPercentOwnbyInsiders(double percentOwnbyInsiders) {
		this.percentOwnbyInsiders = percentOwnbyInsiders;
	}

	@Column(name = "INST_OWNERSHIP", nullable = false, length = 100)
	public double getInstOwnership() {
		return instOwnership;
	}

	public void setInstOwnership(double instOwnership) {
		this.instOwnership = instOwnership;
	}

	@Column(name = "SHARES_IN_FREEFLOAT", nullable = false, length = 100)
	public double getSharesInFreefloat() {
		return sharesInFreefloat;
	}

	public void setSharesInFreefloat(double sharesInFreefloat) {
		this.sharesInFreefloat = sharesInFreefloat;
	}

	@Column(name = "DEBT", nullable = false, length = 100)
	public double getDebt() {
		return debt;
	}

	public void setDebt(double debt) {
		this.debt = debt;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (id==((QuarterlyShareData)obj).getId());
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
