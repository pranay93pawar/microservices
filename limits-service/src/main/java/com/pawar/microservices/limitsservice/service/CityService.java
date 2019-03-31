package com.pawar.microservices.limitsservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawar.microservices.limitsservice.model.City;
import com.pawar.microservices.limitsservice.repository.CitiesRepository;

@Service
public class CityService {

	@Autowired
	private CitiesRepository citiesRepository;
	
	public List<City> findAll() {
		
		List<City> cityList = (List<City>) citiesRepository.findAll();
		
		return cityList;
	}
	
}
