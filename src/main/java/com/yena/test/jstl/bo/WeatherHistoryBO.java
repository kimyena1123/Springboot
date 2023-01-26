package com.yena.test.jstl.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.yena.test.jstl.dao.WeatherHistoryDAO;
import com.yena.test.jstl.model.WeatherHistory;

@Service
public class WeatherHistoryBO {
	@Autowired
	private WeatherHistoryDAO weatherHistoryDAO;

	//READ (select) - 모든 데이터 조회
	public List<WeatherHistory> getWeatherHistory(){
		List<WeatherHistory> weather = weatherHistoryDAO.ReadWeatherHistory();
		
		return weather;
	}
	
	//CREATE (insert)
	public int createWeatherHistoryByObject(WeatherHistory weather) {
		
		return weatherHistoryDAO.createWeatherHistoryByObject(weather);
	}
	
	public int createWeatherHistory(
			String date
			,String weather
			,double temperatures
			,double precipitaion
			,String microDust
			,double windSpeed) {
		return weatherHistoryDAO.createWeatherHistory(date, weather, temperatures, precipitaion, microDust, windSpeed);
	}
}
