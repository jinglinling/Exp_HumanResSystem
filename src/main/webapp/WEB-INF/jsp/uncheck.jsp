<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31472
  Date: 2023/12/26
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="it" items="${requestScope.get('uncheck')}">
    <tr>
        <td>标准编号：${it.getStandardNo()}</td>
        <td>标准名称：${it.getStandardName()}</td>
        <td>创建时间：${it.getDate()}</td>
        <td><a href="${pageContext.request.contextPath}/Wage/check?No=${it.getStandardNo()}">重审</a></td>
    </tr>
    <br>
</c:forEach>
</body>
</html>
