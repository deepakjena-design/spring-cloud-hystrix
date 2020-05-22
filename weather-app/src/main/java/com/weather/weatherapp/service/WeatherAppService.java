package com.weather.weatherapp.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class WeatherAppService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="weatherError")
	public String getWeather() {
		return restTemplate.getForEntity("http://weather-service/weather", String.class).getBody();
	}
	
	public String weatherError() {
		return "service not available currently";
	}

}
