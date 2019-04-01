package com.pawar.microservices.limitsservice.repository;

import org.springframework.stereotype.Component;

import com.pawar.microservices.limitsservice.impl.SampleInterface;

@Component(value = "secondRepository")
public class SecondRepository implements SampleInterface {

	public SecondRepository() {
		
	}
	
}
