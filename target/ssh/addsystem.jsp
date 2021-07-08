<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/5
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="SystemAction_addSystem.action" method="post">
    <table>
        <tr>
            <td>系统名称</td>
            <td>版本</td>
        </tr>
        <br><br>
        <tr>
            <input type="text" name="systems.sName">
        </tr>
        <tr>
            <input type="text" name="systems.sVersion">
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
            <td>
                <input type="reset" value="取消">
            </td>
        </tr>
        </tbody>
    </table>
</form>

</body>
</html>
