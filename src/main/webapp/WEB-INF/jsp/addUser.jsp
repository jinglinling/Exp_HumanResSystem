<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>AddUser</title>

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
<h1>添加用户</h1>

<form action="/user/addUser" method="post">
    <%--@declare id="sex"--%>
    <label for="userID">用户ID:</label><br>
    <input type="text" id="userID" name="userID"><br>
    <label for="userAccount">账号:</label><br>
    <input type="text" id="userAccount" name="userAccount"><br>
    <label for="userName">用户名:</label><br>
    <input type="text" id="userName" name="userName"><br>
    <label for="userPassword">密码:</label><br>
    <input type="password" id="userPassword" name="userPassword"><br>
    <label for="sex">性别:</label><br>
    <input type="radio" id="male" name="sex" value="1">
    <label for="male">男</label><br>
    <input type="radio" id="female" name="sex" value="0">
    <label for="female">女</label><br>
    <input type="submit" value="确认">
</form>

</body>
</html>

