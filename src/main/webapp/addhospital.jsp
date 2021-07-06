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
  <form action="HospitalAction_addHospital" method="post">
    <table>
      <thead>
      <tr>用户名</tr>
      <tr>密码</tr>
      </thead>
      <tbody>
      <tr>
        <input type="text" name="hospital.deCount">
      </tr>
      <tr>
        <input type="text" name="hospital.hArea">
      </tr>
      <tr>
        <input type="text" name="hospital.dCount">
      </tr>
      <tr>
        <input type="text" name="hospital.hTime">
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
