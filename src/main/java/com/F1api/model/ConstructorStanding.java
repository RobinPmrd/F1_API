package com.F1api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "constructorstandings")
public class ConstructorStanding {
	@Id
	@Column(name = "constructorstandingsid")
	private int constructor_standings_id;
	@Column(name = "raceid")
	private int race_id;
	@Column(name = "constructorid")
	private int constructor_id;
	@Column(name = "points")
	private float points;
	@Column(name = "position")
	private int position;
	@Column(name = "positiontext")
	private String position_text;
	@Column(name = "wins")
	private int wins;
	
	public int getConstructorStandingsId() {
		return constructor_standings_id;
	}
	public int getRaceId() {
		return race_id;
	}
	public int getConstructorId() {
		return constructor_id;
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
