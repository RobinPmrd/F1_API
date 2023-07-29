package com.F1api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.F1api.model.ConstructorStandingRow;
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
	
	@GetMapping(value = "/drivers/{season}/{race_name}")
	@CrossOrigin( origins = "*")
	public List<DriverStandingRow> getDriverStanding(@PathVariable(name = "season") int season, @PathVariable(name = "race_name") String race_name) {
		return driver_standings_service.getDriverStanding(season, race_name);
	}
	
	@GetMapping(value = "/constructors/{season}")
	@CrossOrigin( origins = "*")
	public List<ConstructorStandingRow> getConstructorStanding(@PathVariable(name = "season") int season) {
		return constructor_standings_service.getConstructorStanding(season);
	}
	
	@GetMapping(value = "/constructors/{season}/{race_name}")
	@CrossOrigin( origins = "*")
	public List<ConstructorStandingRow> getConstructorStanding(@PathVariable(name = "season") int season, @PathVariable(name = "race_name") String race_name) {
		return constructor_standings_service.getConstructorStanding(season, race_name);
	}
}
