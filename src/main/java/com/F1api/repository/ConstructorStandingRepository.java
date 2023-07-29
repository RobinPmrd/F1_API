package com.F1api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.F1api.model.ConstructorStandingRow;

@Repository
public interface ConstructorStandingRepository extends JpaRepository<ConstructorStandingRow, Integer> {
	
	@Query(value = "select ROW_NUMBER() OVER(order by sum(re.points) desc) as position, sum(re.points) as points, c.name, c.nationality  from results re\r\n"
			+ "join races r on r.raceid = re.raceid\r\n"
			+ "join constructors c on c.constructorid = re.constructorid\r\n"
			+ "where r.year = :season\r\n"
			+ "group by (c.constructorid, c.name, c.nationality)", nativeQuery = true)
	List<ConstructorStandingRow> findConstructorStanding(int season);
	
	@Query(value = "select ROW_NUMBER() OVER(order by sum(re.points) desc) as position, sum(re.points) as points, c.name, c.nationality  from results re\r\n"
			+ "join races r on r.raceid = re.raceid\r\n"
			+ "join constructors c on c.constructorid = re.constructorid\r\n"
			+ "where r.year = :season and r.round <= (select round from races\r\n"
			+ "								   		  where year = :season and name like :race_name)\r\n"
			+ "group by (c.constructorid, c.name, c.nationality)", nativeQuery = true)
	List<ConstructorStandingRow> findConstructorStanding(int season, String race_name);
}
