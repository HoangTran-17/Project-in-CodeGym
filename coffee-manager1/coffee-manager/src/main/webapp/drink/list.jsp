<%--
  Created by IntelliJ IDEA.
  User: LAPTOP T&T
  Date: 12/9/2021
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Drink Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<center>
    <h1>Drink Management</h1>
    <h2>
        <a href="/drinks?action=create">Add New Drink</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Drinks</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach var="drink" items="${listDrink}">
            <tr>
                <td><c:out value="${drink.id}"/></td>
                <td><c:out value="${drink.name}"/></td>
                <td><c:out value="${drink.quantity}"/></td>
                <td><c:out value="${drink.price}"/></td>

                <td>
                    <a href="/drinks?action=edit&id=${drink.id}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>