package com.F1api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.F1api.model.ConstructorResult;
import com.F1api.model.Result;

@Repository
public interface ConstructorResultRepository extends JpaRepository<ConstructorResult, Integer> {
	@Query(value = "SELECT re.* FROM results re JOIN races r on r.raceid = re.raceid WHERE r.name = :race_name AND r.year = :season", nativeQuery = true)
	List<Result> findRaceResults(String race_name, int season);
	
	@Query(value = "select re.* from constructorresults re\r\n"
			+ "join races r on r.raceid = re.raceid\r\n"
			+ "join constructors d on d.constructorid = re.constructorid\r\n"
			+ "where r.year = :season and d.name like :name", nativeQuery = true)
	List<ConstructorResult> findConstructorResultsBySeason(int season, String name);
	
}
