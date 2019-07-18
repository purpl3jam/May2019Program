package com.mastek.training.hrapp.apis;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

// Create the Jersey server configuration class
@Component
public class APIConfig extends ResourceConfig {
	
	public APIConfig() {
		// Register each service class in ResourceConfig
		register(EmployeeService.class);
	}

}
