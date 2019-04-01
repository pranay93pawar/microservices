package com.pawar.microservices.limitsservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pawar.microservices.limitsservice.impl.SampleInterface;
import com.pawar.microservices.limitsservice.model.City;
import com.pawar.microservices.limitsservice.repository.CitiesRepository;

import javax.annotation.Resource;

@Service
public class CityService {

	@Autowired
	private CitiesRepository citiesRepository;
	
	@Autowired
	@Resource(name = "firstRepository")
	private SampleInterface sampleInterface;
	
	@Autowired
	@Qualifier("secondRepository")
	private SampleInterface interFaceSample;
	
	public List<City> findAll() {
		
		List<City> cityList = (List<City>) citiesRepository.findAll();
		
		return cityList;
	}
	
}
