package com.F1api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.F1api.model.ConstructorResult;
import com.F1api.model.Result;

@Repository
public interface ConstructorResultRepository extends JpaRepository<ConstructorResult, Integer> {
	
	@Query(value = "select re from ConstructorResult re "
			+ "join Race r on r.id = re.race_id "
			+ "where r.year = :season and re.constructor.id = :constructor_id")
	List<ConstructorResult> findConstructorResultsBySeason(int season, int constructor_id);
	
}
