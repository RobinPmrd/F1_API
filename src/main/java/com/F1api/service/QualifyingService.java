package com.F1api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.F1api.model.Qualifying;
import com.F1api.repository.QualifyingRepository;

@Service
public class QualifyingService {
	
	@Autowired
	private QualifyingRepository qr;
	
	public List<Qualifying> getRaceQualifying(String race_name, int season) {
		return qr.findRaceQualifying(race_name, season);
	}
}
