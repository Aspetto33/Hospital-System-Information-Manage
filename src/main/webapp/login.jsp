<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/3
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>登录页面</title>
</head>
<body>

    <form action="LoginAction_findUserByUnameAndUpwd.action" method="post">
        账号：  <input type="text" name="uName"><br>
        密码:   <input type="password" name="uPwd"><br>
        <br>
        <input type="submit" value="登录">
        <a href="register.jsp">注册</a>
        <a href="updatePwd.jsp">修改密码</a>
        <a href="HospitalAction_getHospitals.action">查询医院信息</a>
    </form>
</body>
</html>
