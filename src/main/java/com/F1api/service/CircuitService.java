package com.F1api.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.F1api.model.Circuit;
import com.F1api.repository.CircuitRepository;

@Service
public class CircuitService {
	@Autowired
	private CircuitRepository circuit_repository;
	
	public List<Circuit> getCircuits() {
		List<Circuit> circuits = circuit_repository.findAll();
		Map<Integer, Integer> circuits_races_count = circuit_repository.findRaces().stream().collect(Collectors.toMap(
				result -> (Integer) result[0], // circuitid 
				result -> (Integer) result[1])); // races_count
		circuits.stream().forEach(circuit -> circuit.setRaces(circuits_races_count.get(circuit.getId())));
		return circuits;
	}
}
