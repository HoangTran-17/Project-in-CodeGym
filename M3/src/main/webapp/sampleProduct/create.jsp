<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sample Product Management</title>
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
    <h1>Sample Product Management</h1>
    <h2>
        <a href="sampleProduct?action=listSampleProduct">List All Sample Product</a>
    </h2>
</div>
<div style="align-items: center">
    <h2>Add New Sample Product</h2>
    <span class="${requestScope["classCss"]}">${requestScope["message"]}</span>
    <form method="post" action="/sampleProduct?action=create" class="needs-validation" novalidate>
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
                    <section>
                        <option>Xe tay ga</option>
                        <option>Xe số</option>
                        <option>Xe côn tay</option>
                        <option>Xe phân khối lớn</option>
                        <option>Xe dưới 50cc</option>
                    </section>
                    <input type="text" name="type" id="type" size="45" class="form-control" required pattern="(^([A-Z]+[a-z]*[ ]?)+$)\b" placeholder="Xe tay ga">

                    <div class="invalid-feedback">
                        Nhập tên hãng xe(ví dụ: HONDA).
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
                        Please enter color.
                    </div>
                </td>
            </tr>
            <tr>
                <th>Year:</th>
                <td>
                    <input type="text" name="year" required class="form-control" id="year" size="45"/>
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

