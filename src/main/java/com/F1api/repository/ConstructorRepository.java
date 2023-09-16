package com.F1api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.F1api.model.Constructor;

@Repository
public interface ConstructorRepository extends JpaRepository<Constructor, Integer> {
	
	@Query(value = "WITH last_race AS (SELECT MAX(raceId) AS last_race_id\r\n"
			+ "			FROM races\r\n"
			+ "			GROUP BY year), \r\n"
			+ "names as (select CASE \r\n"
			+ "		WHEN POSITION('-' IN c.name) > 0 THEN SUBSTRING(c.name FROM 1 FOR POSITION('-' IN c.name) - 1)\r\n"
			+ "		ELSE c.name\r\n"
			+ "		END AS name_prefix from constructors c\r\n"
			+ "	group by name_prefix), \r\n"
			+ "sub as (select CASE \r\n"
			+ "		WHEN POSITION('-' IN c.name) > 0 THEN SUBSTRING(c.name FROM 1 FOR POSITION('-' IN c.name) - 1)\r\n"
			+ "		ELSE c.name\r\n"
			+ "		END AS name_prefix, \r\n"
			+ "	count(distinct (re.raceid)) as races, count(CASE WHEN re.position = 1 THEN 1 END) as wins from results re\r\n"
			+ "	join races r on r.raceid = re.raceid\r\n"
			+ "	join constructors c on c.constructorid = re.constructorid\r\n"
			+ "	group by name_prefix),\r\n"
			+ "sub2 as (select CASE \r\n"
			+ "		WHEN POSITION('-' IN c.name) > 0 THEN SUBSTRING(c.name FROM 1 FOR POSITION('-' IN c.name) - 1)\r\n"
			+ "		ELSE c.name\r\n"
			+ "		END AS name_prefix,\r\n"
			+ "		count(*) as titles from constructorstandings cs\r\n"
			+ "		JOIN last_race lr on lr.last_race_id = cs.raceid\r\n"
			+ "		JOIN constructors c ON c.constructorid = cs.constructorid\r\n"
			+ "		where position = 1\r\n"
			+ "		group by name_prefix)\r\n"
			+ "\r\n"
			+ "select sub.name_prefix, CAST(COALESCE(titles,0) AS INTEGER) as titles, CAST(wins AS INTEGER), CAST(races AS INTEGER) from sub2\r\n"
			+ "right join sub on sub2.name_prefix = sub.name_prefix", nativeQuery = true)
	List<Object[]> findTitlesWinsRaces();
}
