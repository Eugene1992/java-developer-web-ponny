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

<br>
<main>
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="card">
                    <div class="card-header">
                        Choose search criteria
                    </div>
                    <div class="card-body">
                        <form>
                            <div class="row">
                                <div class="form-group col-lg-12">
                                    <label for="first_name">Tittle</label>
                                    <input type="text" class="form-control" id="first_name">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-lg-6">
                                    <label for="from">Price</label><br>
                                    <input type="number" class="form-control" id="from" placeholder="from">
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="to"><span style="color: white">_</span></label>
                                    <input type="number" class="form-control" id="to" placeholder="to">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-lg-12">
                                    <label for="category">Category</label>
                                    <select class="form-control" id="category">
                                        <option>Smart phones</option>
                                        <option>Tablets</option>
                                        <option>Laptops</option>
                                    </select>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-lg-12 text-center">
                                    <button type="submit" class="btn btn-primary">Search</button>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="card">
                    <div class="card-header">
                        Results
                    </div>
                    <div class="card-body">
                        <ul class="list-group">
                            <li class="list-group-item" title="Click for details"><a href="/products/details">Cras justo odio</a></li>
                            <li class="list-group-item"><a href="/products/details">Dapibus ac facilisis in</a></li>
                            <li class="list-group-item"><a href="/products/details">Morbi leo risus</a></li>
                            <li class="list-group-item"><a href="/products/details">Porta ac consectetur ac</a></li>
                            <li class="list-group-item"><a href="/products/details">Vestibulum at eros</a></li>
                            <li class="list-group-item"><a href="/products/details">Cras justo odio</a></li>
                            <li class="list-group-item"><a href="/products/details">Dapibus ac facilisis in</a></li>
                            <li class="list-group-item"><a href="/products/details">Morbi leo risus</a></li>
                            <li class="list-group-item"><a href="/products/details">Porta ac consectetur ac</a></li>
                            <li class="list-group-item"><a href="/products/details">Vestibulum at eros</a></li>
                        </ul>
                        <br>
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