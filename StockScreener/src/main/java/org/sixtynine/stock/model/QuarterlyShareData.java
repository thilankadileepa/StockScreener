package org.sixtynine.stock.model;

public class QuarterlyShareData {

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuarterCode() {
		return quarterCode;
	}

	public void setQuarterCode(String quarterCode) {
		this.quarterCode = quarterCode;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public double getWeightedAverage() {
		return weightedAverage;
	}

	public void setWeightedAverage(double weightedAverage) {
		this.weightedAverage = weightedAverage;
	}

	public double getAverageEquity() {
		return averageEquity;
	}

	public void setAverageEquity(double averageEquity) {
		this.averageEquity = averageEquity;
	}

	public double getAverageTotalAsse() {
		return averageTotalAsse;
	}

	public void setAverageTotalAsse(double averageTotalAsse) {
		this.averageTotalAsse = averageTotalAsse;
	}

	public double getProfitAfterTax() {
		return profitAfterTax;
	}

	public void setProfitAfterTax(double profitAfterTax) {
		this.profitAfterTax = profitAfterTax;
	}

	public double getRevenues() {
		return revenues;
	}

	public void setRevenues(double revenues) {
		this.revenues = revenues;
	}

	public double getEbitda() {
		return ebitda;
	}

	public void setEbitda(double ebitda) {
		this.ebitda = ebitda;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public double getPercentOwnbyInsiders() {
		return percentOwnbyInsiders;
	}

	public void setPercentOwnbyInsiders(double percentOwnbyInsiders) {
		this.percentOwnbyInsiders = percentOwnbyInsiders;
	}

	public double getInstOwnership() {
		return instOwnership;
	}

	public void setInstOwnership(double instOwnership) {
		this.instOwnership = instOwnership;
	}

	public double getSharesInFreefloat() {
		return sharesInFreefloat;
	}

	public void setSharesInFreefloat(double sharesInFreefloat) {
		this.sharesInFreefloat = sharesInFreefloat;
	}

	public double getDebt() {
		return debt;
	}

	public void setDebt(double debt) {
		this.debt = debt;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
