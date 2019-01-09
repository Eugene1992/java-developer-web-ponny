<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<c:url value="/styles.css"/>">
</head>
<body>
    <br>
    <div class="container">
        <div class="row">
            <div class="card">
                <h5 class="card-header">
                    Discounts
                    <a href="/users?action=create">
                        <button type="button" class="btn btn-success btn-sm float-right">New User</button>
                    </a>
                </h5>
                <div class="card-body">
                    <table class="table table-bordered">
                        <tr>
                            <th>
                                Id
                            </th>
                            <th>
                                Role
                            </th>
                            <th>
                                Username
                            </th>
                            <th>
                                FirstName
                            </th>
                            <th>
                                LastName
                            </th>
                            <th>
                                Email
                            </th>
                            <th>
                                Info
                            </th>
                            <th>
                                Update
                            </th>
                            <th>
                                Delete
                            </th>
                        </tr>
                        <c:forEach var = "user" items="${users}">
                            <tr>
                                <td>
                                        ${user.id}
                                </td>
                                <td>
                                        ${user.roleId}
                                </td>
                                <td>
                                        ${user.username}
                                </td>
                                <td>
                                        ${user.getFirstName()}
                                </td>
                                <td>
                                        ${user.getLastName()}
                                </td>
                                <td>
                                        ${user.getEmail()}
                                </td>
                                <td class="table-btn-col">
                                    <button type="button" class="btn btn-info btn-sm"><i class="fa fa-info-circle fa-xs fa-lg"></i></button>
                                </td>
                                <td class="table-btn-col">
                                    <a href="/users?action=update&id=${user.id}">
                                        <button type="button" class="btn btn-warning btn-sm">
                                            <i class="fa fa-edit fa-xs fa-lg"></i>
                                        </button>
                                    </a>
                                </td>
                                <td class="table-btn-col">
                                    <a href="/users?action=delete&id=${user.id}">
                                        <button type="button" class="btn btn-danger btn-sm">
                                            <i class="fa fa-remove fa-xs fa-lg"></i>
                                        </button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>



    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>
