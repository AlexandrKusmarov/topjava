<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@taglib uri="http://example.com/functions" prefix="f" %>
<style><%@include file="WEB-INF/css/style.css"%></style>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>
<table class="table_blur">
    <tr>
        <th>DateTime</th>
        <th>Description</th>
        <th>Calories</th>
        <th>Excess</th>
    </tr>
    <tbody>
    <c:forEach var="l" items="${list}">
        <c:if test="${l.isExcess() == true}">
          <td style="color: maroon" >${f:formatLocalDateTime(l.getDateTime(),"yyyy-MM-dd hh:mm")} </td>
          <td style="color: maroon"> ${l.getDescription()}</td>
          <td style="color: maroon"> ${l.getCalories()}</td>
          <td style="color: maroon"> ${l.isExcess()}</td>
        </c:if>

        <c:if test="${l.isExcess() == false}">
        <td style="color: green">${f:formatLocalDateTime(l.getDateTime(),"yyyy-MM-dd hh:mm")}</td>
        <td style="color: green"> ${l.getDescription()}</td>
        <td style="color: green"> ${l.getCalories()}</td>
        <td style="color: green"> ${l.isExcess()}</td>
        </c:if>
        <tr></tr>
    </c:forEach>
    </>
    </tbody>
</table>
</body>
</html>
