package com.F1api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DriverStandingRow {

	@Id
	@Column(name = "position")
	private int position;
	@Column(name = "points")
	private int points;
	@Column(name = "forename")
	private String forename;
	@Column(name = "surname")
	private String surname;
	@Column(name = "team")
	private String team;
	@Column(name = "nationality")
	private String nationality;
	
	public int getPosition() {
		return position;
	}
	public int getPoints() {
		return points;
	}
	public String getForename() {
		return forename;
	}
	public String getSurname() {
		return surname;
	}
	public String getTeam() {
		return team;
	}
	public String getNationality() {
		return nationality;
	}
}
