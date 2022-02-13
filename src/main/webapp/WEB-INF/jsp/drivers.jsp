<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html lang="en">

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Drivers</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Drivers</h1>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Password</th>
        </tr>
        <c:forEach  items="${drivers}" var ="driver">
            <tr>
                <td>${driver.id}</td>
                <td>${driver.username}</td>
                <td>${driver.password}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>