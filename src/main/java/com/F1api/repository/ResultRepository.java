package com.F1api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.F1api.model.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
	
	List<Result> findByRaceId(int id);
	
	@Query(value = "select re from Result re "
			+ "join Race r on r.id = re.raceId "
			+ "where r.year = :season and re.driver.id = :driver_id")
	List<Result> findDriverResultsBySeason(int season, int driver_id);
}
