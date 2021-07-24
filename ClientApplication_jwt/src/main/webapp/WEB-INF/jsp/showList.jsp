<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
    <title>Show Employees</title>
</head>
<body>

<h3 style="color: red;">Show All Employees</h3>
<ul>
    <c:forEach var="fruitList" items="${fruitArray}">
        <li>${fruitList}</li>
    </c:forEach>
</ul>
</body>
</html>