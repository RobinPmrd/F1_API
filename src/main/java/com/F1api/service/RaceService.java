package com.F1api.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.F1api.model.Race;
import com.F1api.repository.RaceRepository;

@Service
public class RaceService {
	@Autowired
	private RaceRepository race_repository;
	
	public List<Race> getRaces() {
		return race_repository.findAll();
	}
	
	public List<Race> getRaces(int season) {
		return race_repository.findRaces(season);
	}
	
	public List<Race> getRaces(String name) {
		return race_repository.findByName(name);
	}
	
	public Race getRace(String name, int season) {
		return race_repository.findAll().stream().filter(race -> race.getName().equals(name) && race.getYear() == season).findFirst().get();
	}
	
	public List<Race> getRacesWinByDriver(int driver_id) {
		return race_repository.findRacesWinByDriver(driver_id);
	}
}
