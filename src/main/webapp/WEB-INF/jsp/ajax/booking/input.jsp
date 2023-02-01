<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp" />
		<jsp:include page="nav.jsp" />
		
		<section>
			<div class="text">예약하기</div>
			<form>
				<label>이름</label><br />
				<input type="text" id="name" name="name"><br />
				
				<label>예약날짜</label><br />
				<input type="text" id="date" name="date"><br />
				
				<label>숙박일수</label><br />
				<input type="text" id="day" name="day"><br />
				
				<label>숙박인원</label><br />
				<input type="text" id="headcount" name="headcount"><br />
				
				<label>전화번호</label>	<br />
				<input type="text" id="phoneNumber" name="phoneNumber"><br />
				
				<button type="submit" id="register">예약하기</button>
				
			</form>
		</section>
		
		<jsp:include page="footer.jsp" />
		
		<script>
			$(document).ready(function(){
				$("#register").on("click", function(){
					let name = $("#name").val();
					let date = $("#date").val();
					let day = $("#day").val();
					let headcount = $("#headcount").val();
					let phoneNumber = $("#phoneNumber").val();
					
					//input value가 빈 값이라면
					if(name == "" || date == "" || day == "" ||
							headcount == "" || phoneNumber == ""){
						alert("내용을 입력해주세요");
						return;
					}
					
					$.ajax({
						type: "get",
						url: "/ajax/booking/create",
						data:{
							"name": name,
							"date": date,
							"day": day,
							"headcount": headcount,
							"phoneNumber": phoneNumber
						},
						success:function(res){
							if(res.result){
								location.href="/ajax/booking/list";
							}else{
								alert("예약 실패. 다시 시도해주세요");
							}
						},
						error:function(err){
							alert("error");
						}
					})
					
					
				})
			})
		</script>
	</div>
</body>
</html>