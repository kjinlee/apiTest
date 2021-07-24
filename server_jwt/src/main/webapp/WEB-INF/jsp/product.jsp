<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>청과물 가격 조회</title>
</head>
<body>
	<h3 style="color: red;">청과물 숍에 오신걸 환영합니다!</h3>
	<form action="/token" method="get">
		<div>
			이름 : <input type="text" name="response_type" value="${fruit.id }" />
		</div>

		<input type="SUBMIT" value="Get Employee info" />
	</form>
</body>
</html>