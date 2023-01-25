<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>종합문제1</title>
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}
	.container{
		width: 100vw;
		height: 100vh;
		display: flex;
	}
	aside{
		width: 12%;
		background-color: #6495EC;
		color: white;
	}
	aside h3{
		text-align: center;
		margin-top: 30px;
	}
	aside ul{
		list-style:none;
		margin-top: 40px;
	}
	aside ul li{
		margin: 20px 0;
		margin-left: 20px;
	}
	aside .logo{
		display: flex;
		flex-deriction: column;
	}
	a{
		color: white;
		text-decoration: none;
		font-weight: 600;
	}
	.content{
		width: 88%;
	}
	.content table{
		width: 90%;
		text-align: center;
		margin-top: 30px;
	}
	th{
		border-top: 1px solid black;
	}
	th, td{
		border-bottom: 1px solid black;
		padding: 10px 0;
	}
</style>
</head>
<body>
	<div class = "container">
		<aside>
			<h3>기상청</h3>
			
			<div class="list">
				<ul>
					<li><a href = "#">날씨</a></li>
					<li><a href = "/jstl/input">날씨입력</a></li>
					<li><a href = "#">테마날씨</a></li>
					<li><a href = "#">관측기후</a></li>
				</ul>
			</div>
		</aside>
		
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
					<td>${info.weather }</td>
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