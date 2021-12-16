<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Huế Motorcycle Market | CHợ xe máy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="wrapper">
    <header class="row">
<%--        <div class="col-xl-3">--%>
<%--            <figure>--%>
<%--                <a href="home.jsp">--%>
<%--                    <img src="../front-end/images/logo.png" alt="Hue Motorcycle Market - Logo">--%>
<%--                </a>--%>
<%--            </figure>--%>
<%--        </div>--%>


        <div class="col-lg-3">
            <a href="<c:url value="/news?action=create"/>">Đăng tin bán</a>
            <a href = "<c:url value = "/homePage?action=signIn"/>">Đăng nhập</a>
            <a href = "<c:url value = "/users?action=createUser"/>">Đăng ký</a>
        </div>
    </header>

    <div class="container">
        <table style="border: 1px">
            <caption><h2> Danh sách xe bán</h2></caption>
            <tr>
                <th >#</th>
                <th>Hãng xe</th>
                <th>Loại xe</th>
                <th>Dòng xe</th>
                <th>Màu sắc</th>
                <th>Năm</th>
                <th>Số km đã đi</th>
                <th>Giá bán</th>
            </tr>
            <c:forEach var="product" items="${listProduct}">
                <tr>
                    <td><c:out value="${product.id}"/></td>
                    <td><c:out value="${product.brand}"/></td>
                    <td><c:out value="${product.type}"/></td>
                    <td><c:out value="${product.line}"/></td>
                    <td><c:out value="${product.color}"/></td>
                    <td><c:out value="${product.year}"/></td>
                    <td><c:out value="${product.price}"/></td>
                </tr>
            </c:forEach>
        </table>

    </div>
 <footer>

    </footer>
</div>
</body>
</html>
