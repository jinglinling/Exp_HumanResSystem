<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31472
  Date: 2023/12/28
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="it" items="${requestScope.get('uncheckrecord')}">
    <tr>
        <td>薪酬发放单号：${it.getNo()}</td>
        <td>一级机构：${it.getFirst()}</td>
        <td>二级机构：${it.getSecond()}</td>
        <td>三级机构：${it.getThird()}</td>
        <td>总人数：${it.getTotalPerson()}</td>
        <td>总金额：${it.getTotal()}</td>
        <td><a href="${pageContext.request.contextPath}/Wage/check?No=${it.getNo()}">登记</a></td>
        <br>
    </tr>
</c:forEach>
</body>
</html>
