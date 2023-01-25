<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl Test</title>
</head>
<body>
	<h1>JSTL 변수</h1>
	<c:set var="number1" value="36" />
	<c:set var="number2" value="3" />
	
	<b>첫번째 숫자 : ${number1 }</b>
	<b>두번째 숫자 : ${number2 }</b>
	
	<h1>JSTL core 연산</h1>
	<b>더하기 : ${number1 + number2}</b><br/>
	<b>빼기: ${number1 - number2 }</b><br/>
	<b>곱하기 : ${number1 * number2 }</b><br/>
	<b>나누기 : ${number1 / number2 }</b><br/>
	
	<h1>Core out</h1>
	<c:out value="<title>core out</title>" />
	
	<c:set var="average" value ="${ (number1 + number2) / 2 }" />
	
	<c:if test="${average >= 10 }">
		<h1>평균: <c:out value="${average }" /></h1>
	</c:if>
	<c:if test="${average < 10 }" >
		<h3><c:out value="${average }" /></h3>
	</c:if>
	
	<c:if test= "${number1 * number2 > 100 }">
		<c:out value="<script>alert('너무 큰 수입니다')</script>" escapeXml="false"/>
	</c:if>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>