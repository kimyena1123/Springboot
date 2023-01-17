<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>seller table select</title>
<style>
	*{
		magin: 0;
		padding: 0;
	}
	img{
		width: 200px;
		height: 200px;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<td><h2>판매자 정보</h2></td>
		</tr>
		<tr>
			<td><img src ="${seller. profileImgae}"></td>
		</tr>
		<tr>
			<td>${ seller.nickname }</td>
		</tr>
		<tr>
			<td>${ seller.temperature }</td>
		</tr>
	</table>

</body>
</html>