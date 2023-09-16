package com.F1api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "results")
public class Result {
	@Id
	@Column(name = "resultid")
	private int id;
	@Column(name = "raceid")
	private int raceid;
	@OneToOne
    @JoinColumn(name = "driverid", referencedColumnName = "driverid")
	private Driver driver;
	@OneToOne
    @JoinColumn(name = "constructorid", referencedColumnName = "constructorid")
	private Constructor constructor;
	@Column(name = "number")
	private Integer number;
	@Column(name = "grid")
	private int grid;
	@Column(name = "position")
	private Integer position;
	@Column(name = "positiontext")
	private String position_text;
	@Column(name = "positionorder")
	private int position_order;
	@Column(name = "points")
	private float points;
	@Column(name = "laps")
	private int laps;
	@Column(name = "time")
	private String time;
	@Column(name = "milliseconds")
	private Integer milliseconds;
	@Column(name = "fastestlap")
	private Integer fastest_lap;
	@Column(name = "rank")
	private Integer rank;
	@Column(name = "fastestlaptime")
	private String fastest_lap_time;
	@Column(name = "fastestlapspeed")
	private String fastest_lap_speed;
	@OneToOne
    @JoinColumn(name = "statusid", referencedColumnName = "statusid")
	private Status status;
	
	public int getId() {
		return id;
	}
	public int getRaceId() {
		return raceid;
	}
	public Driver getDriver() {
		return driver;
	}
	public Constructor getConstructor() {
		return constructor;
	}
	public Integer getNumber() {
		return number;
	}
	public int getGrid() {
		return grid;
	}
	public Integer getPosition() {
		return position;
	}
	public String getPositionText() {
		return position_text;
	}
	public int getPositionOrder() {
		return position_order;
	}
	public float getPoints() {
		return points;
	}
	public int getLaps() {
		return laps;
	}
	public String getTime() {
		return time;
	}
	public Integer getMilliseconds() {
		return milliseconds;
	}
	public Integer getFastestLap() {
		return fastest_lap;
	}
	public Integer getRank() {
		return rank;
	}
	public String getFastestLapTime() {
		return fastest_lap_time;
	}
	public String getFastestLapSpeed() {
		return fastest_lap_speed;
	}
	public Status getStatus() {
		return status;
	}
}
