package com.F1api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ConstructorStandingRow {
	
	@Id
	@Column(name = "position")
	private int position;
	@Column(name = "points")
	private int points;
	@Column(name = "name")
	private String name;
	@Column(name = "nationality")
	private String nationality;
	
	public int getPosition() {
		return position;
	}
	public int getPoints() {
		return points;
	}
	public String getName() {
		return name;
	}
	public String getNationality() {
		return nationality;
	}
}
