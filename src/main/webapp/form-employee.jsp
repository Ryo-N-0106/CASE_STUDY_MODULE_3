<%--
  Created by IntelliJ IDEA.
  User: Ngan
  Date: 9/8/2025
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="./create-employee" method="post">
        Full Name: <input type="text" name="full_name" value="${employee.fullName}"> <br/>
        Email:<input type="text" name="email" value="${employee.email}"> <br/>
        Phone:<input type="text" name="phone" value="${employee.phone}"> <br/>
        Address:<input type="text" name="address" value="${employee.address}"> <br/>
        <button type="submit">Lưu</button>
    </form>

</body>
</html>
