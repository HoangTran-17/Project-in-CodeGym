<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Supper Admin Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div>
    <h2>
        <a href="${pageContext.request.contextPath}/supperAdmin?action=createAdmin">Add new admin</a>
    </h2>
</div>
<div style="text-align: center">
    <table >
        <caption><h2>List Admin</h2></caption>
        <tr>
            <th>Tên</th>
            <th>SĐT</th>
            <th>Trạng thái</th>
            <th>Địa chỉ</th>
            <th>Mật khẩu</th>
        </tr>
        <c:forEach var="admin" items="${listAdmin}">
            <tr>
                <td><c:out value="${admin.userName}"/></td>
                <td><c:out value="${admin.phoneNumber}"/></td>
                <td><c:out value="${admin.status}"/></td>
                <td><c:out value="${admin.address}"/></td>
                <td><c:out value="${admin.password}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/supperAdmin?action=edit&userId=${admin.userId}">Edit</a>
                    <a href="${pageContext.request.contextPath}/supperAdmin?action=delete&userId=${admin.userId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
