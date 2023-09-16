package com.F1api.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.F1api.model.Circuit;

@Repository
public interface CircuitRepository extends JpaRepository<Circuit, Integer> {
	@Query(value = "SELECT c.circuitid, CAST(count(r.raceid) AS INTEGER) FROM circuits c JOIN races r on r.circuitid = c.circuitid GROUP BY c.circuitid", nativeQuery = true)
	List<Object[]> findRaces();
}
