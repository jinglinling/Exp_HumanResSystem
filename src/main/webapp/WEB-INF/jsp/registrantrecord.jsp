<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 31472
  Date: 2023/12/27
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="form1" action="${pageContext.request.contextPath}/Wage/addreward" method="post">
<tr>
    <td>薪酬发放单号:${requestScope.get('record1').getNo()}</td>
    <td><input type="submit" value="提交"></td><br>
    <td>机构：${requestScope.get('record1').getFirst()}/${requestScope.get('record1').getSecond()}
        /${requestScope.get('record1').getThird()}</td><br>
    <td>总人数：${requestScope.get('record1').getTotalPerson()}</td>
    <td>基本薪酬总额：${requestScope.get('record1').getTotal()}</td>
    <p>应付金额：</p><td><input type="text" value="0" name="m" id="m3"></td></td><br>
        <input type="hidden" name="n" value="${requestScope.get('record1').getNo()}">
        <input type="hidden" name="c" value="2">
</tr>
<c:forEach var="it" items="${requestScope.get('recordNo')}" varStatus="s">
    <tr>
        <td>档案编号:${it.getFileNo()}</td>
        <td>姓名:${it.getName()}</td>
        <c:set var="temp" value="${it.getName()}" scope="page"></c:set>
        <c:forEach var="im" items="${requestScope.get(temp)}">
        <td>${im.getWageName()}</td>
        <td>${im.getAmount()}</td>
        </c:forEach>
            <td>奖励奖金：<input type="text" value="0" name="amount" id="m1" oninput="calcuate()"></td>
            <input type="hidden" value="奖励奖金" name="wagename">
            <input type="hidden" value="${it.getName()}" name="Name">
            <input type="hidden" value="${requestScope.get('record1').getNo()}" name="No">
            <td>应扣奖金：<input type="text" value="0" name="amount" id="m2" oninput="calcuate()"></td>
            <input type="hidden" value="应扣奖金" name="wagename">
            <input type="hidden" value="${it.getName()}" name="Name">
            <input type="hidden" value="${requestScope.get('record1').getNo()}" name="No">
    </tr>
    <br>
</c:forEach>
    </form>
<script>
    let temp=document.getElementsByTagName('form')
    /*function submitForms() {
        for (let i=0;i<temp.length;i++){
            if(temp[i].getAttribute('id')=='form1'){
                temp[i].submit();
            }
        }
        document.getElementById('form3').submit();
    }*/
    let a=document.getElementById('m1');
    let b=document.getElementById('m2');
    let c=document.getElementById('m3');
    let m=document.getElementsByTagName("input");
    function calcuate(){
        let y=0;
       for(let i=0;i<m.length;i++){
           if (m[i].getAttribute('id')=='m1'){
               y=Number(y)+Number(m[i].value);
           }
           if(m[i].getAttribute('id')=='m2'){
               y=Number(y)-Number(m[i].value);
           }
       }
       c.value=Number(y)+Number(${requestScope.get('record1').getTotal()});
    }
</script>
</body>
</html>
