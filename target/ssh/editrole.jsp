<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/7
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="RoleAction_updateRole.action" method="post">
    角色名: <input type="text" name="name" value="${role.rName}"> <br>
    角色描述: <input type="text" name="desc_" value="${role.desc}" > <br><br>
    配置权限:<br>
    <div style="text-align:left;width:300px;margin:0px auto;padding-left:50px">
        <c:forEach items="${ps}" var="p">
            <c:set var="hasPermission" value="false" />
            <c:forEach items="${currentPermission}" var="currentPermission">
                <c:if test="${p.pId==currentPermission.pId}">
                    <c:set var="hasPermission" value="true" />
                </c:if>
            </c:forEach>
            <input type="checkbox"  ${hasPermission?"checked='checked'":"" } name="pids" value="${p.pId}"> ${p.name}<br>
        </c:forEach>
    </div>

    <input type="hidden" name="id" value="${role.rId}">
    <input type="submit" value="修改">
</form>
</body>
</html>
