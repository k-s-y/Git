<%--
  Date: 2022/1/14
  Time: 15:20
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/quick22" method="post">
    名称<input type="text" name="username"><br>
    文件<input type="file" name="upload"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
