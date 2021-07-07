<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/7
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>用户名称</td>
        <td>用户密码</td>
        <td>加密盐</td>
        <td>角色</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.uId}</td>
            <td>${u.uName}</td>
            <td>${fn:substring(u.uPwd, 0, 5)}...</td>
            <td>${fn:substring(u.salt, 0, 5)}...</td>
            <td>
                <c:forEach items="${user_role[u]}" var="r">
                    ${r.rName} <br>
                </c:forEach>
            </td>
            <td><a href="UserAction_deleteUser?id=${u.uId}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
