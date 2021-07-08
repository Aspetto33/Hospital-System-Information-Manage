<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/7
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="PermissionAction_updatePermission.action" method="post">
    权限名称: <input type="text" name="name" value="${permission.pName}"> <br>
    权限描述: <input type="text" name="desc_" value="${permission.desc}"> <br>
    权限对应的url: <input type="text" name="url"  value="${permission.url}"> <br><br>
    <input type="hidden" name="id" value="${permission.pId}">
    <input type="submit" value="修改">
</form>
</body>
</html>
