package com.F1api.model;

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
	
}
