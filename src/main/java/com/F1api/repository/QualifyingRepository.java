package com.F1api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.F1api.model.Qualifying;

public interface QualifyingRepository extends JpaRepository<Qualifying, Integer> {

	@Query(value = "SELECT q.* FROM qualifying q JOIN races r on r.race_id = q.race_id WHERE r.name = :race_name AND r.year = :season", nativeQuery = true)
	List<Qualifying> findRaceQualifying(String race_name, int season);
	
	List<Qualifying> findByRaceId(int id);
}
