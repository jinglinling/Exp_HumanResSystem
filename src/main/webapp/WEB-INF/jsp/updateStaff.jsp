<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>更新员工信息</title>
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
                欢迎来到更改员工档案页面！
    </span>
  </div>
</nav>

<h1>更新 ${staff.name} 的信息</h1>

<form action="/staff/updateStaff" method="post">
  <table>
    <tr>
      <td><strong>档案编号:</strong><input type="text" id="fileNo" name="fileNo" value="${staff.fileNo}" readonly></td>
    </tr>
    <tr>
      <td><strong>一级机构:</strong></td>
      <td><input type="text" id="primaryInsitutionName" name="primaryInsitutionName" value="${staff.primaryInsitutionName}" readonly></td>
      <td><strong>二级机构:</strong></td>
      <td><input type="text" id="secondInsitutionName" name="secondInsitutionName" value="${staff.secondInsitutionName}" readonly></td>
      <td><strong>三级机构:</strong></td>
      <td><input type="text" id="thirdInsitutionName" name="thirdInsitutionName" value="${staff.thirdInsitutionName}" readonly></td>
    </tr>
    <tr>
      <td><strong>职位名称:</strong></td>
      <td><input type="text" id="position" name="position" value="${staff.position}" readonly></td>
      <td><strong>职称:</strong></td>
      <td>
        <select id="title" name="title">
          <option value="初级" ${staff.gender == '初级' ? 'selected' : ''}>初级</option>
          <option value="中级" ${staff.gender == '中级' ? 'selected' : ''}>中级</option>
          <option value="高级" ${staff.gender == '高级' ? 'selected' : ''}>高级</option>
        </select>
      </td>
    </tr>
    <tr>
      <td><strong>姓名:</strong></td>
      <td><input type="text" id="name" name="name" value="${staff.name}"></td>
      <td><strong>性别:</strong></td>
      <td>
        <select id="gender" name="gender">
          <option value="男" ${staff.gender == '男' ? 'selected' : ''}>男</option>
          <option value="女" ${staff.gender == '女' ? 'selected' : ''}>女</option>
        </select>
      </td>
      <td><strong>Email:</strong></td>
      <td><input type="text" id="email" name="email" value="${staff.email}"></td>
    </tr>
    <tr>
      <td><strong>电话:</strong></td>
      <td><input type="text" id="phone" name="phone" value="${staff.phone}"></td>
      <td><strong>QQ:</strong></td>
      <td><input type="text" id="QQ" name="QQ" value="${staff.QQ}"></td>
      <td><strong>手机:</strong></td>
      <td><input type="text" id="mobile" name="mobile" value="${staff.mobile}"></td>
    </tr>
    <tr>
      <td><strong>住址:</strong></td>
      <td colspan="3"><input type="text" id="address" name="address" value="${staff.address}"></td>
      <td><strong>邮编:</strong></td>
      <td><input type="text" id="zipCode" name="zipCode" value="${staff.zipCode}"></td>
    </tr>
    <tr>
      <td><strong>国籍:</strong></td>
      <td>
        <select id="nationality" name="nationality">
          <option value="中国" ${staff.nationality == '中国' ? 'selected' : ''}>中国</option>
          <option value="日本" ${staff.nationality == '日本' ? 'selected' : ''}>日本</option>
          <option value="美国" ${staff.nationality == '美国' ? 'selected' : ''}>美国</option>
          <option value="意大利" ${staff.nationality == '意大利' ? 'selected' : ''}>意大利</option>
          <option value="德国" ${staff.nationality == '德国' ? 'selected' : ''}>德国</option>
          <option value="加拿大" ${staff.nationality == '加拿大' ? 'selected' : ''}>加拿大</option>
          <option value="西班牙" ${staff.nationality == '西班牙' ? 'selected' : ''}>西班牙</option>
          <option value="韩国" ${staff.nationality == '韩国' ? 'selected' : ''}>韩国</option>
          <option value="越南" ${staff.nationality == '越南' ? 'selected' : ''}>越南</option>
        </select>
      </td>
      <td><strong>出生地:</strong></td>
      <td><input type="text" id="birthPlace" name="birthPlace" value="${staff.birthPlace}"></td>
      <td><strong>生日:</strong></td>
      <td><input type="date" id="birthday" name="birthday" value="<fmt:formatDate value='${staff.birthday}' pattern='yyyy-MM-dd'/>"></td>
      <td><strong>民族:</strong></td>
      <td>
        <select id="nation" name="nation">
          <option value="汉族" ${staff.nation == '汉族' ? 'selected' : '' }>汉族</option>
          <option value="回族" ${staff.nation == '回族' ? 'selected' : '' }>回族</option>
          <option value="白族" ${staff.nation == '白族' ? 'selected' : '' }>白族</option>
          <option value="维吾尔族" ${staff.nation == '维吾尔族' ? 'selected' : '' }>维吾尔族</option>
          <option value="土族" ${staff.nation == '土族' ? 'selected' : '' }>土族</option>
        </select>
      </td>
    </tr>
    <tr>
      <td><strong>宗教信仰:</strong></td>
      <td>
        <select id="religion" name="religion">
          <option value="无" ${staff.religion == '无' ? 'selected' : '' }>无</option>
          <option value="佛教" ${staff.religion == '佛教' ? 'selected' : '' }>佛教</option>
          <option value="伊斯兰教" ${staff.religion == '伊斯兰教' ? 'selected' : '' }>伊斯兰教</option>
          <option value="天主教" ${staff.religion == '天主教' ? 'selected' : '' }>天主教</option>
          <option value="犹太教" ${staff.religion == '犹太教' ? 'selected' : '' }>犹太教</option>
          <option value="道教" ${staff.religion == '道教' ? 'selected' : '' }>道教</option>
        </select>
      </td>
      <td><strong>政治面貌:</strong></td>
      <td>
        <select id="politics" name="politics">
          <option value="群众" ${staff.politics == '群众' ? 'selected' : '' }>群众</option>
          <option value="共青团员" ${staff.politics == '共青团员' ? 'selected' : '' }>共青团员</option>
          <option value="共产党员" ${staff.politics == '共产党员' ? 'selected' : '' }>共产党员</option>
        </select>
      </td>
      <td><strong>身份证号码:</strong></td>
      <td><input type="text" id="ID" name="ID" value="${staff.ID}"></td>
      <td><strong>社会保障号码:</strong></td>
      <td><input type="text" id="SSN" name="SSN" value="${staff.SSN}"></td>
    </tr>
    <tr>
      <td><strong>年龄:</strong></td>
      <td><input type="number" id="age" name="age" value="${staff.age}"></td>
      <td><strong>学历:</strong></td>
      <td>
        <select id="education" name="education">
          <option value="初中及以下" ${staff.education == '初中及以下' ? 'selected' : '' }>初中及以下</option>
          <option value="高中" ${staff.education == '高中' ? 'selected' : '' }>高中</option>
          <option value="本科" ${staff.education == '本科' ? 'selected' : '' }>本科</option>
          <option value="大专" ${staff.education == '大专' ? 'selected' : '' }>大专</option>
          <option value="职中" ${staff.education == '职中' ? 'selected' : '' }>职中</option>
          <option value="研究生" ${staff.education == '研究生' ? 'selected' : '' }>研究生</option>
          <option value="博士生" ${staff.education == '博士生' ? 'selected' : '' }>博士生</option>
          <option value="博士后" ${staff.education == '博士后' ? 'selected' : '' }>博士后</option>
        </select>
      </td>
      <td><strong>教育年限:</strong></td>
      <td><input type="number" id="educationYear" name="educationYear" value="${staff.educationYear}"></td>
      <td><strong>学历专业:</strong></td>
      <td>
        <select id="major" name="major">
          <option value="软件工程" ${staff.major == '软件工程' ? 'selected' : '' }>软件工程</option>
          <option value="物联网工程" ${staff.major == '物联网工程' ? 'selected' : '' }>物联网工程</option>
          <option value="计算机科学与技术" ${staff.major == '计算机科学与技术' ? 'selected' : '' }>计算机科学与技术</option>
          <option value="大数据信息与技术" ${staff.major == '大数据信息与技术' ? 'selected' : '' }>大数据信息与技术</option>
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
          <option value="数据库" ${staff.speciality == '数据库' ? 'selected' : '' }>数据库</option>
          <option value="Web前端" ${staff.speciality == 'Web前端' ? 'selected' : '' }>Web前端</option>
          <option value="框架" ${staff.speciality == '框架' ? 'selected' : '' }>框架</option>
          <option value="数据后端" ${staff.speciality == '数据后端' ? 'selected' : '' }>数据后端</option>
          <option value="设计" ${staff.speciality == '设计' ? 'selected' : '' }>设计</option>
          <option value="前后端" ${staff.speciality == '前后端' ? 'selected' : '' }>前后端</option>
          <option value="引擎" ${staff.speciality == '引擎' ? 'selected' : '' }>引擎</option>
          <option value="架构" ${staff.speciality == '架构' ? 'selected' : '' }>架构</option>
          <option value="服务器" ${staff.speciality == '服务器' ? 'selected' : '' }>服务器</option>
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
    <tr>
      <td colspan="8"><input type="submit" value="提交"></td>
    </tr>
  </table>
</form>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>

