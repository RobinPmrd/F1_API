package com.F1api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "status")
public class Status {
	@Id
	@Column(name = "status_id")
	private int id;
	@Column(name = "status", length = 255)
	private String status;
	
}
