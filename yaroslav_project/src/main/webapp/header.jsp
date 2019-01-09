<header>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
        <a class="navbar-brand" href="/"><i class="fa fa-shopping-cart fa-fw fa-lg theme-blue"></i>eShop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
                aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item" data-toggle="collapse" data-target="#navbarToggleExternalContent"
                    aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
                    <a class="nav-link" href="#">Categories</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Discounts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Search</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin">Admin</a>
                </li>
            </ul>
            <div class="dropdown margin-left-10">
                <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-shopping-cart fa-lg"></i> <span class="badge badge-light">3</span>
                </button>
                <div class="dropdown-menu shopping-cart-dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th class="shopping-cart-no-border">Review order</th>
                            <th class="shopping-cart-no-border"></th>
                            <th class="shopping-cart-no-border"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>IPhone X 256 GB</td>
                            <td class="shopping-cart-item-control"><a href="" class="shopping-cart-link"><i class="fa fa-plus fa-fw"></i></a> 1 <a href="" class="shopping-cart-link"><i class="fa fa-minus fa-fw"></i></a></td>
                            <td class="shopping-cart-item-control">16999 UAH</td>
                        </tr>
                        <tr>
                            <td>IPhone X 256 GB</td>
                            <td class="shopping-cart-item-control"><a href="" class="shopping-cart-link"><i class="fa fa-plus fa-fw"></i></a> 2 <a href="" class="shopping-cart-link"><i class="fa fa-minus fa-fw"></i></a></td>
                            <td class="shopping-cart-item-control">16999 UAH</td>
                        </tr>
                        <tr>
                            <td>IPhone X 256 GB</td>
                            <td class="shopping-cart-item-control"><a href="" class="shopping-cart-link"><i class="fa fa-plus fa-fw"></i></a> 1 <a href="" class="shopping-cart-link"><i class="fa fa-minus fa-fw"></i></a></td>
                            <td class="shopping-cart-item-control">16999 UAH</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td class="shopping-cart-item-control"><b>Total price:</b></td>
                            <td class="shopping-cart-item-control"><b>55999 UAH</b></td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="form-group float-right">
                        <button class="btn btn-outline-dark" type="button">
                            Clear all <i class="fa fa-trash-o fa-fw"></i>
                        </button>
                        <button class="btn btn-primary" type="button">
                            Check out<i class="fa fa-arrow-right fa-fw"></i>
                        </button>
                    </div>
                </div>
            </div>
            <div class="dropdown margin-left-10">
                <button class="btn btn-secondary" type="button" data-toggle="modal" data-target="#loginModal">
                    <i class="fa fa-user fa-fw fa-lg"></i>Log In
                </button>
            </div>
        </div>
    </nav>
    <div class="collapse" id="navbarToggleExternalContent">
        <!--<div class="bg-dark dropdown-category-menu">
            <div class="d-inline">
                <p style="font-size: 20px"><span class="badge badge-secondary">Laptops</span></p>
            </div>
        </div>-->
        <div class="container dropdown-category-menu">
            <div class="row">
                <div class="col-lg-1">
                    <div class="card shadow-box">
                        <div class="card-header">
                            <img class="card-img-top" src="https://image.flaticon.com/icons/png/128/123/123400.png"
                                 alt="image">
                        </div>
                        <div class="card-body">
                            <b>Laptops</b> <a href="#" class="float-right"><i class="fa fa-arrow-right"></i></a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-1">
                    <div class="card shadow-box">
                        <div class="card-header">
                            <img class="card-img-top"
                                 src="http://icons.iconarchive.com/icons/carlosjj/google-jfk/128/adsense-for-mobile-icon.png"
                                 alt="image">
                        </div>
                        <div class="card-body">
                            <b>Mobiles</b> <a href="#" class="float-right"><i class="fa fa-arrow-right"></i></a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-1">
                    <div class="card shadow-box">
                        <div class="card-header">
                            <img class="card-img-top" src="https://image.flaticon.com/icons/png/128/189/189108.png"
                                 alt="image">
                        </div>
                        <div class="card-body">
                            <b>Tablets</b> <a href="#" class="float-right"><i class="fa fa-arrow-right"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header login-modal-header">
                    <h5 class="modal-title" >Log In</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                        <form class="form" role="form">
                            <div class="form-group">
                                <input id="emailInput" placeholder="Email" class="form-control form-control-sm"
                                       type="text" required="">
                            </div>
                            <div class="form-group">
                                <input id="passwordInput" placeholder="Password"
                                       class="form-control form-control-sm" type="text" required="">
                            </div>
                            <div class="form-group form-group-non-margin">
                                <button type="submit" class="btn btn-primary btn-sm btn-block">Login</button>
                            </div>
                        </form>

                </div>
            </div>
        </div>
    </div>
</header>