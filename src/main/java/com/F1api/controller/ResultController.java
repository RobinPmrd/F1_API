package com.F1api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.F1api.model.ConstructorResult;
import com.F1api.model.Result;
import com.F1api.service.ResultService;

@RestController
@RequestMapping("/results")
public class ResultController {
	
	@Autowired
	private ResultService result_service;
	
	@GetMapping(value = "/{id}")
	@CrossOrigin( origins = "*")
	public List<Result> getRaceResult(@PathVariable(name = "id") int id) {
		return result_service.getRaceResult(id);
	}
	
	@GetMapping(value = "/{race_name}/{season}")
	@CrossOrigin( origins = "*")
	public List<Result> getRaceResult(@PathVariable(name = "race_name") String race_name, @PathVariable(name = "season") int season) {
		return result_service.getRaceResult(race_name, season);
	}
	
	@GetMapping(value = "/driverid/{driver_id}/{season}")
	@CrossOrigin( origins = "*")
	public List<Result> getDriverResultsBySeason(@PathVariable(name = "driver_id") int driver_id, @PathVariable(name = "season") int season) {
		return result_service.getDriverResultsBySeason(season, driver_id);
	}
	
	@GetMapping(value = "/constructor/{name}/{season}")
	@CrossOrigin( origins = "*")
	public List<ConstructorResult> getConstructorResultsBySeason(@PathVariable(name = "name") String name, @PathVariable(name = "season") int season) {
		return result_service.getConstructorResultsBySeason(season, name);
	}
}
