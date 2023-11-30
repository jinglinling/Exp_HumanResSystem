<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Third Institution</title>
    <!-- 引入 Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: #e0f7fa;
            font-family: Arial, sans-serif;
            color: #333;
            padding: 20px;
        }

        .navbar {
            background-color: #80deea;
        }

        .navbar-brand,
        .navbar-nav .nav-link {
            color: #fff;
        }

        .navbar-nav .nav-link:hover,
        .navbar-nav .nav-link:focus {
            color: #f8bbd0;
        }

        .dropdown-menu {
            background-color: #80deea;
        }

        .dropdown-item {
            color: #fff;
        }

        .dropdown-item:hover,
        .dropdown-item:focus {
            color: #f8bbd0;
            background-color: #4dd0e1;
        }

        .container {
            background-color: #fff;
            border-radius: 15px;
            padding: 20px;
            margin-top: 20px;
        }

        h1 {
            color: #26c6da;
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
    </style>
    <script>
        $(document).ready(function() {
            $('#primaryInsitutionNum').change(function() {
                var primaryInsitutionNum = $(this).val();
                $.ajax({
                    url: '/institution/getInsitutionInfo',
                    data: { 'primaryInsitutionNum': primaryInsitutionNum },
                    type: 'GET',
                    success: function(data) {
                        var secondInsitutionSelect = $('#secondInsitutionNum');
                        secondInsitutionSelect.empty();
                        $.each(data, function(index, secondInsitution) {
                            secondInsitutionSelect.append('<option value="' + secondInsitution.secondInsitutionNum + '">' + secondInsitution.secondInsitutionName + '</option>');
                        });
                    }
                });
            });
            $('#primaryInsitutionNum').change();
        });
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg" style="background-color: #80deea;">
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="hrDropdown" role="button" data-toggle="dropdown" style="color: #fff;">
                    人力资源管理
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/index.jsp">首页</a>
                    <a class="dropdown-item" href="/staff/listStaff">员工列表</a>
                    <a class="dropdown-item" href="/staff/listProcessStaff">待审核员工列表</a>
                    <a class="dropdown-item" href="/staff/listDeleteStaff">已删除员工列表</a>
                    <a class="dropdown-item" href="/staff/AddStaff">添加员工</a>
                    <a class="dropdown-item" href="/institution/addThirdInsitution">添加三级机构</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/salary/list" style="color: #fff;">薪酬标准管理</a>
            </li>
        </ul>
        <span class="navbar-text" style="color: #fff;">
                欢迎来到添加三级机构页面！
            </span>
    </div>
</nav>
<h1>添加三级机构</h1>

<form action="/institution/addThirdInsitution" method="post">
    <table>
        <tr>
            <td><label for="thirdInsitutionName">三级机构名称:</label></td>
            <td><input type="text" id="thirdInsitutionName" name="thirdInsitutionName"></td>
        </tr>
        <tr>
            <td colspan="4"><h2>从属关系</h2></td>
        </tr>
        <tr>
            <td><label for="primaryInsitutionNum">一级机构:</label></td>
            <td>
                <select id="primaryInsitutionNum" name="primaryInsitutionNum">
                    <c:forEach var="primaryInsitution" items="${primaryInsitutions}">
                        <option value="${primaryInsitution.primaryInsitutionNum}">${primaryInsitution.primaryInsitutionName}</option>
                    </c:forEach>
                </select>
            </td>
            <td><label for="secondInsitutionNum">二级机构:</label></td>
            <td>
                <select id="secondInsitutionNum" name="secondInsitutionNum">
                    <c:forEach var="secondInsitution" items="${secondInsitutions}">
                        <option value="${secondInsitution.secondInsitutionNum}">${secondInsitution.secondInsitutionName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>
    <input type="submit" value="确定">
</form>
</body>
</html>
