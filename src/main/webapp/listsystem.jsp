<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/8
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id = "system">
    <table>
        <tr>
            <td>id</td>
            <td>系统名称</td>
            <td>版本</td>
            <td>删除</td>
        </tr>

        <c:forEach items="${systemsList}" var="s">
            <tr>
                <td>${s.sId}</td>
                <td>${s.sName}</td>
                <td>${s.sVersion}</td>
                <d><a href="HospitalAction_deleteHospital.action?id=${s.sId}">删除</a></d>
            </tr>
        </c:forEach>
        <tr>
            <td><a href="addsystem.jsp">增加医院信息</a> </td>
        </tr>

    </table>
</form>

<form action="SystemAction_addSystem.action" method="post">
            系统名称:<input type="text" name="systems.sName">
            版本:   <input type="text" name="systems.sVersion">
            <input type="submit" value="提交">
            <input type="reset" value="取消">
</form>
</body>
</html>
