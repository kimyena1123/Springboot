<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>seller table select</title>
</head>
<body>
	
	<table border = "1">
		<tr>
			<th>닉네임</th>
			<td>${ seller.nickname }</td>
		</tr>
		<tr>
			<th>온도</th>
			<td>${ seller.temperature }</td>
		</tr>
		<tr>
			<th>프로필 이미지 주소</th>
			<td>${ seller.profileImgae }</td>
		</tr>
	</table>
</body>
</html>