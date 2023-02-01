<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ajax/booking/main.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
</head>
<body>
    <div id = "container">
        <header>
            <nav>
                <ul>
                    <li><a href="/ajax/booking/main">펜션소개</a></li>
                    <li><a href="#">객실보기</a></li>
                    <li><a href="/ajax/booking/input">예약안내</a></li>
                    <li><a href="/ajax/booking/list">커뮤니티</a></li>
                </ul>
            </nav>
        </header>
    
        <div id = "bigImg">
            <img src = "http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner1.jpg">
        </div>
    
        <div id = "contents">
            <div id = "Div1">
                <div id = "divBox">
                    <p id = "reservation1">실시간</p>
                    <p id = "reservation2">예약하기</p>
                </div>
            </div>

            <div id = "Div2">

                <div id = "checkReservation">
                    <div id = "title">예약확인</div>
                </div>
				
				<div class="check">
					<div class="name">
	                    <label>이름</label>
	                    <input type="text" name="name" id="name" /><br/>
					</div>
            
                    <label>전화번호</label>
                    <input type="text" name="phoneNumber" id="phoneNumber" />
           		</div>
           		
                <div id = "btn">
                    <button type = "submit" id = "DivBtn">조회하기</button>
                </div>
            </div>
            
            <div id = "Div3">
            	<div class="phoneText">
            		예약문의: <br/>
            		010-<br/>
            		000-1111
            	</div>
            </div>
        </div>
    
        <footer>
    		<div class="infoSite">
				제주특별자치도 제주시 애월읍 <br/>
				사업자등록번호: 111-22-258222/농어촌민박사업자지정/대표:000 <br/>
				Copyright 2025 tongnamu All right reserved<br/>
	</div>
        </footer>
    </div>
    
    
    <script>
    
    /*ajax를 위한 jquery 코드*/
    	$(document).ready(function(){
    		$("#DivBtn").on("click", function(){
    			let name = $("#name").val();
    			let phoneNumber = $("#phoneNumber").val();
    			
    			$.ajax({
    				type: "post",
    				url: "/ajax/booking/reservatoinCheck",
    				data:{
    					"name" : name,
    					"phoneNumber": phoneNumber,
    				},
    				success:function(res){
    					console.log('res 확인 >> ', res);
    					//console.log('res[0] 확인 >> ', res[0]);
    				
    					//Booking 클래스만이라면 조회결과가 없을 때 빈값
    					//List<Booking>처럼 리스트 형식이라면 res[0] == "undefined"
    					if(res == ""){
    						alert("조회 결과가 없습니다.");
    						return;
    					}
    					
    					//굳이 else문 없이 표현가능
    					//위에서 return으로 끝내주기 때문이다.
    					
    					//List<Booking>인 경우에 res[0]으로!
   						//console.log('res[0].id >> ', res[0].id);
       					//console.log('res[0].name >> ', res[0].name);
       					console.log('res.id', res.id);
       					console.log('res.name', res.name);
       					
       					/*let name = res[0].name;
       					let date = res[0].date;
       					let day = res[0].day;
       					let headcount = res[0].headcount;
       					let state = res[0].state;*/
       					
       					let name = res.name;
       					let date = res.date;
       					let day = res.day;
       					let headcount = res.headcount;
       					let state = res.state;
       					
   						alert('이름: '+name+
   	    						  '\n날짜: '+date+
   	    						  '\n일수: '+day+
   	    						  '\n인원: '+headcount+
   	    						  '\n상태: '+state);
    				}, //success end
    				error:function(err){
    					alert('조회 error');
    				}//error end
    			}) //ajax end
    		}) //DivBtn end
    	}) // jquery end
    
    
    
    
    
    
    
    
    /***************************************************************/
    /*front-end 시 했던 javascript 코드*/
    
    const user_id = document.querySelector('#user_id');
    const user_pw = document.querySelector('#user_pw');
    const user_name = document.querySelector('#user_name');
    const user_number = document.querySelector('#user_number');
    const user_day = document.querySelector('#user_day');

    const button = document.querySelector('#DivBtn');

    /*button.addEventListener('click', () => {

        if(user_name.checkValidity() === false){
            alert('이름을 입력해주세요');
            return;
        }
        if(user_number.checkValidity() === false){
            alert('전화번호를 입력해주세요');
            return;
        }
        if(user_day.checkValidity() === false){
            alert('날짜를 입력해주세요');
            return;
        }
    })*/

    </script>
</body>
</html>