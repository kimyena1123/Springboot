package com.yena.test.jstl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.yena.test.jstl.model.WeatherHistory;

@Repository
public interface WeatherHistoryDAO {

	//READ (select)
	public List<WeatherHistory> ReadWeatherHistory();
	
	//CREATE (insert)
	public int createWeatherHistoryByObject(WeatherHistory weather);

	public int createWeatherHistory(
	@Param("date") String date
	,@Param("weather") String weather
	,@Param("temperatures") double temperatures
	,@Param("precipitaion") double precipitaion
	,@Param("microDust") String microDust
	,@Param("windSpeed") double windSpeed);
}
