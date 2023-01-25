package com.yena.test.jstl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yena.test.jstl.bo.WeatherHistoryBO;
import com.yena.test.jstl.model.WeatherHistory;

@RequestMapping("/jstl")
@Controller
public class AllController {
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	@GetMapping("/show")
	//READ (select)
	public String ReadWeatherHistory(Model model){
		List<WeatherHistory> weatherList = weatherHistoryBO.getWeatherHistory();
		
		
		model.addAttribute("weather", weatherList);
		return "jstl/all";
	}
	
	//input 화면 보여주기
	@GetMapping("/input")
	public String weatherInput() {
		return "jstl/AllInput";
	}
	
	@GetMapping("/create")
	//CREATE (insert)
	public String createdWeatherHistory(
			@RequestParam("date") String date
			,@RequestParam("weather") String weather
			,@RequestParam("temperatures") double temperatures
			,@RequestParam("precipitaion") double precipitaion
			,@RequestParam("microDust") String microDust
			,@RequestParam("windSpeed") double windSpeed
			,Model model) {
		
		WeatherHistory weatherHistory = new WeatherHistory();
		weatherHistory.setDate(date);
		weatherHistory.setWeather(weather);
		weatherHistory.setTemperatures(temperatures);
		weatherHistory.setPrecipitaion(precipitaion);
		weatherHistory.setMicroDust(microDust);
		weatherHistory.setWindSpeed(windSpeed);
		
		weatherHistoryBO.createWeatherHistory(date, weather, temperatures, precipitaion, microDust, windSpeed);
		
		List<WeatherHistory> weatherList = weatherHistoryBO.getWeatherHistory();
		model.addAttribute("weather", weatherList);
		
		return "jstl/all";
	}
}
