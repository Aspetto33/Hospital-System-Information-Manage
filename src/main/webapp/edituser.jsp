<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/7
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="UserAction_updateUser.action" method="post">
   <br><br>
    用户名: <input type="text" name="name" value="${users.uName}"> <br><br>
    配置角色:<br>
    <div style="text-align:left;width:300px;margin:0px auto;padding-left:50px">
        <c:forEach items="${roles}" var="r">
            <c:set var="hasRole" value="false" />
            <c:forEach items="${currentRole}" var="currentRole">
                <c:if test="${r.rId==currentRole.rId}">
                    <c:set var="hasRole" value="true" />
                </c:if>
            </c:forEach>
            <input type="checkbox"  ${hasRole?"checked='checked'":"" } name="rids" value="${r.rId}"> ${r.rName}<br>
        </c:forEach>
    </div>

    <br>
    <input type="hidden" name="id" value="${users.uId}">
    <input type="submit" value="修改">
</form>
</body>
</html>
