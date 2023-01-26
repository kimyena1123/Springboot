<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review</title>
<link rel="stylesheet" href="/jstl/store/store.css" type="text/css">
</head>
<body>
 
 	<div class="container">
 		<jsp:include page="header.jsp" />
 		
 		<section>
	 		<c:forEach var="review" items="${reviewList }">
	 		
				<div class="list">
					<div class="review_detail">
						<span><b>${review.userName }</b></span>
						
						<c:set var="point" value="${review.point }" />
						<c:forEach begin="1" end="${review.point }">
							<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYsxcxmvYVzHva9NNm9g98FKA0z2XN86NAuw&usqp=CAU" />
						</c:forEach>
						
						<c:choose>
							<c:when test="${fn:contains(point, '.5')}" >
								<img src="http://marondal.com/material/images/dulumary/web/jstl/star_half.png" >
							</c:when>
						</c:choose>
						<span>${review.point }</span>
					</div>
					
					<fmt:formatDate var="date" value="${review.createdAt }" pattern="yyyy년 MM월 dd일" />
					<div>${date }</div>
					
					<span>${review.review }</span>
					<span><div class="menu"><span>${review.menu }</span></div></span>
				</div>
			</c:forEach> 		
 		</section>
 		<footer>footers</footer>
 	</div>
	

</body>
</html>