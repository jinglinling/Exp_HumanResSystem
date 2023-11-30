<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.esms.entity.Staff" %>
<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日"); %>
<% Staff staff = (Staff) request.getAttribute("staff"); %>
<% SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd"); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>员工详细信息</title>
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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script>
    $(document).ready(function(){
      $("#deleteForm").submit(function(e){
        e.preventDefault();
        if (confirm("确定要删除吗？")) {
          $.ajax({
            type: "POST",
            url: "/staff/changeStaff",
            data: { fileNo: ${staff.fileNo} },
            success: function(data) {
              alert("删除成功");
              window.location.href = "/staff/listStaff";
            },
            error: function(data) {
              alert("删除失败");
            }
          });
        }
      });
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
                欢迎来到员工档案页面！
    </span>
  </div>
</nav>

<h1>${staff.name}的档案</h1>

<div style="text-align:right;">
  <form action="/staff/updateStaff" method="get">
    <input type="hidden" name="fileNo" value="${staff.fileNo}">
    <input type="submit" value="更改">
  </form>
  <form id="deleteForm" action="/staff/changeStaff" method="post">
    <input type="hidden" name="fileNo" value="${staff.fileNo}">
    <input type="submit" value="删除">
  </form>
</div>

<table style="width:100%; border:1px solid #ddd; padding:20px; margin:20px 0;">
  <tr>
    <td colspan="6"><strong>档案编号:</strong> ${staff.fileNo}</td>
  </tr>
  <tr>
    <td><strong>一级机构:</strong></td>
    <td>${staff.primaryInsitutionName}</td>
    <td><strong>二级机构:</strong></td>
    <td>${staff.secondInsitutionName}</td>
    <td><strong>三级机构:</strong></td>
    <td>${staff.thirdInsitutionName}</td>
  </tr>
  <tr>
    <td><strong>职位名称:</strong></td>
    <td>${staff.position}</td>
    <td><strong>职称:</strong></td>
    <td colspan="3">${staff.title}</td>
  </tr>
  <tr>
    <td><strong>姓名:</strong></td>
    <td>${staff.name}</td>
    <td><strong>性别:</strong></td>
    <td>${staff.gender}</td>
    <td><strong>Email:</strong></td>
    <td>${staff.email}</td>
  </tr>
  <tr>
    <td><strong>电话:</strong></td>
    <td>${staff.phone}</td>
    <td><strong>QQ:</strong></td>
    <td>${staff.QQ}</td>
    <td><strong>手机:</strong></td>
    <td>${staff.mobile}</td>
  </tr>
  <tr>
    <td><strong>住址:</strong></td>
    <td colspan="3">${staff.address}</td>
    <td><strong>邮编:</strong></td>
    <td>${staff.zipCode}</td>
  </tr>
  <tr>
    <td><strong>国籍:</strong></td>
    <td>${staff.nationality}</td>
    <td><strong>出生地:</strong></td>
    <td>${staff.birthPlace}</td>
    <td><strong>生日:</strong></td>
    <td><%= staff.getBirthday() != null ? sdf.format(staff.getBirthday()) : "" %></td>
  </tr>
  <tr>
    <td><strong>民族:</strong></td>
    <td>${staff.nation}</td>
    <td><strong>宗教信仰:</strong></td>
    <td>${staff.religion}</td>
    <td><strong>政治面貌:</strong></td>
    <td>${staff.politics}</td>
  </tr>
  <tr>
    <td><strong>身份证号码:</strong></td>
    <td>${staff.ID}</td>
    <td><strong>社会保障号码:</strong></td>
    <td>${staff.SSN}</td>
    <td><strong>年龄:</strong></td>
    <td>${staff.age}</td>
  </tr>
  <tr>
    <td><strong>学历:</strong></td>
    <td>${staff.education}</td>
    <td><strong>教育年限:</strong></td>
    <td>${staff.educationYear}</td>
    <td><strong>学历专业:</strong></td>
    <td>${staff.major}</td>
  </tr>
  <tr>
    <td><strong>薪酬标准:</strong></td>
    <td>${staff.salary}</td>
    <td><strong>开户行:</strong></td>
    <td>${staff.bank}</td>
    <td><strong>账号:</strong></td>
    <td>${staff.account}</td>
  </tr>
  <tr>
    <td><strong>登记人:</strong></td>
    <td>${staff.registrant}</td>
    <td><strong>登记时间:</strong></td>
    <td colspan="3"><%= staff.getRegistrationTime() != null ? sdf2.format(staff.getRegistrationTime()) : "" %></td>
  </tr>
  <tr>
    <td><strong>特长:</strong></td>
    <td>${staff.speciality}</td>
    <td><strong>爱好:</strong></td>
    <td colspan="3">${staff.hobby}</td>
  </tr>
  <tr>
    <td><strong>个人履历:</strong></td>
    <td colspan="5">${staff.resume}</td>
  </tr>
  <tr>
    <td><strong>家庭关系信息:</strong></td>
    <td colspan="5">${staff.family}</td>
  </tr>
  <tr>
    <td><strong>备注:</strong></td>
    <td colspan="5">${staff.note}</td>
  </tr>
</table>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>

