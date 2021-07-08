<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/7
  Time: 11:25
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
        <td>角色名称</td>
        <td>角色描述</td>
        <td>权限</td>
    </tr>
    <c:forEach items="${roles}" var="r">
        <tr>
            <td>${r.rId}</td>
            <td>${r.rName}</td>
            <td>${r.desc}</td>
            <td>
                <c:forEach items="${role_permission[r]}" var="p">
                    ${p.pName} <br>
                </c:forEach>
            </td>
<%--            <td><a href="RoleAction_editRole.action?id=${r.rId}"></a> </td>--%>
<%--            <td><a href="RoleAction_deleteRole.action?id=${r.rId}">删除</a></td>--%>
        </tr>
    </c:forEach>
</table>

    <form action="RoleAction_addRole.action" method="post">
        角色名称: <input type="text" name="role.rName"> <br>
        角色描述: <input type="text" name="role.desc"> <br><br>
        <input type="submit" value="增加">
    </form>

</body>
</html>
