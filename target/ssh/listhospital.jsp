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
<script language="JavaScript" type="text/javascript">
    function deleteInfo(hId){
        if(confirm("确定要删除该数据吗")){
            document.hospital.action = "HospitalAction_deleteHospital.action?hId"+hId;
            document.hospital.submit();
        }
    }
</script>
<form id = "hospital">
<table>
    <c:forEach items="${hospitalList}" var="u">
        <tr>
            <td>${u.hId}</td>
            <td>${u.deCount}</td>
            <td>${u.dCount}</td>
            <td><input type="button" onclick="deleteInfo(<s:property value="u.hId"/>)" value="删除"></td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>
