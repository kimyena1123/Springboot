<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jstl/store/store.css" type="text/css">
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp" />
		
		<section>
			<p>우리동네 가게</p>
			<c:forEach var="store" items="${storeList }">
			<a href = "/store/review?storeId=${store.id }">
				<div class="list">
					<div><span>${store.id}. ${store.name }<span></div>
					<div><span>전화번호: ${store.phoneNumber }<span></div>
					<div><span>주소: ${store.address }<span></div>
				</div>
			</a>
			</c:forEach>
		</section>
		
		<footer>
			<h4>(주)우와한 형제</h4>
			<div>고객센터: 1500-1500</div>
		</footer>
	</div>
</body>
</html>