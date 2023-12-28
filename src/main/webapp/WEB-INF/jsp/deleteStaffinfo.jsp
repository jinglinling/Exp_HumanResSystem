<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>DeleteStaffInfo</title>
  <!-- 引入 Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
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
                欢迎来到已删除员工列表页面！
            </span>
  </div>
</nav>

<h1>已删除员工信息</h1>

<form action="/staff/listDeleteStaff" method="get">
  <label for="fileNo">fileNo:</label>
  <input type="text" id="fileNo" name="fileNo">
  <input type="submit" value="搜索">
</form>

<table>
  <tr>
    <th>档案编号</th>
    <th>姓名</th>
    <th>性别</th>
    <th>一级机构</th>
    <th>二级机构</th>
    <th>三级机构</th>
    <th>职位名称</th>
    <th>操作</th>
  </tr>
  <c:forEach var="staff" items="${staffs}">
    <tr>
      <td>${staff.fileNo}</td>
      <td>${staff.name}</td>
      <td>${staff.gender}</td>
      <td>${staff.primaryInsitutionName}</td>
      <td>${staff.secondInsitutionName}</td>
      <td>${staff.thirdInsitutionName}</td>
      <td>${staff.position}</td>
      <td>
        <form action="/staff/DeleteStaff/${staff.fileNo}" method="get">
          <input type="hidden" name="fileNo" value="${staff.fileNo}">
          <input type="submit" value="查看">
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
