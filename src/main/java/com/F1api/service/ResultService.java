package com.F1api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.F1api.model.Result;
import com.F1api.repository.ResultRepository;

@Service
public class ResultService {
	@Autowired
	private ResultRepository rr;
	
	public List<Result> getRaceResult(String race_name, int season) {
		return rr.findRaceResults(race_name, season);
	}
}
