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
		List<Race> races = race_repository.findAll();
		Map<Integer, String> circuits_races_count = race_repository.findRacesWinner().stream().collect(Collectors.toMap(
				result -> (Integer) result[0], // raceid 
				result -> (String) result[1])); // races_count
		races.stream().forEach(race -> race.setWinner(circuits_races_count.get(race.getId())));
		return races;
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
}
