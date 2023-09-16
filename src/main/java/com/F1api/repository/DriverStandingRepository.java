package com.F1api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.F1api.model.DriverStanding;
import com.F1api.model.DriverStandingRow;


@Repository
public interface DriverStandingRepository extends JpaRepository<DriverStanding, Integer>{
	
	@Query(value = "select ROW_NUMBER() OVER(order by sum(re.points) + coalesce(sum(sre.points),0) desc, min(re.positionorder) asc) as position, sum(re.points) + coalesce(sum(sre.points),0) as points, d.driverid, d.forename, d.surname, STRING_AGG( distinct c.name, ' / ') AS team, d.nationality from results re\r\n"
			+ "join races r on r.raceid = re.raceid\r\n"
			+ "join drivers d on d.driverid = re.driverid\r\n"
			+ "join constructors c on c.constructorid = re.constructorid\r\n"
			+ "left join sprintresults sre on (sre.driverid, sre.raceid) = (re.driverid, re.raceid)\r\n"
			+ "where r.year = :season\r\n"
			+ "group by (d.driverid, d.forename, d.surname, d.nationality)\r\n", nativeQuery = true)
	List<DriverStandingRow> findStanding(int season);
	
	@Query(value = "select ROW_NUMBER() OVER(order by sum(re.points) + coalesce(sum(sre.points),0) desc, min(re.positionorder) asc) as position, sum(re.points) + coalesce(sum(sre.points),0) as points, d.forename, d.surname, STRING_AGG( distinct c.name, ' / ') AS team, d.nationality  from results re\r\n"
			+ "join races r on r.raceid = re.raceid\r\n"
			+ "join drivers d on d.driverid = re.driverid\r\n"
			+ "join constructors c on c.constructorid = re.constructorid\r\n"
			+ "left join sprintresults sre on (sre.driverid, sre.raceid) = (re.driverid, re.raceid)\r\n"
			+ "where r.year = :season and r.round <= (select round from races\r\n"
			+ "								   where year = :season and name like :race_name)\r\n"
			+ "group by (d.driverid, d.surname, d.nationality)", nativeQuery = true)
	List<DriverStandingRow> findStanding(int season, String race_name);
	
	List<DriverStanding> findByDriverIdAndRaceIdIn(int driver_id, List<Integer> race_ids);
}
