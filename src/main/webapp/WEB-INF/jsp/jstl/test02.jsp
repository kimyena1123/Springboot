<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test02</title>
</head>
<style>
	table{
	width: 400px;
	text-align: center;
	}
	th{
		border-top: 1px solid black;
		border-bottom: 1px solid black;
	}
	td{
		border-bottom: 1px solid black;
	}
</style>
<body>
	<h1>TOP5</h1>
	
	<table>
		<thead>
			<tr>
				<th>순위</th>
				<th>제목</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="music" items="${musics }" varStatus="status">
			<tr>
				<td>${status.index }</td>
				<td>${music }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<br><br><br>
	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>전화번호</th>
				<th>등급</th>
				<th>포인트</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="member" items="${membership }" varStatus="status">
			<tr>
				<td>${member.name}</td>
				<td>${member.phoneNumber }</td>
				
				<c:choose>
					<c:when test="${member.grade eq 'VIP' }">
						<td style="color:red"> ${member.grade }</td>
					</c:when>
					<c:when test="${member.grade eq 'GOLD' }">
						<td style="color:yellow"> ${member.grade }</td>
					</c:when>
					<c:otherwise>
						<td> ${member.grade }</td>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${member.point >= 5000 }">
						<td style="color:blue">${member.point }P</td>
					</c:when>
					<c:otherwise>
						<td>${member.point }P</td>
					</c:otherwise>
				</c:choose>

			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>