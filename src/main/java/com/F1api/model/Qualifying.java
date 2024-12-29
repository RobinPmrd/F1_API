package com.F1api.model;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "qualifying")
public class Qualifying {
	@Id
	@Column(name = "qualify_id")
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
	private int number;
	@Column(name = "position")
	private int position;
	@Column(name = "q1")
	private String q1;
	@Column(name = "q2")
	private String q2;
	@Column(name = "q3")
	private String q3;

}
