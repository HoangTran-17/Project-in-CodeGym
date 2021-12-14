<%--
  Created by IntelliJ IDEA.
  User: LAPTOP T&T
  Date: 12/9/2021
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>fullName</th>
            <th>status</th>
            <th>role</th>
            <th>username</th>
            <th>birthday</th>
            <th>phoneNumber</th>
            <th>address</th>
            <th>action</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.fullName}"/></td>
                <td><c:out value="${user.status}"/></td>
                <td><c:out value="${user.role}"/></td>
                <td><c:out value="${user.username}"/></td>
                <td><c:out value="${user.birthDay}"/></td>
                <td><c:out value="${user.phoneNumber}"/></td>
                <td><c:out value="${user.address}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
