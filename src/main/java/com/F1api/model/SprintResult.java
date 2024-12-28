package com.F1api.model;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "sprint_results")
public class SprintResult {
	@Id
	@Column(name = "sprint_result_id")
	private int id;
	@Column(name = "race_id")
	private int raceId;
	@OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
	private Driver driver;
	@OneToOne
    @JoinColumn(name = "constructor_id", referencedColumnName = "constructor_id")
	private Constructor constructor;
	@Column(name = "number")
	private Integer number;
	@Column(name = "grid")
	private int grid;
	@Column(name = "position")
	private Integer position;
	@Column(name = "position_text")
	private String positionText;
	@Column(name = "position_order")
	private int positionOrder;
	@Column(name = "points")
	private float points;
	@Column(name = "laps")
	private int laps;
	@Column(name = "time")
	private String time;
	@Column(name = "milliseconds")
	private Integer milliseconds;
	@Column(name = "fastest_lap")
	private Integer fastestLap;
	@Column(name = "fastest_lap_time")
	private String fastestLapTime;
	@OneToOne
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
	private Status status;

}
