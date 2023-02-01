<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 목록 list</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/ajax/booking/booking.css" type="text/css">

</head>
<body>
	<div class="container">
	<jsp:include page="header.jsp" />
	<jsp:include page="nav.jsp" />

		<section>
			<div class="text">예약 목록 보기</div>
			<table>
				<thead>
					<tr>
						<th>이름</th>
						<th>예약날짜</th>
						<th>숙박일수</th>
						<th>숙박인원</th>
						<th>전화번호</th>
						<th>예약상태</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="booking" items="${bookingList }">
					<tr>
						<td>${booking.name }</td>
						<td>${booking.date}</td>
						<td>${booking.day}</td>
						<td>${booking.headcount}</td>
						<td>${booking.phoneNumber}</td>
						<td>${booking.state}</td>
						<td><button type="button" class="delBtn" data-del-id="${booking.id }">삭제</button></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
		
		<jsp:include page="footer.jsp" />
	</div>
	
	<script>
		$(document).ready(function(){
			$(".delBtn").on("click", function(){
				let delId = $(this).data("delId");
				
				$.ajax({
					type: "post",
					url: "/ajax/booking/deleteById",
					data: {
						"id": delId, // 내가 삭제하고픈 행의 id
					},
					success:function(res){
						//true이면 delete 성공
						//false이면 delete 실패
						if(res.delresult){
							location.reload();
						}else{
							alert("삭제 실패. 다시 시도해주세요");
						}
					},
					error:function(err){
						alert('error');
					}
				})
			})
		})
	</script>
</body>
</html>