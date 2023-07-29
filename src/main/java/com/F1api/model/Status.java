package com.F1api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
	@Id
	@Column(name = "statusid")
	private int id;
	@Column(name = "status", length = 255)
	private String status;
	
	public int getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}
}
