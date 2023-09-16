package com.F1api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.F1api.model.Race;
import com.F1api.service.RaceService;

@RestController
@RequestMapping("/races")
public class RaceController {

	@Autowired
	private RaceService race_service;
	
	@GetMapping(value = "")
	@CrossOrigin( origins = "*")
	public List<Race> getRaces() {
		return race_service.getRaces();
	}
	
	@GetMapping(value = "/{season}")
	@CrossOrigin( origins = "*")
	public List<Race> getRaces(@PathVariable(name = "season") int season) {
		return race_service.getRaces(season);
	}
	
	
	@GetMapping(value = "/{name}/{season}")
	@CrossOrigin( origins = "*")
	public Race getRace(@PathVariable(name = "name") String name, @PathVariable(name = "season") int season) {
		return race_service.getRace(name, season);
	}
}
