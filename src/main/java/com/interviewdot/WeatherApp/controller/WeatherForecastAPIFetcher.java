package com.interviewdot.WeatherApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.project.model.WeatherForecast;
import com.project.onlineintegration.WeatherForecastAPI;
import com.project.service.WeatherForecastService;



@RestController
@RequestMapping(value = "fetch")
public class WeatherForecastAPIFetcher {

	@Autowired 
	private WeatherForecastService weatherForecastService;
	

	
	@GetMapping(value = "/{cityName}")
	public String fetchData(@PathVariable(value = "cityName") String cityName) throws UnirestException {
		
		try {
			 WeatherForecastAPI api = new WeatherForecastAPI();
		     ArrayList<HashMap<String, String>> weatherForecastValue= api.fetchDatabyCity(cityName);
		     
		     for(int i=0; i<weatherForecastValue.size(); i++) {
		    	 HashMap<String, String> val = weatherForecastValue.get(i);
		    	 WeatherForecast weatherForecastModel = new WeatherForecast(
		    			 val.get("date"),val.get("day"),val.get("icon"),val.get("description"),
		    			 val.get("status"),Float.valueOf(val.get("degree")),Float.valueOf(val.get("min")),
		    			 Float.valueOf(val.get("max")),Float.valueOf(val.get("night")),
		    			 Float.valueOf(val.get("humidity")),cityName
		    			  );
		    			 
		    	weatherForecastService.create(weatherForecastModel);
		    	
		}
		     
		     
		     }catch(Exception e){
		    	 return "Hata ! Bir sorun oluştu.";
		}
		return cityName.toUpperCase()+" hava durumu verileri tabloya basariyla kaydedildi";
		
	    
	     }

	


	     
	}
	

