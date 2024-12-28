package com.F1api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "constructor_standings")
public class ConstructorStanding {
	@Id
	@Column(name = "constructor_standings_id")
	private int constructorStandingsId;
	@Column(name = "race_id")
	private int raceId;
	@Column(name = "constructor_id")
	private int constructorId;
	@Column(name = "points")
	private float points;
	@Column(name = "position")
	private int position;
	@Column(name = "position_text")
	private String positionText;
	@Column(name = "wins")
	private int wins;

}
