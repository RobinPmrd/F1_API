package com.F1api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.F1api.model.SprintResult;

@Repository
public interface SprintResultRepository extends JpaRepository<SprintResult, Integer> {
	
	List<SprintResult> findByRaceId(int race_id);
}
