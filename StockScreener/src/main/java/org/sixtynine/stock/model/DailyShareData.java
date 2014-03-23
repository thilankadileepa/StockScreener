package org.sixtynine.stock.model;

import java.util.Date;

public class DailyShareData {

	private int id;
	private int companyId;
	private Date date;
	private double sharePrice;
	private double high;
	private double low;
	private double turnOver;
	private double volume;
	private double noOfTrade;
	private double openingPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(double turnOver) {
		this.turnOver = turnOver;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getNoOfTrade() {
		return noOfTrade;
	}

	public void setNoOfTrade(double noOfTrade) {
		this.noOfTrade = noOfTrade;
	}

	public double getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(double openingPrice) {
		this.openingPrice = openingPrice;
	}

}
