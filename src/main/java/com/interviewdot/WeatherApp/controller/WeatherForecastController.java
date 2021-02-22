package com.interviewdot.WeatherApp.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.WeatherForecast;
import com.project.service.WeatherForecastService;

@RestController
@RequestMapping(value = "weatherforecast")
public class WeatherForecastController {

	@Autowired
	private WeatherForecastService weatherForecastService;
	
	
	@GetMapping(value = "/read/all")
	public List<WeatherForecast> readAll(){
		return weatherForecastService.readAll();
	}
	
	@GetMapping(value="/read/{id}")
	public WeatherForecast readbyId(@PathVariable(value = "id")Long id) {
		return weatherForecastService.read(id);
	}
	
	@GetMapping(value = "/read/city/{cityName}")
	public List<WeatherForecast> readbyCityName(@PathVariable(value = "cityName") String cityName)
	{
		return  weatherForecastService.readbyCityName(cityName);
	}
	
	@PostMapping(value = "/create")
	public void create(@RequestBody WeatherForecast weatherForecast) {
		weatherForecastService.create(weatherForecast);
	}
	
	
	@PutMapping(value = "/update/{id}")
	public void update ( @PathVariable(value = "id") Long id,@RequestBody WeatherForecast weatherForecast)
	{
		weatherForecastService.update(id, weatherForecast);
	}
	
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		weatherForecastService.delete(id);
	}
	
	@Transactional
	@DeleteMapping(value = "/delete/city/{cityName}")
	public void deletebyid(@PathVariable(value = "cityName") String cityName) {
		weatherForecastService.deleteBycity(cityName);
	}
		
	
	

	
	
}
