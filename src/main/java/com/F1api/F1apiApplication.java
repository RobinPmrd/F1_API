package com.F1api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.F1api.service.CircuitService;
import com.F1api.service.ConstructorService;
import com.F1api.service.DriverService;
import com.F1api.service.DriverStandingService;
import com.F1api.service.RaceService;

@SpringBootApplication
public class F1apiApplication implements CommandLineRunner{
	
	@Autowired
	private DriverService ds;
	@Autowired
	private RaceService rs;
	@Autowired
	private CircuitService cs;
	@Autowired
	private DriverStandingService dsr;
	@Autowired
	private ConstructorService cts;
	
	public static void main(String[] args) {
		SpringApplication.run(F1apiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
//		List<Driver> drivers = dr.findAll();
//		for (Driver d : drivers) {
//			if (d.getTitles() > 2) System.out.println(d.getForename() + d.getSurname());
//		}
//		List<Circuit> circuits = cs.getCircuits();
//		for (Circuit circuit : circuits) {
//			System.out.println(circuit.getName() + " " + circuit.getRaces());
//		}
//		dsr.getDriverStanding(2023).forEach(row -> System.out.println(row.getDriver().getSurname() + " " + row.getTeam() + " " + row.getPoints()));
//		cts.getConstructors().stream().filter(c -> c.getName().equals("Team Lotus")).forEach(c -> System.out.println(c.getName() + " " + c.getSeasons()));
//		cts.getDriverConstructors(4).forEach(o -> System.out.println(o.getName() + o.getDriverSeasonPeriod()));
//		cts.getDriverConstructors(1).forEach(o -> System.out.println(o.getName() + o.getDriverSeasonPeriod()));
		cts.getDriverConstructors(847).forEach(o -> System.out.println(o.getName() + o.getDriverSeasonPeriod()));
	}
	
}
