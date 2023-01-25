<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test03</title>
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
</head>
<body>
	<h1>1. JSTL Formatter 숫자 비율</h1>
	
	<table>
		<thead>
			<tr>
				<th>기호</th>
				<th>득표수</th>
				<th>득표율</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="user" items="${candidates }" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td><fmt:formatNumber value="${user}"/></td>
				<td><fmt:formatNumber value="${user /1000000}" type="percent"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<h1>2. JSTL Formatter 통화, 날짜</h1>
	
	<table>
		<thead>
			<tr>
				<th>사용자</th>
				<th>가격</th>
				<th>사용날짜</th>
				<th>할부</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="card" items="${cardBills }" varStatus="status">
		<fmt:parseDate value="${card.date }" pattern="yyyy년-MM-dd" var = "date"/>
			<tr>
				<td>${card.store }</td>
				<td><fmt:formatNumber value="${card.pay}" type="currency" /></td>
				<td><fmt:formatDate value="${date }" pattern="yyyy년 M월 d일" /></td>
				<td>${card.installment }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	
	
</body>
</html>