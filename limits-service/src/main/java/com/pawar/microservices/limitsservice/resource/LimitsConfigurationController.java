package com.pawar.microservices.limitsservice.resource;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pawar.microservices.limitsservice.configuration.Configuration;
import com.pawar.microservices.limitsservice.configuration.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retriveLimitsFromConfiguration() {
		
		int maximum = configuration.getMaximum();
		int minimum = configuration.getMinimum();
		
		logger.info(" maximum : {}, minimum : {}", Arrays.asList(maximum, minimum));
		
		return new LimitConfiguration(maximum, minimum);
	}
}
