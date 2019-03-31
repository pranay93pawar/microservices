package com.pawar.microservices.limitsservice.endpoints;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import com.pawar.microservices.limitsservice.model.CustomHealth;

@Component
@Endpoint(id = "custom-health")
public class CustomHealthEndPoint {

	@ReadOperation
	public CustomHealth health() {
		Map<String, Object> details = new LinkedHashMap<>();
		details.put("CustomHealthStatus", "Everything looks good");
		CustomHealth health = new CustomHealth();
		
		health.setHealthDetails(details);
		
		return health;
	}
	
	@ReadOperation
	public String customEndPointByName(@Selector String name) {
		return "custom-end-point";
	}
	
	@WriteOperation
	public void writeOperation(@Selector String name) {
		
	}
	
	@DeleteOperation
	public void deleteOperation(@Selector String name) {
		
	}
	
}
