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
        <div class="card">
            <h5 class="card-header">
                New Discount
            </h5>
            <br>
            <div class="card-body">
                <form action="/discounts" method="post">
                    <input name="id" type="hidden" value="${updDiscount.id}">
                    <div class="row">
                        <div class="form-group offset-lg-2 col-lg-4 offset-md-2 col-md-4">
                            <label for="name">Name:</label>
                            <input name="name" type="text" class="form-control" id="name" value="${updDiscount.name}">
                        </div>
                        <div class="form-group col-lg-4 col-md-4">
                            <label for="amount">Amount:</label>
                            <input name="amount" type="text" class="form-control" step = "0.01" id="amount" value="${updDiscount.amount}">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-lg-12 text-center">
                            <c:if test="${empty updDiscount}">
                                <button type="submit" class="btn btn-success">Create</button>
                            </c:if>
                            <c:if test="${not empty updDiscount}">
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
