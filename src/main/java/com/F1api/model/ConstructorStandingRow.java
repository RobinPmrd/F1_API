package com.F1api.model;

public class ConstructorStandingRow {
	private int position;
	private double points;
	private Constructor constructor;
	
	public ConstructorStandingRow(int position, double points, Constructor constructor) {
		this.position = position;
		this.points = points;
		this.constructor = constructor;
	}
	
	public int getPosition() {
		return position;
	}
	
	public double getPoints() {
		return points;
	}
	
	public Constructor getConstructor() {
		return constructor;
	}
}
