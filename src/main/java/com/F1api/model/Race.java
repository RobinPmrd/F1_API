package com.F1api.model;

import java.sql.Date;
import java.sql.Time;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "races")
public class Race {
	@Id
	@Column(name = "raceid")
	private int id;
	@Column(name = "year", nullable = false)
	private int year;
	@Column(name = "round", nullable = false)
	private int round;
	@ManyToOne
	@JoinColumn(name = "circuitid", referencedColumnName = "circuitid")
	private Circuit circuit;
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	@Column(name = "date")
	private Date date;
	@Column (name = "time")
	private Time time;
	@Column(name = "url", length = 255)
	private String url;
	
	public int getId() {
		return id;
	}
	public int getYear() {
		return year;
	}
	public int getRound() {
		return round;
	}
	public Circuit getCircuit() {
		return circuit;
	}
	public String getName() {
		return name;
	}
	public Date getDate() {
		return date;
	}
	public Time getTime() {
		return time;
	}
	public String getUrl() {
		return url;
	}
}
