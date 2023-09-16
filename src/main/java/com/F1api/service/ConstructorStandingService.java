package com.F1api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.F1api.model.ConstructorStanding;
import com.F1api.model.ConstructorStandingRow;
import com.F1api.repository.ConstructorStandingRepository;

@Service
public class ConstructorStandingService {
	
	@Autowired
	private ConstructorStandingRepository csr;
	
	public List<ConstructorStandingRow> getConstructorStanding(int season) {
		return csr.findConstructorStanding(season);
	}
	
	public List<ConstructorStandingRow> getConstructorStanding(int season, int race_id) {
		return csr.findConstructorStanding(season, race_id);
	}
	
	public List<ConstructorStanding> getConstructorStandingByRaces(int constructor_id, List<Integer> race_ids) {
		return csr.findByConstructorIdAndRaceIdIn(constructor_id, race_ids);
	}
}
