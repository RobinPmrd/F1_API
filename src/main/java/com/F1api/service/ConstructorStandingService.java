package com.F1api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.F1api.model.ConstructorStandingRow;
import com.F1api.repository.ConstructorStandingRepository;

@Service
public class ConstructorStandingService {
	
	@Autowired
	private ConstructorStandingRepository csr;
	
	public List<ConstructorStandingRow> getConstructorStanding(int season) {
		return csr.findConstructorStanding(season);
	}
	
	public List<ConstructorStandingRow> getConstructorStanding(int season, String race_name) {
		return csr.findConstructorStanding(season, race_name);
	}
}
