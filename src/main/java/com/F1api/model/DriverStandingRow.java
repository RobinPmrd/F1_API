package com.F1api.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class DriverStandingRow {
	
	private int position;
	private double points;
	private String team;
	private Driver driver;
	
	public DriverStandingRow(int position, double points, String team, Driver driver) {
		List<String> team_set = new ArrayList<String>();
		List<String> team_names = Arrays.asList(team.split(" / "));
		List<String[]> team_names2 = team_names.stream().map(name -> name.split(",")).sorted((o1, o2) -> Integer.parseInt(o1[1]) - Integer.parseInt(o2[1])).toList();
		for (String[] team_name : team_names2) {
			if (!team_set.contains(team_name[0])) team_set.add(team_name[0]);
		}
		team = String.join(" / ", team_set);
		this.position = position;
		this.points = points;
		this.team = team;
		this.driver = driver;
	}

}
