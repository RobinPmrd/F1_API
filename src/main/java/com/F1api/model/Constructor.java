package com.F1api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "constructors")
public class Constructor {
	@Id
	@Column(name = "constructor_id")
	private int id;
	@Column(name = "constructor_ref", length = 255, nullable = false)
	private String constructorRef;
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	@Column(name = "nationality", length = 255, nullable = false)
	private String nationality;
	@Column(name = "url", length = 255)
	private String url;
	@Transient
	private int titles;
	@Transient
	private int wins;
	@Transient
	private int races;
	@Transient
	private String driverSeasonPeriod;
	@Transient
	private List<Integer> seasons;
	
	public Constructor() {};
	
	public Constructor(Constructor c) {
		this.id = c.getId();
		this.constructorRef = c.getConstructorRef();
		this.name = c.getName();
		this.nationality = c.getNationality();
		this.url = c.getUrl();
	}
	
	public void addTitles(int titles) {
		this.titles += titles;
	}
	public void addWins(int wins) {
		this.wins += wins;
	}
	public void addRaces(int races) {
		this.races += races;
	}

}
