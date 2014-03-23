package org.sixtynine.stock.model;

import java.util.Date;

public class IntraDayShareData {

	private int id;
	private Date time;
	private double tradeVolume;
	private double shareVolume;
	private double turnover;
	private double lastTradedPrice;
	private double closingPrice;
	private double valueChange;
	private double percentageChange;
	private Company company;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getTradeVolume() {
		return tradeVolume;
	}

	public void setTradeVolume(double tradeVolume) {
		this.tradeVolume = tradeVolume;
	}

	public double getShareVolume() {
		return shareVolume;
	}

	public void setShareVolume(double shareVolume) {
		this.shareVolume = shareVolume;
	}

	public double getTurnover() {
		return turnover;
	}

	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}

	public double getLastTradedPrice() {
		return lastTradedPrice;
	}

	public void setLastTradedPrice(double lastTradedPrice) {
		this.lastTradedPrice = lastTradedPrice;
	}

	public double getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(double closingPrice) {
		this.closingPrice = closingPrice;
	}

	public double getValueChange() {
		return valueChange;
	}

	public void setValueChange(double valueChange) {
		this.valueChange = valueChange;
	}

	public double getPercentageChange() {
		return percentageChange;
	}

	public void setPercentageChange(double percentageChange) {
		this.percentageChange = percentageChange;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
