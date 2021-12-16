<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div>
    <h2>
        <a href="<c:url value="/homePage?action='home'&user=${user}"/>">Trang chủ</a>
    </h2>
</div>
<div style="text-align: center">
    <table >
        <caption><h2>List User</h2></caption>
        <tr>
            <th>Tên</th>
            <th>SĐT</th>
            <th>Trạng thái</th>
            <th>Địa chỉ</th>
            <th>Mật khẩu</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.phone}"/></td>
                <td><c:out value="${user.status}"/></td>
                <td><c:out value="${user.address}"/></td>
                <td><c:out value="${user.password}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
