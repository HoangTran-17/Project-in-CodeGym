<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Đăng nhập</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div>
    <h2>Đăng nhập</h2>
    <span class="${requestScope["classCss"]}">${requestScope["message"]}</span>
    <form action="${pageContext.request.contextPath}/homePage?action=signIn" method="post" class="needs-validation" novalidate>
        <table style="border: 1px"   cellpadding="5">
            <tr>
                <th>Số điện thoại:</th>
                <td>
                    <input type="text" name="phoneNumber" required class="form-control" id="phoneNumber" size="15" pattern="(84|0[3|5|7|8|9])+([0-9]{8})\b" placeholder="0987654321"/>
                    <div class="invalid-feedback">
                        Vui lòng nhập số điện thoại.
                    </div>
                </td>
            </tr>
            <tr>
                <th>Mật khẩu:</th>
                <td>
                    <input type="password" required class="form-control" name="password" id="password" size="15" pattern="^[A-Za-z0-9]{6,12}$"/>
                    <div class="invalid-feedback">
                        Vui lòng nhập mật khẩu!
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="2" >
                    <button class="btn btn-outline-primary" type="submit">Đăng nhập</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
