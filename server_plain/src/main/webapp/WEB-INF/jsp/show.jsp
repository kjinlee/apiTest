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
	<h3 style="color: blue;">청과물 숍에 오신걸 환영합니다!</h3>
		<table style="text-align: center;">
			<thead>
				<tr>
					<td>구분</td>
					<td>이름</td>
					<td>조회</td>
					<td>가격</td>
				</tr>
			<tbody>
				<tr>
					<td><select name="category" id="category">
							<option value="과일">과일</option>
							<option value="채소">채소</option>
					</select></td>
					<td><input type="text" name="name" id="name" /></td>

					<td><input type="button" value="조회" onclick="findPrice();"/></td>
					<td><span id="price"></span></td>
			</tbody>
		</table>
	
	 <!-- jQuery 스크립트 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
	
	
	function findPrice(){
	var category = $("#category").val();
	var name = $("#name").val();
	console.log(category);
	console.log(name);
		$.ajax({
			url : '/get',
			type : 'get',
			data : {
				"category" : category,
				"name" : name
			},
			success : function(price) {
				console.log(price);
				$('#price').text(price); 
			}
		
		})
	}
	
	
	</script>

	

</body>
</html>