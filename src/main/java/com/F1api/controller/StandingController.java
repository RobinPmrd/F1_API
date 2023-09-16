package com.F1api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.F1api.model.ConstructorStanding;
import com.F1api.model.ConstructorStandingRow;
import com.F1api.model.DriverStanding;
import com.F1api.model.DriverStandingRow;
import com.F1api.service.ConstructorStandingService;
import com.F1api.service.DriverStandingService;

@RestController
@RequestMapping("/standings")
public class StandingController {
	@Autowired
	private DriverStandingService driver_standings_service;
	@Autowired
	private ConstructorStandingService constructor_standings_service;
	
	@GetMapping(value = "/drivers/{season}")
	@CrossOrigin( origins = "*")
	public List<DriverStandingRow> getDriverStanding(@PathVariable(name = "season") int season) {
		return driver_standings_service.getDriverStanding(season);
	}
	
	@GetMapping(value = "/drivers/{season}/{race_id}")
	@CrossOrigin( origins = "*")
	public List<DriverStandingRow> getDriverStanding(@PathVariable(name = "season") int season, @PathVariable(name = "race_id") int race_id) {
		return driver_standings_service.getDriverStanding(season, race_id);
	}
	
	@GetMapping(value = "/{driver_id}/{race_ids}")
	@CrossOrigin( origins = "*")
	public List<DriverStanding> getDriverStandingByRaces(@PathVariable(name = "driver_id") int driver_id, @PathVariable(name = "race_ids") List<Integer> race_ids) {
		return driver_standings_service.getDriverStandingByRaces(driver_id, race_ids);
	}
	
	@GetMapping(value = "/constructors/{season}")
	@CrossOrigin( origins = "*")
	public List<ConstructorStandingRow> getConstructorStanding(@PathVariable(name = "season") int season) {
		return constructor_standings_service.getConstructorStanding(season);
	}
	
	@GetMapping(value = "/constructors/{season}/{race_id}")
	@CrossOrigin( origins = "*")
	public List<ConstructorStandingRow> getConstructorStanding(@PathVariable(name = "season") int season, @PathVariable(name = "race_id") int race_id) {
		return constructor_standings_service.getConstructorStanding(season, race_id);
	}
	
	@GetMapping(value = "/constructors/id/{constructor_id}/{race_ids}")
	@CrossOrigin( origins = "*")
	public List<ConstructorStanding> getConstructorStandingByRaces(@PathVariable(name = "constructor_id") int constructor_id, @PathVariable(name = "race_ids") List<Integer> race_ids) {
		return constructor_standings_service.getConstructorStandingByRaces(constructor_id, race_ids);
	}
}
