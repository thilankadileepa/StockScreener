package org.sixtynine.stock.entity;

/**
 * @author Thilan
 *
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DAILY_SHARE_DATA")
public class DailyShareData extends BaseEntity{

	private int id;
	private Date date;
	private double sharePrice;
	private double high;
	private double low;
	private double turnOver;
	private double volume;
	private double noOfTrade;
	private double openingPrice;
	
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
	
	@Column(name = "DATE", nullable = false, length = 30)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "SHARE_PRICE", nullable = false)
	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	@Column(name = "HIGH", nullable = false)
	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	@Column(name = "LOW", nullable = false)
	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	@Column(name = "TURNOVER", nullable = false)
	public double getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(double turnOver) {
		this.turnOver = turnOver;
	}

	@Column(name = "VOLUME", nullable = false)
	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Column(name = "NO_OF_TRADES", nullable = false)
	public double getNoOfTrade() {
		return noOfTrade;
	}

	public void setNoOfTrade(double noOfTrade) {
		this.noOfTrade = noOfTrade;
	}

	@Column(name = "OPENING_PRICE", nullable = false)
	public double getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(double openingPrice) {
		this.openingPrice = openingPrice;
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
