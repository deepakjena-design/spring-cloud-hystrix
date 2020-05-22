package com.weather.weatherservice.controller;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
public class WeatherServiceController {
	
	private String[] weather = new String[] {"Rainy","Sunny","Windy","Cold"};
	
	@GetMapping("/weather")
	public String getWeather() {
		int rand = ThreadLocalRandom.current().nextInt(0, 4);
		return weather[rand];
	}

}
