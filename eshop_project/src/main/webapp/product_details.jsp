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
            <ul class="nav nav-pills">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Details</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Characteristics</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Comments</a>
                </li>
            </ul>
        </div>
        <br>
        <div class="row">
            <div class="col-lg-6">
                <img class="card-img-top"
                     src="https://clipart.info/images/ccovers/1505918647iphone-x-png.png"
                     alt="Card image cap">
            </div>
            <div class="col-lg-6">
                <h5>IPhone X 256 GB</h5>
                <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                    This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                    This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                    This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                    This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                <h3 class="text-right">
                    <span>14224 UAH</span></h3>
                <h5 class="text-right"><span class="badge badge-pill badge-primary">-20%</span>
                    <span style="text-decoration: line-through; color: darkgray">16899 UAH</span>
                </h5>
                <button type="button" class="btn btn-lg btn-success float-right">Buy now
                </button>
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