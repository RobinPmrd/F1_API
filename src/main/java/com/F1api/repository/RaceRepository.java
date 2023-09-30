package com.F1api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.F1api.model.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {

	List<Race> findByName(String name);
	
	@Query(value = "SELECT r from Race r WHERE r.year = :season and r.date < (select DATE(NOW())) ORDER BY r.round")
	List<Race> findRaces(int season);
	
	@Query(value = "SELECT r from Race r "
			+ "JOIN Result re ON re.raceid = r.id "
			+ "WHERE re.position = 1 and re.driver.id = :driver_id")
	List<Race> findRacesWinByDriver(int driver_id);
}
