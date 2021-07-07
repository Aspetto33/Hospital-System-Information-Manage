<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/6/30
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>login</title>
</head>
<body>


    <span class="desc">你好，${subject.principal}，</span>
<%--    <a href="doLogout.jsp">退出</a><br>--%>
<a href="UserAction_listUser.action">展示用户信息</a>
<a href="RoleAction_listRole.action">展示角色信息</a>
<a href="PermissionAction_listPermission.action">展示权限信息</a>
<a href="#">财务部门</a>
<a href="#">药品管理部门</a>
</body>
</html>
