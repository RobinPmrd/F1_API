package com.F1api.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "constructors")
public class Constructor {
	@Id
	@Column(name = "constructorid")
	private int id;
	@Column(name = "constructorref", length = 255, nullable = false)
	private String constructor_ref;
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
	private String driver_season_period;
	@Transient
	private List<Integer> seasons;
	
	public Constructor() {};
	
	public Constructor(Constructor c) {
		this.id = c.getId();
		this.constructor_ref = c.getConstructorRef();
		this.name = c.getName();
		this.nationality = c.getNationality();
		this.url = c.getUrl();
	}
	
	public int getId() {
		return id;
	}
	public String getConstructorRef() {
		return constructor_ref;
	}
	public String getName() {
		return name;
	}
	public String getNationality() {
		return nationality;
	}
	public String getUrl() {
		return url;
	}
	public int getTitles() {
		return titles;
	}
	public void addTitles(int titles) {
		this.titles += titles;
	}
	public int getWins() {
		return wins;
	}
	public void addWins(int wins) {
		this.wins += wins;
	}
	public int getRaces() {
		return races;
	}
	public void addRaces(int races) {
		this.races += races;
	}
	public String getDriverSeasonPeriod() {
		return driver_season_period;
	}
	public void setDriverSeasonPeriod(String driver_season_period) {
		this.driver_season_period = driver_season_period;
	}

	public List<Integer> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Integer> seasons) {
		this.seasons = seasons;
	}
	
}
