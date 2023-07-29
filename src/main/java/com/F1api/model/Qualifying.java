package com.F1api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "qualifying")
public class Qualifying {
	@Id
	@Column(name = "qualifyid")
	private int id;
	@Column(name = "raceid")
	private int race_id;
	@OneToOne
	@JoinColumn(name = "driverid", referencedColumnName = "driverid")
	private Driver driver;
	@OneToOne
	@JoinColumn(name = "constructorid", referencedColumnName = "constructorid")
	private Constructor constructor;
	@Column(name = "number")
	private int number;
	@Column(name = "position")
	private int position;
	@Column(name = "q1")
	private String q1;
	@Column(name = "q2")
	private String q2;
	@Column(name = "q3")
	private String q3;
	
	public int getId() {
		return id;
	}
	public int getRaceId() {
		return race_id;
	}
	public Driver getDriver() {
		return driver;
	}
	public Constructor getConstructor() {
		return constructor;
	}
	public int getNumber() {
		return number;
	}
	public int getPosition() {
		return position;
	}
	public String getQ1() {
		return q1;
	}
	public String getQ2() {
		return q2;
	}
	public String getQ3() {
		return q3;
	}
}
