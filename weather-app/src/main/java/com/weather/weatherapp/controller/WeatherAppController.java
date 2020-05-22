package com.weather.weatherapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.weather.weatherapp.service.WeatherAppService;

@RestController
@EnableDiscoveryClient
@EnableCircuitBreaker
public class WeatherAppController {
	
	@Autowired
	private WeatherAppService weatherService;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@GetMapping("/current/weather")
	public String getWeather() {
		return "The surrent Weather is "+weatherService.getWeather();
	}
}
