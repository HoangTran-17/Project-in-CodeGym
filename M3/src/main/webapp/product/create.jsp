<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Đăng xe bán</title>
    <style>
        .message.success {
            color: green;
        }

        .message.error {
            color: red;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<div>
    <h1>Đăng xe bán</h1>

</div>
<div style="align-items: center">
    <h2>Đăng xe bán</h2>
    <span class="${requestScope["classCss"]}">${requestScope["message"]}</span>
    <form method="post" action="<c:url value="/news?action=create&userId=${user.userId}"/>" class="needs-validation" novalidate>
        <table border="1" cellpadding="5">
            <tr>
                <th>Hãng xe:</th>
                <td>
                    <input type="text" name="brand" id="brand" size="45" class="form-control" required pattern="(^([A-Z]+[a-z]*[ ]?)+$)\b" placeholder="HONDA">

                    <div class="invalid-feedback">
                        Nhập tên hãng xe(ví dụ: HONDA).
                    </div>
                </td>
            </tr>
            <tr>
                <th>Loại xe:</th>
                <td>
                    <input type="text" name="type" id="type" size="45" class="form-control" required pattern="(^([A-Z]+[a-z]*[ ]?)+$)\b" placeholder="Xe tay ga">

                    <div class="invalid-feedback">
                        Nhập tên loại xe(ví dụ: Xe tay ga).
                    </div>
                </td>
            </tr>
            <tr>
                <th>Dòng xe:</th>
                <td>
                    <input type="text" name="line" id="line" size="45" class="form-control" required pattern="(^([A-Z]+[a-z]*[ ]?)+$)\b" placeholder="HONDA">

                    <div class="invalid-feedback">
                        Nhập tên dòng xe(Ví dụ: SH 300).
                    </div>
                </td>
            </tr>
            <tr>
                <th>Màu sắc:</th>
                <td class="input-group">
                    <input type="text" name="color" class="form-control" id="color" size="45" required />
                    <div class="invalid-feedback">
                        Nhập màu xe
                    </div>
                </td>
            </tr>
            <tr>
                <th>Số km đã đi:</th>
                <td class="input-group">
                    <input type="text" name="km" class="form-control" id="km" size="45" required />
                    <div class="invalid-feedback">
                        Nhập số km đã đi (Ví dụ: dưới 20,000km).
                    </div>
                </td>
            </tr>
            <tr>
                <th>Đời xe:</th>
                <td class="input-group">
                    <input type="number" name="year" class="form-control" id="year" size="45" required />
                    <div class="invalid-feedback">
                        Nhập đời xe (Ví dụ: 2017)
                    </div>
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" required class="form-control" id="price" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Mô tả:</th>
                <td>
                    <input type="text" name="description" required class="form-control" id="description" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button class="btn btn-outline-primary" type="submit">Save</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<script>(function () {
    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
        .forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (document.getElementById("name").value.trim().length === 0)
                    document.getElementById("name").value = "";
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }

                form.classList.add('was-validated')
            }, false)
        })
})()</script>
</body>
</html>

