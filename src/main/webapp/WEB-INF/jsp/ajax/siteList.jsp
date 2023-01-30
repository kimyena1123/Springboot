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
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<style>
	table{
		text-align: center;
		width: 500px;
	}
	th, td{
		border-bottom: 1px solid black;
	}
	
</style>
</head>
<body>
	<h1>즐겨찾기 목록</h1>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>No.</th>
				<th>이름</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="site" items="${siteList }" varStatus="status">
			<tr>
				<td class="siteId">${site.id }</td>
				<td>${status.count}</td>
				<td>${site.name }</td>
				<td>${site.url }</td>
				<td><button type="button" class="delBtn">삭제${status.count }</button></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="addList">
		<a href="/ajax/site/input">추가하기</a>	
	</div>
	
	<script>
		$(document).ready(function(){
			
			//id는 하나만 관리하기 위한 것이기 때문에 id로 접근하면 안되고
			//class로 선언해야 모든 삭제 버튼에 접근 가능하다.
			$(".delBtn").on("click", function(){
				//let siteId = $("td:first").text();
				 
				//let siteId = $(".siteId").text();

			
				
				$.ajax({
					type:"get",
					url: "/ajax/site/deleteById",
					data:{
						"id": siteId
					}
				})
			})
		})
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>