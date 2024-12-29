package com.F1api.service;

import com.F1api.model.Driver;
import com.F1api.model.DriverInfo;
import com.F1api.repository.DriverRepository;
import com.F1api.repository.DriverRepository.DriverTeamMate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DriverService {

	@Autowired
	DriverRepository driver_repository;
	
	public List<Driver> getDrivers() {
		List<Driver> drivers = driver_repository.findAll();
		List<DriverInfo> drivers_info = driver_repository.findTitlesWinsRaces();
		drivers.forEach(d -> {
			DriverInfo info = drivers_info.stream().filter(i -> i.getId() == d.getId()).findFirst().get();
			d.setGrandprix(info.getRaces());
			d.setPoles(info.getPoles());
			d.setWins(info.getWins());
			d.setTitles(info.getTitles());
			d.setPodiums(info.getPodiums());
			d.setHighestRacePosition(info.getBestraceposition());
			d.setHighestGridPosition(info.getBestgridposition());
			d.setSeasons(info.getSeasons());
		});
		return drivers;
	}
	
	public Driver getDriver(int id) {
		return driver_repository.findById(id).get();
	}
	
	public List<DriverTeamMate> getTeamMates(int driver_id) {
		return driver_repository.findTeamMates(driver_id);
	}
	
	public byte[] getDriverPicture(String driver_ref) throws IOException {
		Path path = Paths.get("src/main/resources/static/images/drivers/" + driver_ref + ".png");
        if (Files.exists(path)) return Files.readAllBytes(path);
		return Files.readAllBytes(Paths.get("src/main/resources/static/images/drivers/unknown.jpg"));
	}
}

