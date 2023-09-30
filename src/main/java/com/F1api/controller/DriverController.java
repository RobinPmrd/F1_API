package com.F1api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.F1api.model.Driver;
import com.F1api.repository.DriverRepository.DriverTeamMate;
import com.F1api.service.DriverService;


@RestController
@RequestMapping("/drivers")
public class DriverController {
	
	@Autowired
	private DriverService driver_service;

	@GetMapping("")
	@CrossOrigin( origins = "*")
	public List<Driver> getDrivers() {
		return driver_service.getDrivers();
	}
	
	@GetMapping("/teammates/{driver_id}")
	@CrossOrigin( origins = "*")
	public List<DriverTeamMate> getTeamMates(@PathVariable(name = "driver_id") int driver_id) {
		return driver_service.getTeamMates(driver_id);
	}
	
	@GetMapping(value = "/{driver_ref}", produces = MediaType.IMAGE_PNG_VALUE)
	@CrossOrigin( origins = "*")
    public byte[] getImage(@PathVariable("driver_ref") String driver_ref) throws IOException {
        return driver_service.getDriverPicture(driver_ref);
    }
}