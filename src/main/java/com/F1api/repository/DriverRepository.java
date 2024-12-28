package com.F1api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.F1api.model.Driver;
import com.F1api.model.DriverInfo;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{
	@Query(value = "select r.driver_id, c.* from results r\r\n"
			+ "join drivers d on d.driver_id = r.driver_id\r\n"
			+ "join constructors c on c.constructor_id = r.constructor_id\r\n"
			+ "group by (r.driver_id, c.constructor_id, c.constructor_ref, c.name, c.nationality, c.url)", nativeQuery = true)
	List<Object[]> findTeams();
	
	@Query(value = "WITH last_races_id as (select max(race_id) as raceId from races\r\n"
			+ "group by year),\r\n"
			+ "	subquery as (select ds.driver_id, count(ds.race_id) as titles from driver_standings ds\r\n"
			+ "join last_races_id lr on lr.raceId = ds.race_id\r\n"
			+ "where ds.position = 1\r\n"
			+ "group by ds.driver_id)\r\n"
			+ "select results.driver_id as id, count(*) as races, sum(CASE WHEN position_order=1 THEN 1 ELSE 0 END) as wins, \r\n"
			+ "		sum(CASE WHEN grid=1 THEN 1 ELSE 0 END) as poles, COALESCE(titles,0) as titles,\r\n"
			+ "		sum(CASE WHEN position_order<=3 THEN 1 ELSE 0 END) as podiums, min(case when grid = 0 then 99 else grid end) as bestgridposition,\r\n"
			+ "		min(position_order) as bestraceposition, STRING_AGG( distinct CAST(r.year AS text), ',') as seasons from results\r\n"
			+ "left join subquery on subquery.driver_id = results.driver_id\r\n"
			+ "join races r on r.race_id = results.race_id\r\n"
			+ "group by results.driver_id, titles", nativeQuery = true)
	List<DriverInfo> findTitlesWinsRaces();
	
	interface DriverTeamMate {
		Driver getDriver();
		int getMin();
		int getMax();
	}
	
	@Query(   "select re.driver as driver, min(r.year) as min, max(r.year) as max from Result re "
			+ "join Race r on r.id = re.raceId "
			+ "where (re.raceId, re.constructor.id) in (select re2.raceId, re2.constructor.id from Result re2 "
			+ "					where re2.driver.id = :driver_id) and re.driver.id != :driver_id "
			+ "group by re.driver "
			+ "order by max(r.date)")
	List<DriverTeamMate> findTeamMates(int driver_id);
}
