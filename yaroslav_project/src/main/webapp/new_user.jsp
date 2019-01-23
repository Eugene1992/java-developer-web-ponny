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
<c:if test="${sessionScope.user.role.name == 'User' || sessionScope.user.role.name == 'Moderator'}">
    <%
        response.sendRedirect("/home");
    %>
</c:if>
    <br>
    <div class="container">
        <div class="card">
            <h5 class="card-header">
                <c:if test="${empty updUser}">
                    Creating New User
                </c:if>
                <c:if test="${not empty updUser}">
                    Editing User
                </c:if>
            </h5>
            <br>
            <div class="card-body">
                <form action="/admin" method="post">
                    <input name="user_id" type="hidden" value="${updUser.id}">
                    <div class="row">
                        <div class="form-group offset-lg-1 col-lg-4 offset-md-1 col-md-4">
                            <label for="username">Username:</label>
                            <input name="username" type="text" class="form-control" id="username" value="${updUser.username}">
                        </div>
                        <div class="form-group offset-lg-1 col-lg-4 offset-md-1 col-md-4">
                            <label for="email">Email:</label>
                            <input name="email" type="text" class="form-control" id="email" value="${updUser.userDetails.email}">
                        </div>
                        <div class="form-group offset-lg-1 col-lg-4 offset-md-1 col-md-4">
                            <label for="firstName">First Name:</label>
                            <input name="firstName" type="text" class="form-control" id="firstName" value="${updUser.userDetails.firstName}">
                        </div>
                        <div class="form-group offset-lg-1 col-lg-4 offset-md-1 col-md-4">
                            <label for="lastName">Last Name:</label>
                            <input name="lastName" type="text" class="form-control" id="lastName" value="${updUser.userDetails.lastName}">
                        </div>
                        <div class="form-group offset-lg-1 col-lg-4 offset-md-1 col-md-4">
                            <label for="phone">Phone:</label>
                            <input name="phone" type="text" class="form-control" id="phone" value="${updUser.userDetails.phone}">
                        </div>
                        <div class="form-group offset-lg-1 col-lg-4 offset-md-1 col-md-4">
                            <label for="password">Password:</label>
                            <input name="password" type="text" class="form-control" id="password" value="${updUser.password}">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group offset-lg-1 col-lg-8">
                            <label for="role">Role:</label>
                            <select name="role" class="form-control" id="role">
                                <option <c:if test="${updUser.role.name == 'Admin'}">selected</c:if>>Admin</option>
                                <option <c:if test="${updUser.role.name == 'Moderator'}">selected</c:if>>Moderator</option>
                                <option <c:if test="${updUser.role.name == 'User'}">selected</c:if>>User</option>
                            </select>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="form-group col-lg-12 text-center">
                            <c:if test="${empty updUser}">
                                <button type="submit" class="btn btn-success">Create</button>
                            </c:if>
                            <c:if test="${not empty updUser}">
                                <button type="submit" class="btn btn-warning">Update</button>
                            </c:if>
                            <button type="button" class="btn btn-danger" onclick="history.back()">Cancel</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>
