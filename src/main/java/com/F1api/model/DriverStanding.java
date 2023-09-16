package com.F1api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "driverstandings")
public class DriverStanding {
	@Id
	@Column(name = "driverstandingsid")
	private int driver_standings_id;
	@Column(name = "raceid")
	private int raceId;
	@Column(name = "driverid")
	private int driverId;
	@Column(name = "points")
	private float points;
	@Column(name = "position")
	private int position;
	@Column(name = "positiontext")
	private String position_text;
	@Column(name = "wins")
	private int wins;
	
	public int getDriverStandingsId() {
		return driver_standings_id;
	}
	public int getRaceId() {
		return raceId;
	}
	public int getDriverId() {
		return driverId;
	}
	public float getPoints() {
		return points;
	}
	public int getPosition() {
		return position;
	}
	public String getPositionText() {
		return position_text;
	}
	public int getWins() {
		return wins;
	}
}
