package com.F1api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "constructorresults")
public class ConstructorResult {
	@Id
	@Column(name = "constructorresultsid")
	private int constructor_results_id;
	@Column(name = "raceid")
	private int race_id;
	@OneToOne
    @JoinColumn(name = "constructorid", referencedColumnName = "constructorid")
	private Constructor constructor;
	@Column(name = "points")
	private float points;
	@Column(name = "status")
	private String status;
	
	public int getConstructorResultsId() {
		return constructor_results_id;
	}
	public int getRaceId() {
		return race_id;
	}
	public Constructor getConstructor() {
		return constructor;
	}
	public float getPoints() {
		return points;
	}
	public String getStatus() {
		return status;
	}
}
