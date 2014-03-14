package org.sixtynine.stock.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DAILY_SECTOR_DATA")
public class DailySectorData {

	private int id;
	private int sectorId;
	private Date date;
	private double closingValue;
	private double noOfTrades;
	private double volume;
	private double turnOver;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "SECTOR_ID", nullable = false, length = 10)
	public int getSectorId() {
		return sectorId;
	}

	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}

	@Column(name = "DATE", nullable = false, length = 30)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "CLOSING_VALUE", nullable = false)
	public double getClosingValue() {
		return closingValue;
	}

	public void setClosingValue(double closingValue) {
		this.closingValue = closingValue;
	}

	@Column(name = "NUMBER_OF_TRADES", nullable = false)
	public double getNoOfTrades() {
		return noOfTrades;
	}

	public void setNoOfTrades(double noOfTrades) {
		this.noOfTrades = noOfTrades;
	}

	@Column(name = "VOLUME", nullable = false)
	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Column(name = "TURNOVER", nullable = false)
	public double getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(double turnOver) {
		this.turnOver = turnOver;
	}

}
