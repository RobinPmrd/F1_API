package com.F1api.model;

import lombok.Getter;

@Getter
public class ConstructorStandingRow {
	private int position;
	private double points;
	private Constructor constructor;
	
	public ConstructorStandingRow(int position, double points, Constructor constructor) {
		this.position = position;
		this.points = points;
		this.constructor = constructor;
	}

}
