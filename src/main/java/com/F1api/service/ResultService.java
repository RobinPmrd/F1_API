package com.F1api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.F1api.model.ConstructorResult;
import com.F1api.model.Result;
import com.F1api.repository.ConstructorResultRepository;
import com.F1api.repository.ResultRepository;

@Service
public class ResultService {
	@Autowired
	private ResultRepository rr;
	@Autowired
	private ConstructorResultRepository crr;
	
	public List<Result> getRaceResult(String race_name, int season) {
		return rr.findRaceResults(race_name, season);
	}
	
	public List<Result> getRaceResult(int id) {
		return rr.findByRaceid(id);
	}
	
	public List<Result> getDriverResultsBySeason(int season, int driver_id) {
		return rr.findDriverResultsBySeason(season, driver_id);
	}
	
	public List<ConstructorResult> getConstructorResultsBySeason(int season, String name) {
		return crr.findConstructorResultsBySeason(season, name);
	}
}
