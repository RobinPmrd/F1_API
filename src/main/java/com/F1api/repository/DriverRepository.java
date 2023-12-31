package com.F1api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.F1api.model.Driver;
import com.F1api.model.DriverInfo;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{
	@Query(value = "select r.driverid, c.* from results r\r\n"
			+ "join drivers d on d.driverid = r.driverid\r\n"
			+ "join constructors c on c.constructorid = r.constructorid\r\n"
			+ "group by (r.driverid, c.constructorid, c.constructorref, c.name, c.nationality, c.url)", nativeQuery = true)
	List<Object[]> findTeams();
	
	@Query(value = "WITH last_races_id as (select max(raceId) as raceId from races\r\n"
			+ "group by year),\r\n"
			+ "	subquery as (select ds.driverId, count(ds.raceId) as titles from driverstandings ds\r\n"
			+ "join last_races_id lr on lr.raceId = ds.raceId\r\n"
			+ "where ds.position = 1\r\n"
			+ "group by ds.driverId)\r\n"
			+ "select results.driverid as id, count(*) as races, sum(CASE WHEN positionorder=1 THEN 1 ELSE 0 END) as wins, \r\n"
			+ "		sum(CASE WHEN grid=1 THEN 1 ELSE 0 END) as poles, COALESCE(titles,0) as titles,\r\n"
			+ "		sum(CASE WHEN positionorder<=3 THEN 1 ELSE 0 END) as podiums, min(case when grid = 0 then 99 else grid end) as bestgridposition,\r\n"
			+ "		min(positionorder) as bestraceposition, STRING_AGG( distinct CAST(r.year AS text), ',') as seasons from results\r\n"
			+ "left join subquery on subquery.driverid = results.driverid\r\n"
			+ "join races r on r.raceid = results.raceid\r\n"
			+ "group by results.driverid, titles", nativeQuery = true)
	List<DriverInfo> findTitlesWinsRaces();
	
	public interface DriverTeamMate {
		Driver getDriver();
		int getMin();
		int getMax();
	}
	
	@Query(   "select re.driver as driver, min(r.year) as min, max(r.year) as max from Result re "
			+ "join Race r on r.id = re.raceid "
			+ "where (re.raceid, re.constructor.id) in (select re2.raceid, re2.constructor.id from Result re2 "
			+ "					where re2.driver.id = :driver_id) and re.driver.id != :driver_id "
			+ "group by re.driver "
			+ "order by max(r.date)")
	List<DriverTeamMate> findTeamMates(int driver_id);
}
