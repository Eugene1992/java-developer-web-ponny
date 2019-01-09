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

<jsp:include page="header.jsp" />
<br>
<main>
    <div class="container">
        <div class="row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
                <div class="card">
                    <div class="card-header">
                        New user creation
                    </div>
                    <div class="card-body">
                        <form>
                            <div class="row">
                                <div class="form-group col-lg-6">
                                    <label for="first_name">First name</label>
                                    <input type="text" class="form-control" id="first_name">
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="last_name">Last name</label>
                                    <input type="text" class="form-control" id="last_name">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-lg-6">
                                    <label for="username">Username</label>
                                    <input type="text" class="form-control" id="username">
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="last_name">Email</label>
                                    <input type="email" class="form-control" id="email">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-lg-6">
                                    <label for="role">Role</label>
                                    <select class="form-control" id="role">
                                        <option>ADMIN</option>
                                        <option>USER</option>
                                        <option>MODERATOR</option>
                                    </select>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-lg-12 text-center">
                                    <button type="submit" class="btn btn-success">Create</button>
                                    <button type="button" class="btn btn-danger">Cancel</button>
                                </div>
                            </div>

                        </form>
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
<script src="zhenia/scripts.js"></script>
</body>
</html>