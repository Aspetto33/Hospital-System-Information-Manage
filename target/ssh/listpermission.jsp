<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/7
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>权限名称</td>
        <td>权限描述</td>
        <td>权限对应的路径</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${permission}" var="p">
        <tr>
            <td>${p.pId}</td>
            <td>${p.pName}</td>
            <td>${p.desc}</td>
            <td>${p.url}</td>
            <td><a href="PermissionAction_deletePermission?id=${p.pId}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<form action="Permission_addPermission.action" method="post">
    权限名称: <input type="text" name="permission.pName"> <br>
    权限描述: <input type="text" name="permission.desc"> <br>
    权限对应的url: <input type="text" name="permission.url"> <br><br>
    <input type="submit" value="增加">
</form>
</body>
</html>
