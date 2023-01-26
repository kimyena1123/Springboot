<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기상청 날짜 입력</title>
<link rel="stylesheet" href="/jstl/weather/input.css" type="text/css">
</head>
<body>

	<div class="container2">
	
	<jsp:include page="AllAside.jsp" />

		<div class="input">


			<h2>날씨 입력</h2>

			<form method = "GET" action ="/jstl/create">
				<label>날짜</label>
				<input type="text" name="date">

				<label>날씨</label>
				<select name="weather">
					<option value="맑음">맑음</option>
					<option value="구름조금">구름조금</option>
					<option value="흐림">흐림</option>
					<option value="비">비</option>
				</select>

				<label>미세먼지</label>
				<select name="microDust">
					<option value="좋음">좋음</option>
					<option value="좋음">보통</option>
					<option value="나쁨">나쁨</option>
				</select>

				<br>

				<label>기온</label>
				<input type="text" name="temperatures">

				<label>강수량</label>
				<input type="text" name="precipitaion">

				<label>풍속</label>
				<input type="text" name="windSpeed">
				<br>

				<button type="submit">저장</button>
			</form>
		</div>
	</div>



















</body>
</html>