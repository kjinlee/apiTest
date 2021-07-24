<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>청과물 가격 조회페이지</title>
</head>
<body>
<h3>청과물 가격 조회</h3>
<form action="http://localhost:8080/oauth/authorize"
           method="get">
    <input type="hidden" name="response_type" value="code" />
    <input type="hidden" name="client_id" value="client" /><br/>
    <input type="hidden" name="redirect_uri" value="http://localhost:8090/showList" />
    <input type="hidden" name="scope" value="read" /><br/>

    <input type="SUBMIT" value="조회하기" />
</form>
</body>
</html>