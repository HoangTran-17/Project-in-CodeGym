
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Đăng ký</title>
    <style>

    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<%--<center>--%>
<%--    <h1>User Management</h1>--%>
<%--    <h2>--%>
<%--        <a href="users?action=users">List All Users</a>--%>
<%--    </h2>--%>
<%--</center>--%>
<div align="center">
    <h2>Nhập thông tin người dùng</h2>
    <span class="${requestScope["classCss"]}">${requestScope["message"]}</span>
    <form method="post" action="${pageContext.request.contextPath}/users?action=createUser" class="needs-validation" novalidate>
        <table border="1" cellpadding="5">
            <tr>
                <th>Tên đăng nhập:</th>
                <td>
                    <input type="text" name="userName" id="userName" size="45" class="form-control" required pattern="(^[ A-Za-z0-9]{6,20}$)\b" placeholder="Hoàng Trần">

                    <div class="invalid-feedback">
                        Vui lòng nhập tên đăng nhập (ví dụ: Hoàng Trần).
                    </div>
                </td>
            </tr>
            <tr>
                <th>Số điện thoại:</th>
                <td>
                    <input type="text" name="phoneNumber" required class="form-control" id="phoneNumber" size="15" pattern="(84|0[3|5|7|8|9])+([0-9]{8})\b" placeholder="0987654321"/>
                    <div class="invalid-feedback">
                        Vui lòng nhập số điện thoại (ví dụ: 0987654321).
                    </div>
                </td>
            </tr>
            <tr>
                <th>Địa chỉ:</th>
                <td>
                    <input type="text" required class="form-control" name="address" id="address" size="45" placeholder="131/15 Trần Phú, Tp.Huế"/>
                    <div class="invalid-feedback">
                        Vui lòng nhập địa chỉ!
                    </div>
                </td>
            </tr>
            <tr>
                <th>Mật khẩu:</th>
                <td>
                    <input type="password" required class="form-control" name="password1" id="password1" size="15" pattern="^[A-Za-z0-9]{6,12}$"/>
                    <div class="invalid-feedback">
                        Vui lòng nhập mật khẩu!
                    </div>
                </td>
            </tr>
            <tr>
            <th>Nhập lại mật khẩu:</th>
            <td>
                <input type="password" required class="form-control" name="password2" id="password2" size="15" pattern="^[A-Za-z0-9]{6,12}$"/>
                <div class="invalid-feedback">
                    Vui lòng nhập mật khẩu!
                </div>
            </td>
        </tr>
            <tr>
                <td colspan="2" align="center">
                    <button class="btn btn-outline-primary" type="submit">Đăng ký</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<script>
    (function () {
    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    let forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
        .forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (document.getElementById("userName").value.trim().length === 0)
                    document.getElementById("userName").value = "";
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }
                form.classList.add('was-validated')
            }, false)
        })
    })()
</script>
</body>
</html>
