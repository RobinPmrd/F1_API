package com.F1api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.F1api.model.DriverStanding;
import com.F1api.model.DriverStandingRow;
import com.F1api.repository.DriverStandingRepository;

@Service
public class DriverStandingService {
	@Autowired
	private DriverStandingRepository dsr;

	public List<DriverStandingRow> getDriverStanding(int season) {
		return dsr.findStanding(season);
	}
	
	public List<DriverStandingRow> getDriverStanding(int season, String race_name) {
		return dsr.findStanding(season, race_name);
	}
	
	public List<DriverStanding> getDriverStandingByRaces(int driver_id, List<Integer> race_ids) {
		return dsr.findByDriverIdAndRaceIdIn(driver_id, race_ids);
	}
}
