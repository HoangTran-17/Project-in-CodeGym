
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sửa thông tin tài khoản</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div>
    <h2>
        <a href="<c:url value="/homePage?action='home'&user=${user}"/>">Trang chủ</a>
    </h2>
    <br>
    <h1>Thay đổi thông tin tài khoản</h1>

</div>
<div style="text-align: center">
    <span class="${requestScope["classCss"]}">${requestScope["message"]}</span>
    <form method="post" action="<c:url value="/users?action=editAdmin&UserId=${user.userId}"/>" class="needs-validation">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Edit User</h2>
            </caption>
            <c:if test="${user != null}">
                <input type="hidden" name="userId" value="<c:out value='${user.userId}' />"/>
            </c:if>
            <tr>
                <th>Tên đăng nhập:</th>
                <td>
                    <input type="text" name="userName"  required class="form-control" size="45"
                           value="<c:out value='${user.userName}' />" pattern="(^([A-Z]+[a-z]*[ ]?)+$)\b"
                    />
                </td>
            </tr>
            <tr>
                <th>Số điện thoại (Không thể thay đổi):</th>
                <td>
                    <p>${user.phoneNumber}</p>
                </td>
            </tr>
            <tr>
                <th>Địa chỉ:</th>
                <td>
                    <input type="text" name="address" required class="form-control"  size="45"
                           value="<c:out value='${user.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Mật khẩu:</th>
                <td>
                    <input type="password" name="password" required class="form-control"  size="45"
                           pattern="^[A-Za-z0-9]{6,12}$"
                    />
                </td>
            </tr>
            <tr>
                <th>Nhập lại mật khẩu:</th>
                <td>
                    <input type="password" name="password2" required class="form-control"  size="45"
                           pattern="^[A-Za-z0-9]{6,12}$"
                    />
                </td>
            </tr>
            <tr>
            <tr>
                <td colspan="2" align="center">
                    <button class="btn btn-outline-primary" type="submit">Lưu</button>
                </td>
            </tr>
            </tr>
        </table>
    </form>
    <h2>
        <a href="<c:url value="/homePage?action='home'&user=${user}"/>">Về trang chủ</a>
    </h2>
</div>
</body>
</html>
