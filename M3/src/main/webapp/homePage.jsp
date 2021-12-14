<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10-Dec-21
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Huế Motorcycle Market | CHợ xe máy</title>
    <style>

    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>

  </head>
  <body>
    <div class="wrapper">
      <header class="row">
<%--        <div class="col-sm-3 col-md-6 col-lg-4 col-xl-2">....</div>--%>
<%--        <div class="col-sm-9 col-md-6 col-lg-8 col-xl-10">....</div>--%>
        <div class="col-xl-3">
          <figure>
            <a href="homePage.jsp">
              <img src="front-end/images/logo.png" alt="Hue Motorcycle Market - Logo">
            </a>
          </figure>
        </div>

        <div class="col-lg-6">
          <h3>Chợ xe Huế</h3>
        </div>

        <div class="col-lg-3">
            <a href="${pageContext.request.contextPath}/users?action=createUser">Đăng ký</a>
            <a href="<c:url value="/users?action=createUser"/>">Đăng ký</a>
            <a href="<c:url value="/users?action=createUser"/>">Đăng ký</a>
        </div>
      </header>

      <div class="container">

      </div>

      <footer>

      </footer>
    </div>
  </body>
</html>
