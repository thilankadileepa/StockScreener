package org.sixtynine.stock.model;

import java.util.Date;

public class IntradaySectorData {

	private int id;
	private Date time;
	private double value;
	private double valueChange;
	private double percentageChange;
	private int sequence;

	private Sector sector;

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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
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

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

}
