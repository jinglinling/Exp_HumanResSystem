<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31472
  Date: 2023/12/26
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Wage/addlist" method="post">
    <p>输入薪酬项目名称：</p><input type="text" name="WageName">
    <input type="submit" value="添加">
</form>
<c:forEach var="it" items="${requestScope.get('list')}">
    <td>${it.getWageName()}</td><a href="${pageContext.request.contextPath}/Wage/deletelist?wname=${it.getWageName()}">删除</a><br>
</c:forEach>
</body>
</html>
