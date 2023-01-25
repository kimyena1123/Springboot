<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 함수 라이브러리 문제</title>
<style>
	table{
		width: 1100px;
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
</head>
<body>

	<h1>회원 정보 리스트</h1>
	<table>
		<thead>
			<tr>
				<th>No</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>국적</th>
				<th>이메일</th>
				<th>자기소개</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach var="member" items="${members }" varStatus="status">
			<c:set var="nation" value="${member.nationality }" />
			<c:set var="number" value="${member.phoneNumber }" />
 			<c:set var="introduce" value="${member.introduce }" />
 			<tr>
				<td>${status.count}</td>
				<td>${member.name }</td>
				<c:choose>
					<c:when test="${fn:startsWith(number, '010')}" >
						<td>${member.phoneNumber }</td>
					</c:when>
					<c:otherwise>
						<td>유효하지 않은 번호</td>
					</c:otherwise>
				</c:choose>
				<td>${fn:replace(nation, "시대", "-") }</td>
				<td><b>${fn:split(member.email, "@")[0] }</b>@${fn:split(member.email,"@")[1] }</td>
				
				<c:choose>
					<c:when test="${fn:length(introduce) >= 15 }" > <!-- 자기소개가 15자 이상이면 -->
						<!-- 15자 이상부터를 ...으로 대체 -->
						<c:set var="head" value="${fn:substring(introduce, 0, 15) }" />
						
						<td>${head }...</td>
					</c:when>
					
					<c:otherwise>
						<td>${member.introduce }</td>
					</c:otherwise>
				</c:choose>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>






































</body>
</html>