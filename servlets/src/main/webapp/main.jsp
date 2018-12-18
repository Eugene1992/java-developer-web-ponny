<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./styles.css">
    <%--<style>
        td, th {
           border: 1px solid black;
        }

        td {
            background-color: gray;
            color: white;
        }

        .red {
            color: red;
        }

        #unique {
            color: blue;
        }
    </style>--%>
</head>
<body>
<br>
<div class="container">
    <div class="row">
        <div class="card">
            <h5 class="card-header">
                Products
                <a href="/products?action=create">
                    <button type="button" class="btn btn-success btn-sm float-right">New Product</button>
                </a>
            </h5>
            <div class="card-body">
                <table class="table table-bordered">
                        <th>
                            Title
                        </th>
                        <th>
                            Category
                        </th>
                        <th>
                            Description
                        </th>
                        <th>
                            Price
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
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <th class="red">
                                    ${product.title}
                            </th>
                            <th class="red">
                                    ${product.category}
                            </th>
                            <td id="unique" class="red">
                                    ${product.description}
                            </td>
                            <td>
                                    ${product.price}
                            </td>
                            <td class="table-btn-col">
                                <button type="button" class="btn btn-info btn-sm">
                                    <i class="fa fa-info-circle fa-sm"></i>
                                </button>
                            </td>
                            <td class="table-btn-col">
                                <a href="/products?action=update&id=${product.id}">
                                    <button type="button" class="btn btn-warning btn-sm">
                                        <i class="fa fa-edit fa-sm"></i>
                                    </button>
                                </a>
                            </td>
                            <td class="table-btn-col">
                                <a href="/products?action=delete&id=${product.id}">
                                    <button type="button" class="btn btn-danger btn-sm">
                                        <i class="fa fa-remove fa-sm"></i>
                                    </button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <img src="https://hotline.ua/img/tx/178/178801049_s265.jpg" alt="Oops, ...">
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>