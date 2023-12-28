<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>UserInfo</title>

    <style>
        body {
            background-color: #e0f7fa;
            font-family: Arial, sans-serif;
            color: #333;
            padding: 20px;
        }

        h1 {
            color: #444;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
            padding: 10px;
        }

        th {
            background-color: #80deea;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        input[type=submit] {
            background: linear-gradient(to right, #80deea, #4dd0e1);
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 15px;
            transition: all 0.3s ease 0s;
        }

        input[type=submit]:hover {
            background: linear-gradient(to right, #4dd0e1, #26c6da);
        }
    </style>
</head>
<body>
<h1>用户信息</h1>

<form action="/user/listUser" method="get">
    <label for="userID">User ID:</label>
    <input type="text" id="userID" name="userID">
    <input type="submit" value="Search">
</form>

<table>
    <tr>
        <th>用户ID</th>
        <th>账号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>性别</th>
        <th>按钮</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.userID}</td>
            <td>${user.userAccount}</td>
            <td>${user.userName}</td>
            <td>${user.userPassword}</td>
            <td><c:choose>
                <c:when test="${user.sex == 1}">男</c:when>
                <c:otherwise>女</c:otherwise>
            </c:choose></td>
            <td>
                <form action="/user/updateUser" method="get">
                    <input type="hidden" name="userID" value="${user.userID}">
                    <input type="submit" value="修改">
                </form>
                <form action="/user/deleteUser" method="post">
                    <input type="hidden" name="userID" value="${user.userID}">
                    <input type="submit" value="删除">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="/user/addUser" method="get">
    <input type="submit" value="添加用户">
</form>
</body>
</html>


