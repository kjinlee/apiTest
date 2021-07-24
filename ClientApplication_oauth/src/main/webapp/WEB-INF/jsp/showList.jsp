<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
    <title>청과물 목록</title>
</head>
<body>

<h3 style="color: red;">청과물 목록</h3>
<ul>
    <c:forEach var="fruitList" items="${fruitList}">
        <li>${fruitList}</li>
    </c:forEach>
</ul>
</body>
</html>