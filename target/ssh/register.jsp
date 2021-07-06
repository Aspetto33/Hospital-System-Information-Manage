<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/6/30
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <form action="LoginAction_addUser.action" method="post">
        <table>
            <thead>
               <tr>用户名</tr>
               <tr>密码</tr>
            </thead>
            <tbody>
                <tr>
                    <input type="text" name="uName">
                </tr>
                <tr>
                    <input type="password" name="uPwd">
                </tr>
                <tr>
                    <input type="email" name="uEmail">
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
