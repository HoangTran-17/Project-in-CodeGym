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
<%--        <div style="text-align: center">--%>
<%--            <h1>Welcome to Hue Motorcycle Market</h1>--%>
<%--            <br>--%>
<%--            <p></p>--%>
<%--            <br>--%>
<%--&lt;%&ndash;            <a href="<c:url ><value>/homePage?action=logOut</value></c:url>">Logout</a>&ndash;%&gt;--%>
<%--        </div>--%>


    </div>
 <footer>

    </footer>
</div>
</body>
</html>
