package com.F1api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.F1api.model.DriverStanding;
import com.F1api.model.DriverStandingRow;


@Repository
public interface DriverStandingRepository extends JpaRepository<DriverStanding, Integer>{
	
	@Query(value = "select NEW com.F1api.model.DriverStandingRow (CAST(ROW_NUMBER() OVER(order by sum(re.points) + coalesce(sum(sre.points),0) desc, min(re.position_order) asc) AS Integer), "
			+ "sum(re.points) + coalesce(sum(sre.points),0), "
			+ "CAST(STRING_AGG(CONCAT(re.constructor.name, ',', re.id), ' / ') AS text), re.driver) from Result re\r\n"
			+ "join Race r on r.id = re.raceid\r\n"
			+ "left join SprintResult sre on (sre.driver.id, sre.raceid) = (re.driver.id, re.raceid)\r\n"
			+ "where r.year = :season\r\n"
			+ "group by (re.driver)\r\n")
	List<DriverStandingRow> findStanding(int season);
	
	@Query(value = "select NEW com.F1api.model.DriverStandingRow(CAST(ROW_NUMBER() OVER(order by sum(re.points) + coalesce(sum(sre.points),0) desc, min(re.position_order) asc) AS Integer),"
			+ " sum(re.points) + coalesce(sum(sre.points),0), "
			+ "CAST(STRING_AGG(CONCAT(re.constructor.name, ',', re.id), ' / ') AS text), re.driver)  from Result re "
			+ "join Race r on r.id = re.raceid "
			+ "left join SprintResult sre on (sre.driver.id, sre.raceid) = (re.driver.id, re.raceid) "
			+ "where r.year = :season and r.round <= (select round from Race"
			+ "								   where year = :season and id = :race_id)"
			+ "group by re.driver")
	List<DriverStandingRow> findStanding(int season, int race_id);
	
	List<DriverStanding> findByDriverIdAndRaceIdIn(int driver_id, List<Integer> race_ids);
}
