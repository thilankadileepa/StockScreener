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
@Table(name = "INTRADAY_SECTOR_DATA")
public class IntradaySectorData extends BaseEntity{

	private int id;
	
	
	private Date time;
	private double value;
	private double valueChange;
	private double percentageChange;
	private int sequence;
	
	private Sector sector;

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

	@Column(name = "VALUE", nullable = false, length = 100)
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
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

	@Column(name = "SEQUENCE", nullable = false, length = 100)
	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (id==((IntradaySectorData)obj).getId());
	}

	@ManyToOne  
	@JoinColumn(name = "SECTOR_ID")
	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	

}
