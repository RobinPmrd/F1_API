package com.F1api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "driver_standings")
public class DriverStanding {
	@Id
	@Column(name = "driver_standings_id")
	private int driverStandingsId;
	@Column(name = "race_id")
	private int raceId;
	@Column(name = "driver_id")
	private int driverId;
	@Column(name = "points")
	private float points;
	@Column(name = "position")
	private int position;
	@Column(name = "position_text")
	private String positionText;
	@Column(name = "wins")
	private int wins;
	
}
