<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加员工</title>
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
                欢迎来到添加员工档案页面！
            </span>
    </div>
</nav>

<h1>添加员工</h1>

<form action="/staff/addStaff" method="post">
    <table>
        <tr>
            <td><strong>一级机构:</strong></td>
            <td>
                <select id="primaryInsitutionNum" name="primaryInsitutionNum">
                    <c:forEach var="primaryInsitution" items="${primaryInsitutions}">
                        <option value="${primaryInsitution.primaryInsitutionNum}">${primaryInsitution.primaryInsitutionName}</option>
                    </c:forEach>
                </select>
            </td>
            <td><strong>二级机构:</strong></td>
            <td>
                <select id="secondInsitutionNum" name="secondInsitutionNum">
                    <c:forEach var="secondInsitution" items="${secondInsitutions}">
                        <option value="${secondInsitution.secondInsitutionNum}">${secondInsitution.secondInsitutionName}</option>
                    </c:forEach>
                </select>
            </td>
            <td><strong>三级机构:</strong></td>
            <td>
                <select id="thirdInsitutionNum" name="thirdInsitutionNum">
                    <c:forEach var="thirdInsitution" items="${thirdInsitutions}">
                        <option value="${thirdInsitution.thirdInsitutionNum}">${thirdInsitution.thirdInsitutionName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td><strong>职位名称:</strong></td>
            <td>
                <select id="position" name="position">
                    <option value="软件开发工程师">软件开发工程师</option>
                    <option value="软件测试工程师">软件测试工程师</option>
                </select>
            </td>
            <td><strong>职称:</strong></td>
            <td>
                <select id="title" name="title">
                    <option value="初级">初级</option>
                    <option value="中级">中级</option>
                    <option value="高级">高级</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><strong>姓名:</strong></td>
            <td><input type="text" id="name" name="name"></td>
            <td><strong>性别:</strong></td>
            <td>
                <select id="gender" name="gender">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </td>
            <td><strong>Email:</strong></td>
            <td><input type="email" id="email" name="email"></td>
        </tr>
        <tr>
            <td><strong>电话:</strong></td>
            <td><input type="text" id="phone" name="phone"></td>
            <td><strong>QQ:</strong></td>
            <td><input type="text" id="QQ" name="QQ"></td>
            <td><strong>手机:</strong></td>
            <td><input type="text" id="mobile" name="mobile"></td>
        </tr>
        <tr>
            <td><strong>住址:</strong></td>
            <td colspan="3"><input type="text" id="address" name="address"></td>
            <td><strong>邮编:</strong></td>
            <td><input type="text" id="zipCode" name="zipCode"></td>
        </tr>
        <tr>
            <td><strong>国籍:</strong></td>
            <td>
                <select id="nationality" name="nationality">
                    <option value="中国">中国</option>
                    <option value="日本">日本</option>
                    <option value="美国">美国</option>
                    <option value="意大利">意大利</option>
                    <option value="德国">德国</option>
                    <option value="加拿大">加拿大</option>
                    <option value="西班牙">西班牙</option>
                    <option value="韩国">韩国</option>
                    <option value="越南">越南</option>
                </select>
            </td>
            <td><strong>出生地:</strong></td>
            <td><input type="text" id="birthPlace" name="birthPlace"></td>
            <td><strong>生日:</strong></td>
            <td><input type="date" id="birthday" name="birthday"></td>
            <td><strong>民族:</strong></td>
            <td>
                <select id="nation" name="nation">
                    <option value="汉族">汉族</option>
                    <option value="回族">回族</option>
                    <option value="白族">白族</option>
                    <option value="维吾尔族">维吾尔族</option>
                    <option value="土族">土族</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><strong>宗教信仰:</strong></td>
            <td>
                <select id="religion" name="religion">
                    <option value="无">无</option>
                    <option value="佛教">佛教</option>
                    <option value="伊斯兰教">伊斯兰教</option>
                    <option value="天主教">天主教</option>
                    <option value="犹太教">犹太教</option>
                    <option value="道教">道教</option>
                </select>
            </td>
            <td><strong>政治面貌:</strong></td>
            <td>
                <select id="politics" name="politics">
                    <option value="群众">群众</option>
                    <option value="共青团员">共青团员</option>
                    <option value="共产党员">共产党员</option>
                </select>
            </td>
            <td><strong>身份证号码:</strong></td>
            <td><input type="text" id="ID" name="ID"></td>
            <td><strong>社会保障号码:</strong></td>
            <td><input type="text" id="SSN" name="SSN"></td>
        </tr>
        <tr>
            <td><strong>年龄:</strong></td>
            <td><input type="number" id="age" name="age"></td>
            <td><strong>学历:</strong></td>
            <td>
                <select id="education" name="education">
                    <option value="初中及以下">初中及以下</option>
                    <option value="高中">高中</option>
                    <option value="本科">本科</option>
                    <option value="大专">大专</option>
                    <option value="职中">职中</option>
                    <option value="研究生">研究生</option>
                    <option value="博士生">博士生</option>
                    <option value="博士后">博士后</option>
                </select>
            </td>
            <td><strong>教育年限:</strong></td>
            <td><input type="number" id="educationYear" name="educationYear"></td>
            <td><strong>学历专业:</strong></td>
            <td>
                <select id="major" name="major">
                    <option value="软件工程">软件工程</option>
                    <option value="物联网工程">物联网工程</option>
                    <option value="计算机科学与技术">计算机科学与技术</option>
                    <option value="大数据信息与技术">大数据信息与技术</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><strong>薪酬标准:</strong></td>
            <td><input type="number" id="salary" name="salary" value="${staff.salary}"></td>
            <td><strong>开户行:</strong></td>
            <td><input type="text" id="bank" name="bank" value="${staff.bank}"></td>
            <td><strong>账号:</strong></td>
            <td><input type="text" id="account" name="account" value="${staff.account}"></td>
            <td><strong>登记人:</strong></td>
            <td><input type="text" id="registrant" name="registrant" value="${staff.registrant}"></td>
        </tr>
        <tr>
            <td><strong>登记时间:</strong></td>
            <td><input type="date" id="registrationTime" name="registrationTime" value="<fmt:formatDate value='${staff.registrationTime}' pattern='yyyy-MM-dd'/>"></td>
            <td><strong>特长:</strong></td>
            <td>
                <select id="speciality" name="speciality">
                    <option value="数据库">数据库</option>
                    <option value="Web前端">Web前端</option>
                    <option value="框架">框架</option>
                    <option value="数据后端">数据后端</option>
                    <option value="设计">设计</option>
                    <option value="前后端">前后端</option>
                    <option value="引擎">引擎</option>
                    <option value="架构">架构</option>
                    <option value="服务器">服务器</option>
                </select>
            </td>
            <td><strong>爱好:</strong></td>
            <td><input type="text" id="hobby" name="hobby" value="${staff.hobby}"></td>
        </tr>
        <tr>
            <td><strong>个人履历:</strong></td>
            <td colspan="5"><textarea id="resume" name="resume">${staff.resume}</textarea></td>
        </tr>
        <tr>
            <td><strong>家庭关系信息:</strong></td>
            <td colspan="5"><textarea id="family" name="family">${staff.family}</textarea></td>
        </tr>
        <tr>
            <td><strong>备注:</strong></td>
            <td colspan="5"><textarea id="note" name="note">${staff.note}</textarea></td>
        </tr>
    </table>
    <input type="submit" value="确定">
</form>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>

