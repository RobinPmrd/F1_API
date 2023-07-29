package com.F1api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.F1api.model.Qualifying;
import com.F1api.service.QualifyingService;

@RestController
@RequestMapping("/qualifying")
public class QualifyingController {
	
	@Autowired
	private QualifyingService qualifying_service;
	
	@GetMapping(value = "/{race_name}/{season}")
	@CrossOrigin( origins = "*")
	public List<Qualifying> getRaceQualifying(@PathVariable(name = "race_name") String race_name, @PathVariable(name = "season") int season) {
		return qualifying_service.getRaceQualifying(race_name, season);
	}
}
