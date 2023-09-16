package com.F1api.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "circuits")
public class Circuit {
	@Id
	@Column(name = "circuitid")
	private int id;
	@Column(name = "circuitref", length = 255, nullable = false)
	private String circuit_ref;
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	@Column(name = "location", length = 255, nullable = false)
	private String location;
	@Column(name = "country", length = 255, nullable = false)
	private String country;
	@Column(name = "lat")
	private float lat;
	@Column(name = "lng")
	private float lng;
	@Column(name = "alt")
	private Integer alt;
	@Column(name = "url", length = 255)
	private String url;
	@Transient
	private int races;
	
	public int getId() {
		return id;
	}
	public String getCircuitRef() {
		return circuit_ref;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public String getCountry() {
		return country;
	}
	public float getLat() {
		return lat;
	}
	public float getLng() {
		return lng;
	}
	public Integer getAlt() {
		return alt;
	}
	public String getUrl() {
		return url;
	}
	public int getRaces() {
		return races;
	}
	public void setRaces(int races) {
		this.races = races;
	}
}
