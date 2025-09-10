<%--
  Created by IntelliJ IDEA.
  User: Ngan
  Date: 9/8/2025
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
</head>
<body>

    <a href="./create-employee">
        <button type="submit">Thêm mới nhân viên</button>
    </a>

    <table>
        <tr>
            <td>ID</td>
            <td>Full Name</td>
            <td>Email</td>
            <td>Phone</td>
            <td>Address</td>
            <td>Actions</td>
        </tr>

        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.fullName}</td>
                <td>${employee.email}</td>
                <td>${employee.phone}</td>
                <td>${employee.address}</td>
                <td>
                    <a href="./edit-employee?id=${employee.id}">
                        <button type="submit">Sửa</button>
                    </a>
                    <a href="./delete-employee?id=${employee.id}">
                        <button type="submit">Xóa</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
