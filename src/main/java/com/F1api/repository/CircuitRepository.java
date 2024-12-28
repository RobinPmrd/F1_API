package com.F1api.repository;

import com.F1api.model.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CircuitRepository extends JpaRepository<Circuit, Integer> {
	@Query(value = "SELECT c.circuit_id, CAST(count(r.race_id) AS INTEGER) FROM circuits c JOIN races r on r.circuit_id = c.circuit_id GROUP BY c.circuit_id", nativeQuery = true)
	List<Object[]> findRaces();
}
