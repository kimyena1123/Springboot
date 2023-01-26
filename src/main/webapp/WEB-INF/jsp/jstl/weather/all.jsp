<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>종합문제1</title>
<link rel="stylesheet" href="/jstl/weather/weather.css" type="text/css">

</head>
<body>
	<div class = "container">
		<jsp:include page="AllAside.jsp" />
		
		<div class="content">
		<h2>과거 날씨</h2>
		<table>
			<thead>
				<tr>
					<th>날짜</th>
					<th>날씨</th>
					<th>기온</th>
					<th>강수량</th>
					<th>미세먼지</th>
					<th>풍속</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="info" items="${weather }">
				<tr>
					<td>${info.date }</td>
					<c:choose>
						<c:when test="${info.weather == '맑음' }">
							<td><img src="http://marondal.com/material/images/dulumary/web/jstl/sunny.jpg"></td>
						</c:when>
						<c:when test="${info.weather == '구름조금' }">
							<td><img src=" http://marondal.com/material/images/dulumary/web/jstl/partlyCloudy.jpg"></td>
						</c:when>
						<c:when test="${info.weather == '흐림' }">
							<td><img src="http://marondal.com/material/images/dulumary/web/jstl/cloudy.jpg"></td>
						</c:when>
						<c:otherwise>
							<td><img src="http://marondal.com/material/images/dulumary/web/jstl/rainy.jpg"></td>
						</c:otherwise>
					</c:choose>
					
					<td>${info.temperatures }°C</td>
					<td>${info.precipitaion }mm</td>
					<td>${info.microDust }</td>
					<td>${info.windSpeed }km/h</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
			
		</div> <!-- content -->
	</div> <!--  container -->
</body>
</html>