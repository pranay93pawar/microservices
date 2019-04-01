package com.pawar.microservices.limitsservice.repository;

import org.springframework.stereotype.Component;

import com.pawar.microservices.limitsservice.impl.SampleInterface;

@Component(value = "firstRepository")
public class FirstRepository implements SampleInterface{

	public FirstRepository() {
		
	}
	
}
