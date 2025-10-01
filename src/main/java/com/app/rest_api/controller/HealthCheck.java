package com.app.rest_api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://journally-ten.vercel.app/")
public class HealthCheck {

	@GetMapping("/health-check")
	public String healthCheck() {
		return "OK";
	}
	
	
	
}
