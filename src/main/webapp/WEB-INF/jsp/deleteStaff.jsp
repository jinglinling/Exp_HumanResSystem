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
    <title>已删除员工详细信息</title>
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
                欢迎来到已删除员工档案页面！
            </span>
    </div>
</nav>

<h1>${staff.name}的档案</h1>

<form action="/staff/deleteStaff" method="post">
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
            <input type="hidden" name="title" value="${staff.title}">
            <td colspan="3">${staff.title}</td>
        </tr>
        <tr>
            <td><strong>姓名:</strong></td>
            <input type="hidden" name="name" value="${staff.name}">
            <td>${staff.name}</td>
            <td><strong>性别:</strong></td>
            <input type="hidden" name="gender" value="${staff.gender}">
            <td>${staff.gender}</td>
            <td><strong>Email:</strong></td>
            <input type="hidden" name="email" value="${staff.email}">
            <td>${staff.email}</td>
        </tr>
        <tr>
            <td><strong>电话:</strong></td>
            <input type="hidden" name="phone" value="${staff.phone}">
            <td>${staff.phone}</td>
            <td><strong>QQ:</strong></td>
            <input type="hidden" name="QQ" value="${staff.QQ}">
            <td>${staff.QQ}</td>
            <td><strong>手机:</strong></td>
            <input type="hidden" name="mobile" value="${staff.mobile}">
            <td>${staff.mobile}</td>
        </tr>
        <tr>
            <td><strong>住址:</strong></td>
            <input type="hidden" name="address" value="${staff.address}">
            <td colspan="3">${staff.address}</td>
            <td><strong>邮编:</strong></td>
            <input type="hidden" name="zipCode" value="${staff.zipCode}">
            <td>${staff.zipCode}</td>
        </tr>
        <tr>
            <td><strong>国籍:</strong></td>
            <input type="hidden" name="nationality" value="${staff.nationality}">
            <td>${staff.nationality}</td>
            <td><strong>出生地:</strong></td>
            <input type="hidden" name="birthPlace" value="${staff.birthPlace}">
            <td>${staff.birthPlace}</td>
            <td><strong>生日:</strong></td>
            <input type="hidden" name="birthday" value="<%= staff.getBirthday() != null ? sdf2.format(staff.getBirthday()) : "" %>">
            <td><%= staff.getBirthday() != null ? sdf.format(staff.getBirthday()) : "" %></td>
        </tr>
        <tr>
            <td><strong>民族:</strong></td>
            <input type="hidden" name="nation" value="${staff.nation}">
            <td>${staff.nation}</td>
            <td><strong>宗教信仰:</strong></td>
            <input type="hidden" name="religion" value="${staff.religion}">
            <td>${staff.religion}</td>
            <td><strong>政治面貌:</strong></td>
            <input type="hidden" name="politics" value="${staff.politics}">
            <td>${staff.politics}</td>
        </tr>
        <tr>
            <td><strong>身份证号码:</strong></td>
            <input type="hidden" name="ID" value="${staff.ID}">
            <td>${staff.ID}</td>
            <td><strong>社会保障号码:</strong></td>
            <input type="hidden" name="SSN" value="${staff.SSN}">
            <td>${staff.SSN}</td>
            <td><strong>年龄:</strong></td>
            <input type="hidden" name="age" value="${staff.age}">
            <td>${staff.age}</td>
        </tr>
        <tr>
            <td><strong>学历:</strong></td>
            <input type="hidden" name="education" value="${staff.education}">
            <td>${staff.education}</td>
            <td><strong>教育年限:</strong></td>
            <input type="hidden" name="educationYear" value="${staff.educationYear}">
            <td>${staff.educationYear}</td>
            <td><strong>学历专业:</strong></td>
            <input type="hidden" name="major" value="${staff.major}">
            <td>${staff.major}</td>
        </tr>
        <tr>
            <td><strong>薪酬标准:</strong></td>
            <input type="hidden" name="salary" value="${staff.salary}">
            <td>${staff.salary}</td>
            <td><strong>开户行:</strong></td>
            <input type="hidden" name="bank" value="${staff.bank}">
            <td>${staff.bank}</td>
            <td><strong>账号:</strong></td>
            <input type="hidden" name="account" value="${staff.account}">
            <td>${staff.account}</td>
        </tr>
        <tr>
            <td><strong>登记人:</strong></td>
            <input type="hidden" name="registrant" value="${staff.registrant}">
            <td>${staff.registrant}</td>
            <td><strong>登记时间:</strong></td>
            <input type="hidden" name="registrationTime" value="<%= staff.getRegistrationTime() != null ? sdf2.format(staff.getRegistrationTime()) : "" %>">
            <td colspan="3"><%= staff.getRegistrationTime() != null ? sdf2.format(staff.getRegistrationTime()) : "" %></td>
        </tr>
        <tr>
            <td><strong>特长:</strong></td>
            <input type="hidden" name="speciality" value="${staff.speciality}">
            <td>${staff.speciality}</td>
            <td><strong>爱好:</strong></td>
            <input type="hidden" name="hobby" value="${staff.hobby}">
            <td colspan="3">${staff.hobby}</td>
        </tr>
        <tr>
            <td><strong>个人履历:</strong></td>
            <input type="hidden" name="resume" value="${staff.resume}">
            <td colspan="5">${staff.resume}</td>
        </tr>
        <tr>
            <td><strong>家庭关系信息:</strong></td>
            <input type="hidden" name="family" value="${staff.family}">
            <td colspan="5">${staff.family}</td>
        </tr>
        <tr>
            <td><strong>备注:</strong></td>
            <input type="hidden" name="note" value="${staff.note}">
            <td colspan="5">${staff.note}</td>
        </tr>
        <tr>
            <td colspan="8"><input type="submit" value="恢复"></td>
            <input type="hidden" name="fileNo" value="${staff.fileNo}">
        </tr>
    </table>
</form>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>


