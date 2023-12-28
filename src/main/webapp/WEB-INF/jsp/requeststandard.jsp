<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31472
  Date: 2023/12/27
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<tr>
    <form action="${pageContext.request.contextPath}/Wage/getstandard" method="post">
    <td>请输入薪酬标准编号<input type="text" name="No"></td><br>
    <td>请输入关键字<input type="text" name="keyword"></td><br>
    <td>请输入登记时间<input type="text" name="before">至<input type="text" name="after"></td><br>
        <td><input type="submit" value="查询"></td>
    </form>
</tr>
</body>
</html>
