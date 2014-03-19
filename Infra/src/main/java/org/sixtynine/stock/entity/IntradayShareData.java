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
@Table(name = "INTRADAY_SHARE_DATA")
public class IntradayShareData {

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
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "TIME", nullable = false, length = 100)
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "TRADE_VOLUME", nullable = false, length = 100)
	public double getTradeVolume() {
		return tradeVolume;
	}

	public void setTradeVolume(double tradeVolume) {
		this.tradeVolume = tradeVolume;
	}

	@Column(name = "SHARE_VOLUME", nullable = false, length = 100)
	public double getShareVolume() {
		return shareVolume;
	}

	public void setShareVolume(double shareVolume) {
		this.shareVolume = shareVolume;
	}

	@Column(name = "TURNOVER", nullable = false, length = 100)
	public double getTurnover() {
		return turnover;
	}

	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}

	@Column(name = "LAST_TRADED_PRICE", nullable = false, length = 100)
	public double getLastTradedPrice() {
		return lastTradedPrice;
	}

	public void setLastTradedPrice(double lastTradedPrice) {
		this.lastTradedPrice = lastTradedPrice;
	}

	@Column(name = "CLOSING_PRICE", nullable = false, length = 100)
	public double getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(double closingPrice) {
		this.closingPrice = closingPrice;
	}

	@Column(name = "VALUE_CHANGE", nullable = false, length = 100)
	public double getValueChange() {
		return valueChange;
	}

	public void setValueChange(double valueChange) {
		this.valueChange = valueChange;
	}

	@Column(name = "PERCENTAGE_CHANGE", nullable = false, length = 100)
	public double getPercentageChange() {
		return percentageChange;
	}

	public void setPercentageChange(double percentageChange) {
		this.percentageChange = percentageChange;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (id==((IntradayShareData)obj).getId());
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
