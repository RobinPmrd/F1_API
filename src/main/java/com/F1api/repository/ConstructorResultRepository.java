package com.F1api.repository;

import com.F1api.model.ConstructorResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConstructorResultRepository extends JpaRepository<ConstructorResult, Integer> {
	
	@Query(value = "select re from ConstructorResult re "
			+ "join Race r on r.id = re.raceId "
			+ "where r.year = :season and re.constructor.id = :constructor_id")
	List<ConstructorResult> findConstructorResultsBySeason(int season, int constructor_id);
	
}
