package com.F1api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.F1api.model.Circuit;
import com.F1api.service.CircuitService;

@RestController
@RequestMapping("/circuits")
public class CircuitController {

	@Autowired
	private CircuitService circuit_service;
	
	@GetMapping("")
	@CrossOrigin("*")
	public List<Circuit> getCircuits() {
		return circuit_service.getCircuits();
	}
}
