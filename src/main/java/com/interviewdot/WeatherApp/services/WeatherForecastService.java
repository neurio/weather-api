package com.interviewdot.WeatherApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.WeatherForecast;
import com.project.repository.WeatherForecastRepository;

@Service
public class WeatherForecastService {

	
	@Autowired
	private WeatherForecastRepository weatherForecastRepository;
	
	public void create(WeatherForecast weatherForecast) {
		weatherForecastRepository.save(weatherForecast);
	}
	
	public WeatherForecast read(Long id) {
		return weatherForecastRepository.findById(id).get();
	}
	public List<WeatherForecast> readAll(){
		return weatherForecastRepository.findAll();
	}
	
	public void update(Long id,WeatherForecast weatherForecast)
	{
		WeatherForecast weatherForecastModel = weatherForecastRepository.getOne(id);
		if(weatherForecastModel!=null)
		{
			weatherForecastRepository.saveAndFlush(weatherForecast);
		}
			
	}
	
	public void delete(Long id)
	{
		weatherForecastRepository.deleteById(id);
	}
	
	public void deleteBycity(String cityName) {
		weatherForecastRepository.deleteBycity(cityName);
	}
	
	public List<WeatherForecast> readbyCityName(String cityName) {
		return weatherForecastRepository.getWeatherForecastbyCityName(cityName);
	}
	
}
