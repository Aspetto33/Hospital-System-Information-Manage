<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/5
  Time: 10:14
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
<table>
    <tr>
        <td>id</td>
        <td>科室数量</td>
        <td>医院面积</td>
        <td>医生数量</td>
        <td>医院建立时间</td>
        <td>删除</td>
    </tr>

    <c:forEach items="${hospitalList}" var="u">
        <tr>
            <td>${u.hId}</td>
            <td>${u.deCount}</td>
            <td>${u.hArea}</td>
            <td>${u.dCount}</td>
            <td>${u.hTime}</td>
            <d><a href="HospitalAction_deleteHospital.action?id=${u.hId}">删除</a></d>
        </tr>
    </c:forEach>
</table>

<form action="HospitalAction_addHospital.action" method="post">
    <table>
          科室数量:  <input type="text" name="hospital.deCount">
          医院面积:  <input type="text" name="hospital.hArea">
          医生数量:  <input type="text" name="hospital.dCount">
          创建时间:  <input type="text" name="hospital.hTime">
          <input type="submit" value="提交">
          <input type="reset" value="取消">
    </table>
</form>
</body>
</html>
