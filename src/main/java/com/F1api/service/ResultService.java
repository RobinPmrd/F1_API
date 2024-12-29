package com.F1api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.F1api.model.ConstructorResult;
import com.F1api.model.Result;
import com.F1api.model.SprintResult;
import com.F1api.repository.ConstructorResultRepository;
import com.F1api.repository.ResultRepository;
import com.F1api.repository.SprintResultRepository;

@Service
public class ResultService {
	@Autowired
	private ResultRepository rr;
	@Autowired
	private ConstructorResultRepository crr;
	@Autowired
	private SprintResultRepository srr;
	
	public List<Result> getRaceResult(int race_id) {
		return rr.findByRaceId(race_id);
	}
	
	public List<SprintResult> getRaceSprintResult(int race_id) {
		return srr.findByRaceId(race_id);
	}
	
	public List<Result> getDriverResultsBySeason(int season, int driver_id) {
		return rr.findDriverResultsBySeason(season, driver_id);
	}
	
	public List<ConstructorResult> getConstructorResultsBySeason(int season, int constructor_id) {
		return crr.findConstructorResultsBySeason(season, constructor_id);
	}
}
