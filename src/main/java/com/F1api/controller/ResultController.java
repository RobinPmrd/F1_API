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
import com.F1api.model.SprintResult;
import com.F1api.service.ResultService;

@RestController
@RequestMapping("/results")
public class ResultController {
	
	@Autowired
	private ResultService result_service;
	
	@GetMapping(value = "/{race_id}")
	@CrossOrigin( origins = "*")
	public List<Result> getRaceResult(@PathVariable(name = "race_id") int race_id) {
		return result_service.getRaceResult(race_id);
	}
	@GetMapping(value = "/sprint/{race_id}")
	@CrossOrigin( origins = "*")
	public List<SprintResult> getRaceSprintResult(@PathVariable(name = "race_id") int race_id) {
		return result_service.getRaceSprintResult(race_id);
	}
	
	@GetMapping(value = "/{driver_id}/{season}")
	@CrossOrigin( origins = "*")
	public List<Result> getDriverResultsBySeason(@PathVariable(name = "driver_id") int driver_id, @PathVariable(name = "season") int season) {
		return result_service.getDriverResultsBySeason(season, driver_id);
	}
	
	@GetMapping(value = "/constructor/{constructor_id}/{season}")
	@CrossOrigin( origins = "*")
	public List<ConstructorResult> getConstructorResultsBySeason(@PathVariable(name = "constructor_id") int constructor_id, @PathVariable(name = "season") int season) {
		return result_service.getConstructorResultsBySeason(season, constructor_id);
	}
}
