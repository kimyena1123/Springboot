<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
</head>
<body>
	<h1>즐겨찾기 추가하기</h1>
	
	<div class = "siteInput">
		<label>제목</label><br />
		<input type="text" name="name" id="name"><br />
		
		<label>주소</label><br />
		<input type="text" name="url" id="url">
		<button type="button" id="checkUrl">중복확인</button><br />
		<div id="checkUrlText"></div>
		
		<button type="submit" id="addBtn">추가</button>
	</div>
	
	
	<script>
		$(document).ready(function(){
			
			$("#addBtn").on("click", function(){
				let site_name = $("#name").val();
				let site_url = $("#url").val();
				
				if(site_name == "" || site_url == ""){
					alert("내용을 입력하시오");
					return;
				}
				
				//https or http
				if(!url.startWith("http://")|| !url.startWith("https://")){
					alert("주소 형식이 잘못되었습니다");
					return;
				}
				
				$.ajax({
					type: "get",
					url: "/ajax/site/create",
					data:{
						"name": site_name,
						"url": site_url,
					},
					success:function(res){
						if(res.result == "true"){
							location.href="/ajax/site/list";
						}else{
							alert('저장 실패');
						}
					},
					error:function(err){
						alert("에러 발생");
					}
				})//ajax
			})//addbtn
			
			$("#checkUrl").on("click", function(){
				let url = $("#url").val();
				
				if(url == ""){
					alert("url 입력해주세요");
					return;
				}
				
				$.ajax({
					type: "post",
					url: "/ajax/site/checkUrl",
					data: {
						"url" : url,
					},
					success:function(res){
						if(res.check){
							//true이면 중복
							$("#checkUrlText").text("중복된 url입니다.");
							$("#checkUrlText").css("color","red");
						}else{
							$("#checkUrlText").text("사용 가능한 url입니다");
							$("#checkUrlText").css("color","red");
						}
					},
					error:function(err){
						alert("error");
					}
				})
			})
			
		})
	</script>
</body>
</html>