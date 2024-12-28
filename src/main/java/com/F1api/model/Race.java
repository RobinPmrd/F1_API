package com.F1api.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Entity
@Table(name = "races")
public class Race {
	@Id
	@Column(name = "race_id")
	private int id;
	@Column(name = "year", nullable = false)
	private int year;
	@Column(name = "round", nullable = false)
	private int round;
	@ManyToOne
	@JoinColumn(name = "circuit_id", referencedColumnName = "circuit_id")
	private Circuit circuit;
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	@Column(name = "date")
	private Date date;
	@Column (name = "time")
	private Time time;
	@Column(name = "url", length = 255)
	private String url;
	
}
