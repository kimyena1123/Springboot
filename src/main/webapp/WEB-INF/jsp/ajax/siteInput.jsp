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
	<a href="/ajax/site/list">즐겨찾기 보기</a>
	
	
	<script>
		$(document).ready(function(){
			
			//중복 체크 여부 확인 변수
			let isChecked = false;
			
			//url 중복 상태 저장 변수
			let isDuplicate = true;
			
			//url input창에서 입력할 때마다 진행되는 함수
			$("#url").on("input", function(){
				//중복체크 여부를 모두 취소한다.
				isChecked = false;
				isDuplicate = true;
				$("#checkUrlText").text("중복검사 해주세요");
				$("#checkUrlText").css("color","red");
			});
			
			
			//중복 검사 여부 함수
			$("#checkUrl").on("click", function(){
				
				let url = $("#url").val();
				
				//url input 값이 빈 값이라면
				if(url == ""){
					alert("url 입력해주세요");
					return;
				}
				
				//https or http
				//https 또는 http로 시작하는 url 주소가 아니라면
				//유효한 url 주소 작성하라는 alert 띄우기
				if(!(url.startsWith("https://") || url.startsWith("http://"))){
					alert("유효한 url 주소가 아닙니다.");
					return;
				}
							
				$.ajax({
					type: "get",
					url: "/ajax/site/checkUrl",
					data: {
						"url" : url,
					},
					success:function(res){
						isChecked = true;
						
						if(res.check){
							//true이면 중복
							$("#checkUrlText").text("중복된 url입니다.");
							$("#checkUrlText").css("color","red");
							isDuplicate = true;
						}else{
							//false이면 중복 X
							$("#checkUrlText").text("사용 가능한 url입니다");
							$("#checkUrlText").css("color","skyblue");
							isDuplicate = false;
						}
					},
					error:function(err){
						alert("error");
					}
				})//ajax end
			})//checkUrl end
			
			
			
			$("#addBtn").on("click", function(){
				let site_name = $("#name").val();
				let site_url = $("#url").val();
				
				//input 값이 빈 값이라면
				if(site_name == "" || site_url == ""){
					alert("내용을 입력하시오");
					return;
				}
				
				//https or http
				//https 또는 http로 시작하는 url 주소가 아니라면
				//유효한 url 주소 작성하라는 alert 띄우기
				if(!(site_url.startsWith("https://") || site_url.startsWith("http://"))){
					alert("유효한 url 주소가 아닙니다.");
					return;
				}
				
				//url 중복 체크 했는지 유효성 검사
				if(!isChecked){
					alert('중복검사를 해주세요');
					return;
				}
				
				//url이 중복되었는지 유효성 검사
				if(isDuplicate){
					alert('url 중복되었습니다.');
					return;
				}
				
				//어차피 위에서 if문으로 걸러냈기 때문에 else을 쓰지 않아도 된다.
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
				})//ajax end
			})//addbtn end
		})
	</script>
</body>
</html>