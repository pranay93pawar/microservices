package com.pawar.microservices.limitsservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pawar.microservices.limitsservice.model.City;
import com.pawar.microservices.limitsservice.service.CityService;

@RestController
public class CityResource {

	@Autowired
	private CityService cityService;
	
	
	@GetMapping("/all-cities")
	public List<City> getAllCities() {
		
		return (List<City>) cityService.findAll();
		
	}
 }
