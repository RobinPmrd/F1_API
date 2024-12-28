package com.F1api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.F1api.model.Constructor;

@Repository
public interface ConstructorRepository extends JpaRepository<Constructor, Integer> {
	
	@Query(value = """
            WITH last_race AS (SELECT MAX(race_id) AS last_race_id
            			FROM races
            			GROUP BY year),
            names as (select CASE
            		WHEN POSITION('-' IN c.name) > 0 THEN SUBSTRING(c.name FROM 1 FOR POSITION('-' IN c.name) - 1)\r
            		ELSE c.name\r
            		END AS name_prefix from constructors c\r
            	group by name_prefix), \r
            sub as (select CASE \r
            		WHEN POSITION('-' IN c.name) > 0 THEN SUBSTRING(c.name FROM 1 FOR POSITION('-' IN c.name) - 1)\r
            		ELSE c.name\r
            		END AS name_prefix, \r
            	count(distinct (re.race_id)) as races, count(CASE WHEN re.position = 1 THEN 1 END) as wins from results re\r
            	join races r on r.race_id = re.race_id\r
            	join constructors c on c.constructor_id = re.constructor_id\r
            	group by name_prefix),\r
            sub2 as (select CASE \r
            		WHEN POSITION('-' IN c.name) > 0 THEN SUBSTRING(c.name FROM 1 FOR POSITION('-' IN c.name) - 1)\r
            		ELSE c.name\r
            		END AS name_prefix,\r
            		count(*) as titles from constructor_standings cs\r
            		JOIN last_race lr on lr.last_race_id = cs.race_id\r
            		JOIN constructors c ON c.constructor_id = cs.constructor_id\r
            		where position = 1\r
            		group by name_prefix)\r
            \r
            select sub.name_prefix, CAST(COALESCE(titles,0) AS INTEGER) as titles, CAST(wins AS INTEGER), CAST(races AS INTEGER) from sub2\r
            right join sub on sub2.name_prefix = sub.name_prefix""", nativeQuery = true)
	List<Object[]> findTitlesWinsRaces();
	
	@Query("SELECT r.year FROM Result re "
			+ "JOIN Race r ON r.id = re.raceId "
			+ "WHERE constructor.id = :constructor_id "
			+ "GROUP BY r.year "
			+ "ORDER BY r.year")
	List<Integer> findSeasons(int constructor_id);
	
	public interface DriverConstructor {
		int getYear();
		Constructor getConstructor();
	}
	
	@Query("SELECT r.year as year, re.constructor as constructor FROM Result re "
			+ "JOIN Race r ON r.id = re.raceId "
			+ "WHERE re.driver.id = :driver_id "
			+ "GROUP BY (r.year, re.constructor) "
			+ "ORDER BY MIN(r.date)")
	List<DriverConstructor> findDriverConstructors(int driver_id);
}
