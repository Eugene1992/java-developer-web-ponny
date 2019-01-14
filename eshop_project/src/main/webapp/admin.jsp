<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">

    <title>eShop</title>

</head>
<body>

<jsp:include page="./header.jsp" />

<main>
    <div class="container">
        <br>
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link active" id="home-tab" data-toggle="tab" href="#users" role="tab" aria-controls="home"
                   aria-selected="true"><i class="fa fa-user fa-fw fa-lg"></i>Users</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="discount-tab" data-toggle="tab" href="#products" role="tab"
                   aria-controls="contact" aria-selected="false">Products</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="profile-tab" data-toggle="tab" href="#discounts" role="tab"
                   aria-controls="discounts" aria-selected="false">Discounts</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact" role="tab"
                   aria-controls="contact" aria-selected="false">Categories</a>
            </li>

        </ul>
        <div class="tab-content">
            <!-- Users tab content-->
            <div class="tab-pane fade show active" id="users">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="input-group margin-top-bottom-15">
                            <a href="/admin/users/new">
                                <button class="btn btn-success" type="button">New User</button>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="input-group margin-top-bottom-15">
                            <input type="text" class="form-control" placeholder=" Search by username"
                                   aria-label="Username" aria-describedby="button-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-outline-secondary" type="button" id="button-addon2">Search
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Email</th>
                        <th>Info</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>John</td>
                        <td>Doe</td>
                        <td>john@example.com</td>
                        <td class="table-btn-col">
                            <button type="button" class="btn btn-info btn-sm"><i
                                    class="fa fa-info-circle fa-xs fa-lg"></i></button>
                        </td>
                        <td class="table-btn-col">
                            <button type="button" class="btn btn-warning btn-sm"><i class="fa fa-edit fa-xs fa-lg"></i>
                            </button>
                        </td>
                        <td class="table-btn-col">
                            <button type="button" class="btn btn-danger btn-sm"><i class="fa fa-remove fa-xs fa-lg"></i>
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td>Mary</td>
                        <td>Moe</td>
                        <td>mary@example.com</td>
                        <td class="table-btn-col">
                            <button type="button" class="btn btn-info btn-sm"><i
                                    class="fa fa-info-circle fa-xs fa-lg"></i></button>
                        </td>
                        <td class="table-btn-col">
                            <button type="button" class="btn btn-warning btn-sm"><i class="fa fa-edit fa-xs fa-lg"></i>
                            </button>
                        </td>
                        <td class="table-btn-col">
                            <button type="button" class="btn btn-danger btn-sm"><i class="fa fa-remove fa-xs fa-lg"></i>
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td>July</td>
                        <td>Dooley</td>
                        <td>july@example.com</td>
                        <td class="table-btn-col">
                            <button type="button" class="btn btn-info btn-sm"><i
                                    class="fa fa-info-circle fa-xs fa-lg"></i></button>
                        </td>
                        <td class="table-btn-col">
                            <button type="button" class="btn btn-warning btn-sm"><i class="fa fa-edit fa-xs fa-lg"></i>
                            </button>
                        </td>
                        <td class="table-btn-col">
                            <button type="button" class="btn btn-danger btn-sm"><i class="fa fa-remove fa-xs fa-lg"></i>
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="row">
                    <div class="col-lg-1">
                        <select class="form-control">
                            <option>10</option>
                            <option>20</option>
                            <option>50</option>
                        </select>
                    </div>
                    <div class="col-lg-5"></div>
                    <div class="col-lg-6">
                        <ul class="pagination float-right">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                    <span class="sr-only">Previous</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Discounts tab content-->
            <div class="tab-pane fade" id="discounts">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="input-group margin-top-bottom-15">
                            <a href="/admin/users/new">
                                <button class="btn btn-success" type="button">New User</button>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="input-group margin-top-bottom-15">
                            <input type="text" class="form-control" placeholder=" Search by username"
                                   aria-label="Username" aria-describedby="button-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-outline-secondary" type="button" id="button-addon2">Search
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Amount(%)</th>
                        <th>Info</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>NY</td>
                        <td>28.12.2019</td>
                        <td>31.12.2019</td>
                        <td>12</td>
                        <td class="table-btn-col">
                            <button type="button" class="btn btn-info btn-sm"><i
                                    class="fa fa-info-circle fa-xs fa-lg"></i></button>
                        </td>
                        <td class="table-btn-col">
                            <button type="button" class="btn btn-warning btn-sm"><i class="fa fa-edit fa-xs fa-lg"></i>
                            </button>
                        </td>
                        <td class="table-btn-col">
                            <button type="button" class="btn btn-danger btn-sm"><i class="fa fa-remove fa-xs fa-lg"></i>
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="row">
                    <div class="col-lg-1">
                        <select class="form-control">
                            <option>10</option>
                            <option>20</option>
                            <option>50</option>
                        </select>
                    </div>
                    <div class="col-lg-5"></div>
                    <div class="col-lg-6">
                        <ul class="pagination float-right">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                    <span class="sr-only">Previous</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

            </div>
            <!-- Products tab content-->
            <div class="tab-pane fade" id="products">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="input-group margin-top-bottom-15">
                            <a href="/new_user_form">
                                <button class="btn btn-success" type="button">New Product</button>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="input-group margin-top-bottom-15">
                            <input type="text" class="form-control" placeholder=" Search by username"
                                   aria-label="Username" aria-describedby="button-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-outline-secondary" type="button">Search</button>
                            </div>
                        </div>
                    </div>
                </div>

                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Created</th>
                        <th>Modified</th>
                        <th>Is active</th>
                        <th>Info</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Milk</td>
                        <td>Eat</td>
                        <td>31$</td>
                        <td>14.12.2018</td>
                        <td>18.12.2018</td>
                        <td>True</td>
                        <td class="table-btn-col">
                            <button type="button" class="btn btn-info btn-sm"><i
                                    class="fa fa-info-circle fa-xs fa-lg"></i></button>
                        </td>
                        <td class="table-btn-col">
                            <button type="button" class="btn btn-warning btn-sm"><i class="fa fa-edit fa-xs fa-lg"></i>
                            </button>
                        </td>
                        <td class="table-btn-col">
                            <button type="button" class="btn btn-danger btn-sm"><i class="fa fa-remove fa-xs fa-lg"></i>
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="row">
                    <div class="col-lg-1">
                        <select class="form-control">
                            <option>10</option>
                            <option>20</option>
                            <option>50</option>
                        </select>
                    </div>
                    <div class="col-lg-5"></div>
                    <div class="col-lg-6">
                        <ul class="pagination float-right">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                    <span class="sr-only">Previous</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>
</main>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="scripts.js"></script>
</body>
</html>