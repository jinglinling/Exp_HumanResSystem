<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31472
  Date: 2023/12/27
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="it" items="${requestScope.get('standardresult')}">
    <tr>
        <td>薪酬标准编号：${it.getStandardNo()}</td>
        <td>薪酬标准名称：${it.getStandardName()}</td>
        <td>创建时间：${it.getDate()}</td>
        <td>登记人：${it.getRegistrant()}</td>
        <td>总金额：${it.getTotal()}</td>
        <td>基础工资：${it.getPrimaryWage()}</td>
        <td>创建人：${it.getCreator()}</td>
    </tr>
    <br>
</c:forEach>
<script>
    let a=${requestScope.get('query')}
    if(a<1){
        alert("未查询到任何结果");
    }
</script>
</body>
</html>
