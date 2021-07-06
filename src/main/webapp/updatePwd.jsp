<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/3
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="LoginAction_updateUpwd.action" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td>密码</td>
                <td>新密码</td>
                <td>确认密码</td>
            </tr>
            <tr>
                <td>
                    <input type="text" name="uName">
                </td>
                <td>
                    <input type="password" name="uPwd">
                </td>
                <td>
                    <input type="password" name="newupwd">
                </td>
                <td>
                    <input type="password" name="upwd1">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="提交">
                </td>
                <td>
                    <input type="reset" value="取消">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
