<%--
  Created by IntelliJ IDEA.
  User: 83501
  Date: 2021/3/17
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="uploadCsv" method="post" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="file"/>
    <br/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
