<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 31472
  Date: 2023/12/26
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Wage/addstandard" method="post">
    <tr>
        <td>薪酬标准编号<input type="text" value="${requestScope.get('No')}" name="StandardNo"></td>
        <td>薪酬标准名称<input type="text" name="StandardName"></td>
        <td>薪酬总额<input type="text" value="0" name="Total" id="m1"></td>
    </tr>
    <tr>
        <td>制定人<input type="text" name="Creator"></td>
        <td>登记人<input type="text" name="Registrant"></td>
        <td>登记时间<input type="text" value="${requestScope.get('time')}" name="Date"></td>
    </tr>
    <input type="hidden" value="0" name="Check">
    <tr>
        <td>序号</td>
        <td>薪酬项目名称</td>
        <td>金额</td>
    </tr>
    <tr>
        <td>1</td>
        <td>基础工资</td>
        <td><input type="text" value="0" name="PrimaryWage" id="m2"></td>
    </tr>
    <c:forEach var="it" items="${requestScope.get('Wagename')}" varStatus="s">
        <tr>
            <td>${s.index+2}</td>
            <td>${it.getWageName()}</td>
            <td><input type="text" value="0" id="${s.index+2}"></td>
        </tr>
    </c:forEach>
    <input type="submit" value="提交">
</form>
<script>
    let input=document.getElementById('m2');
    let w1=document.getElementById('2');
    let w2=document.getElementById('3');
    let w3=document.getElementById('4');
    let w4=document.getElementById('5');
    let total=document.getElementById('m1');
    input.oninput=function (){
        w1.value=input.value*0.08;
        w2.value=input.value*0.02+3;
        w3.value=input.value*0.005;
        w4.value=input.value*0.08;
        total.value=Number(w1.value)+Number(w2.value)+Number(w3.value)+Number(w4.value)+Number(input.value);
    }
</script>
</body>
</html>
