package com.F1api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.F1api.model.ConstructorStanding;
import com.F1api.model.ConstructorStandingRow;
import com.F1api.model.DriverStanding;

@Repository
public interface ConstructorStandingRepository extends JpaRepository<ConstructorStanding, Integer> {
	
	@Query(value = "select NEW com.F1api.model.ConstructorStandingRow(CAST(ROW_NUMBER() OVER(order by sum(re.points) desc) AS Integer),"
			+ " sum(re.points), re.constructor)  from ConstructorResult re\r\n"
			+ "join Race r on r.id = re.race_id\r\n"
			+ "where r.year = :season\r\n"
			+ "group by re.constructor")
	List<ConstructorStandingRow> findConstructorStanding(int season);
	
	@Query(value = "select NEW com.F1api.model.ConstructorStandingRow(CAST(ROW_NUMBER() OVER(order by sum(re.points) desc) AS Integer),"
			+ " sum(re.points), re.constructor)  from ConstructorResult re\r\n"
			+ "join Race r on r.id = re.race_id\r\n"
			+ "where r.year = :season and r.round <= (select round from Race\r\n"
			+ "								   		  where year = :season and id = :race_id)\r\n"
			+ "group by re.constructor")
	List<ConstructorStandingRow> findConstructorStanding(int season, int race_id);
	
	List<ConstructorStanding> findByConstructorIdAndRaceIdIn(int constructor_id, List<Integer> race_ids);
}
