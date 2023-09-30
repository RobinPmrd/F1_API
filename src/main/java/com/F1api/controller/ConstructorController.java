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

import com.F1api.model.Constructor;
import com.F1api.service.ConstructorService;

@RestController
@RequestMapping("/constructors")
public class ConstructorController {

	@Autowired
	private ConstructorService constructor_service;
	
	@GetMapping("")
	@CrossOrigin("*")
	public List<Constructor> getConstructors() {
		return constructor_service.getConstructors();
	}
	
	@GetMapping("/{driver_id}")
	@CrossOrigin("*")
	public List<Constructor> getDrivverConstructors(@PathVariable(name = "driver_id") int driver_id) {
		return constructor_service.getDriverConstructors(driver_id);
	}
	
	@GetMapping(value = "/{driver_ref}", produces = MediaType.IMAGE_PNG_VALUE)
	@CrossOrigin( origins = "*")
    public byte[] getImage(@PathVariable("driver_ref") String driver_ref) throws IOException {
        return constructor_service.getTeamLogo(driver_ref);
    }
}
