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

<main role="main">
    <div id="demo" class="carousel slide" data-ride="carousel">

        <!-- Indicators -->
        <ul class="carousel-indicators">
            <li data-target="#demo" data-slide-to="0" class="active"></li>
            <li data-target="#demo" data-slide-to="1"></li>
            <li data-target="#demo" data-slide-to="2"></li>
        </ul>

        <!-- The slideshow -->
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://apple-help.org/wp-content/uploads/2018/08/iTunes.jpg" class="carousel-img"
                     alt="Los Angeles">
            </div>
            <div class="carousel-item">
                <img src="https://apple-help.org/wp-content/uploads/2018/08/iTunes.jpg" class="carousel-img"
                     alt="Chicago">
            </div>
            <div class="carousel-item">
                <img src="https://apple-help.org/wp-content/uploads/2018/08/iTunes.jpg" class="carousel-img"
                     alt="New York">
            </div>
        </div>

        <!-- Left and right controls -->
        <a class="carousel-control-prev" href="#demo" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#demo" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>

    </div>
    <section class="jumbotron text-center">
        <div class="container">
            <h1 class="jumbotron-heading">Welcome to eShop!</h1>
            <p class="lead text-muted">Here you can find the quality products at the best price.</p>
            <p>
                <a href="/products/search" class="btn btn-primary my-2">Search products</a>
            </p>
        </div>
    </section>

    <div class="container">
        <div class="card">
            <div class="card-header">
                <i class="fa fa-apple" aria-hidden="true"></i> Apple products
            </div>
            <div class="card-body row">
                <div class="col-md-4 col-lg-4">
                    <div class="card mb-4 shadow-sm">
                        <img class="card-img-top"
                             src="https://clipart.info/images/ccovers/1505918647iphone-x-png.png"
                             alt="Card image cap">
                        <div class="card-body">
                            <div class="page-header">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <h5>IPhone X 256 GB</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <h5 class="text-right">
                                        <span style="font-weight: bold; font-size: 24px">16899 UAH</span></h5>
                                </div>
                            </div>
                            <p class="card-text">This is a wider card with supporting text below as a
                                natural lead-in to
                                additional content. This content is a little bit longer.</p>

                            <div class="d-flex justify-content-between align-items-center">
                                <small class="text-muted"><i class="fa fa-heart" aria-hidden="true"></i> 10</small>
                                <small class="text-muted"><i class="fa fa-search" aria-hidden="true"></i> 2340</small>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-info">View details
                                    </button>
                                    <button type="button" class="btn btn-sm btn-success">Add to cart
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-4">
                    <div class="card mb-4 shadow-sm">
                        <img class="card-img-top"
                             src="https://clipart.info/images/ccovers/1505918647iphone-x-png.png"
                             alt="Card image cap">
                        <div class="card-body">
                            <div class="page-header">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <h5>IPhone X 256 GB</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <h5 class="text-right">
                                        <span style="font-weight: bold; font-size: 24px">14224 UAH</span></h5>
                                    <h5 class="text-right"><span class="badge badge-pill badge-primary">-20%</span>
                                        <span style="text-decoration: line-through; color: darkgray">16899 UAH</span>
                                    </h5>
                                </div>
                            </div>
                            <p class="card-text">This is a wider card with supporting text below as a
                                natural lead-in to
                                additional content. This content is a little bit longer.</p>

                            <div class="d-flex justify-content-between align-items-center">
                                <small class="text-muted"><i class="fa fa-heart" aria-hidden="true"></i> 10</small>
                                <small class="text-muted"><i class="fa fa-search" aria-hidden="true"></i> 2340</small>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-info">View details
                                    </button>
                                    <button type="button" class="btn btn-sm btn-success">Add to cart
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-4">
                    <div class="card mb-4 shadow-sm">
                        <img class="card-img-top"
                             src="https://clipart.info/images/ccovers/1505918647iphone-x-png.png"
                             alt="Card image cap">
                        <div class="card-body">
                            <div class="page-header">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <h5>IPhone X 256 GB</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <h5 class="text-right">
                                        <span style="font-weight: bold; font-size: 24px">16899 UAH</span></h5>
                                </div>
                            </div>
                            <p class="card-text">This is a wider card with supporting text below as a
                                natural lead-in to
                                additional content. This content is a little bit longer.</p>

                            <div class="d-flex justify-content-between align-items-center">
                                <small class="text-muted"><i class="fa fa-heart" aria-hidden="true"></i> 10</small>
                                <small class="text-muted"><i class="fa fa-search" aria-hidden="true"></i> 2340</small>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-info">View details
                                    </button>
                                    <button type="button" class="btn btn-sm btn-success">Add to cart
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-4">
                    <div class="card mb-4 shadow-sm">
                        <img class="card-img-top"
                             src="https://clipart.info/images/ccovers/1505918647iphone-x-png.png"
                             alt="Card image cap">
                        <div class="card-body">
                            <div class="page-header">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <h5>IPhone X 256 GB</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <h5 class="text-right">
                                        <span style="font-weight: bold; font-size: 24px">16899 UAH</span></h5>
                                </div>
                            </div>
                            <p class="card-text">This is a wider card with supporting text below as a
                                natural lead-in to
                                additional content. This content is a little bit longer.</p>

                            <div class="d-flex justify-content-between align-items-center">
                                <small class="text-muted"><i class="fa fa-heart" aria-hidden="true"></i> 10</small>
                                <small class="text-muted"><i class="fa fa-search" aria-hidden="true"></i> 2340</small>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-info">View details
                                    </button>
                                    <button type="button" class="btn btn-sm btn-success">Add to cart
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <br>
    <div class="container">
        <div class="card">
            <div class="card-header">
                Some category 2
            </div>
            <div class="card-body row">
                <div class="col-md-4 col-lg-4">
                    <div class="card mb-4 shadow-sm">
                        <img class="card-img-top"
                             data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail"
                             alt="Card image cap">
                        <div class="card-body">
                            <p class="card-text">This is a wider card with supporting text below as a
                                natural lead-in to
                                additional content. This content is a little bit longer.</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">View
                                    </button>
                                    <button type="button" class="btn btn-sm btn-outline-secondary">Edit
                                    </button>
                                </div>
                                <small class="text-muted">9 mins</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-4">
                    <div class="card mb-4 shadow-sm">
                        <img class="card-img-top"
                             data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail"
                             alt="Card image cap">
                        <div class="card-body">
                            <p class="card-text">This is a wider card with supporting text below as a
                                natural lead-in to
                                additional content. This content is a little bit longer.</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">View
                                    </button>
                                    <button type="button" class="btn btn-sm btn-outline-secondary">Edit
                                    </button>
                                </div>
                                <small class="text-muted">9 mins</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-4">
                    <div class="card mb-4 shadow-sm">
                        <img class="card-img-top"
                             data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail"
                             alt="Card image cap">
                        <div class="card-body">
                            <p class="card-text">This is a wider card with supporting text below as a
                                natural lead-in to
                                additional content. This content is a little bit longer.</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">View
                                    </button>
                                    <button type="button" class="btn btn-sm btn-outline-secondary">Edit
                                    </button>
                                </div>
                                <small class="text-muted">9 mins</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-4">
                    <div class="card mb-4 shadow-sm">
                        <img class="card-img-top"
                             data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail"
                             alt="Card image cap">
                        <div class="card-body">
                            <p class="card-text">This is a wider card with supporting text below as a
                                natural lead-in to
                                additional content. This content is a little bit longer.</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">View
                                    </button>
                                    <button type="button" class="btn btn-sm btn-outline-secondary">Edit
                                    </button>
                                </div>
                                <small class="text-muted">9 mins</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-4">
                    <div class="card mb-4 shadow-sm">
                        <img class="card-img-top"
                             data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail"
                             alt="Card image cap">
                        <div class="card-body">
                            <p class="card-text">This is a wider card with supporting text below as a
                                natural lead-in to
                                additional content. This content is a little bit longer.</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">View
                                    </button>
                                    <button type="button" class="btn btn-sm btn-outline-secondary">Edit
                                    </button>
                                </div>
                                <small class="text-muted">9 mins</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-4">
                    <div class="card mb-4 shadow-sm">
                        <img class="card-img-top"
                             data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail"
                             alt="Card image cap">
                        <div class="card-body">
                            <p class="card-text">This is a wider card with supporting text below as a
                                natural lead-in to
                                additional content. This content is a little bit longer.</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">View
                                    </button>
                                    <button type="button" class="btn btn-sm btn-outline-secondary">Edit
                                    </button>
                                </div>
                                <small class="text-muted">9 mins</small>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <div class="container">
        <div class="card">
            <div class="card-header">
                Some category 3
            </div>
            <div class="card-body row">
                <div class="col-md-4 col-lg-4">
                    <div class="card mb-4 shadow-sm">
                        <img class="card-img-top"
                             data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail"
                             alt="Card image cap">
                        <div class="card-body">
                            <p class="card-text">This is a wider card with supporting text below as a
                                natural lead-in to
                                additional content. This content is a little bit longer.</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">View
                                    </button>
                                    <button type="button" class="btn btn-sm btn-outline-secondary">Edit
                                    </button>
                                </div>
                                <small class="text-muted">9 mins</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-4">
                    <div class="card mb-4 shadow-sm">
                        <img class="card-img-top"
                             data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail"
                             alt="Card image cap">
                        <div class="card-body">
                            <p class="card-text">This is a wider card with supporting text below as a
                                natural lead-in to
                                additional content. This content is a little bit longer.</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">View
                                    </button>
                                    <button type="button" class="btn btn-sm btn-outline-secondary">Edit
                                    </button>
                                </div>
                                <small class="text-muted">9 mins</small>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<footer class="text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#">Back to top</a>
        </p>
        <p>Album example is &copy; Bootstrap, but please download and customize it for yourself!</p>
        <p>New to Bootstrap? <a href="../../">Visit the homepage</a> or read our <a href="../../getting-started/">getting
            started guide</a>.</p>
    </div>
</footer>

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