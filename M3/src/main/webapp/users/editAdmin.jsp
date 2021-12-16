
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Admin </title>
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
<center>
    <h1>Supper Admin Management</h1>
    <h2>
        <a href="<c:url value="/supperAdmin"/>">List All Admin</a>
    </h2>
</center>
<div align="center">
    <span class="${requestScope["classCss"]}">${requestScope["message"]}</span>
    <form method="post" action="<c:url value="/supperAdmin?action=editAdmin"/>" class="needs-validation">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Edit User</h2>
            </caption>
            <c:if test="${user != null}">
                <input type="hidden" name="userId" value="<c:out value='${user.userId}' />"/>
            </c:if>
            <tr>
                <th>Tên:</th>
                <td>
                    <input type="text" name="userName"  required class="form-control" size="45"
                           value="<c:out value='${user.userName}' />" pattern="(^([A-Z]+[a-z]*[ ]?)+$)\b"
                    />
                </td>
            </tr>
            <tr>
                <th>Trạng thái:</th>
                <td>
                    <select  type="text" name="status">
                        <option value="${user.status.value}" selected>${user.status}</option>
                        <c:forEach items="${statusList}" var="item">
                            <c:if test="${item != user.status}">
                                <option value="${item.value}">${item}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Vai trò:</th>
                <td>
                    <select  type="text" name="role">
                        <option value="${user.role.value}" selected>${user.role}</option>
                        <c:forEach items="${roleList}" var="item">
                            <c:if test="${item != user.role}">
                                <option value="${item.value}">${item}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Số điện thoại:</th>
                <td>
                    <input type="text" name="phoneNumber" required class="form-control"  size="45"
                           value="<c:out value='${user.phoneNumber}' />"
                    />
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
</div>
</body>
</html>
