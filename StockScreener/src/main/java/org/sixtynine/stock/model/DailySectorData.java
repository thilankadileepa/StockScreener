package org.sixtynine.stock.model;

import java.util.Date;

public class DailySectorData {

	private int id;
	private Date date;
	private double closingValue;
	private double noOfTrades;
	private double volume;
	private double turnOver;
	private Sector sector;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getClosingValue() {
		return closingValue;
	}

	public void setClosingValue(double closingValue) {
		this.closingValue = closingValue;
	}

	public double getNoOfTrades() {
		return noOfTrades;
	}

	public void setNoOfTrades(double noOfTrades) {
		this.noOfTrades = noOfTrades;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(double turnOver) {
		this.turnOver = turnOver;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

}
