package com.F1api.model;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "constructor_results")
public class ConstructorResult {
	@Id
	@Column(name = "constructor_results_id")
	private int constructorResultsId;
	@Column(name = "race_id")
	private int raceId;
	@OneToOne
    @JoinColumn(name = "constructor_id", referencedColumnName = "constructor_id")
	private Constructor constructor;
	@Column(name = "points")
	private float points;
	@Column(name = "status")
	private String status;
	
}
