package com.F1api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "circuits")
public class Circuit {
	@Id
	@Column(name = "circuit_id")
	private int id;
	@Column(name = "circuit_ref", length = 255, nullable = false)
	private String circuitRef;
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

}
