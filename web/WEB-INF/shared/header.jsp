<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>SawalJawab</title>

        <script src="resources/js/jquery.js"  ></script>
        <script type="text/javascript" src="resources/js/bootstrap.js" ></script>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="resources/css/style.css">


        <style type="text/css">

            .modal-dialog {
                transform: translate(0, -50%);
                top: 25%;
                margin: 0 auto;

                overflow: auto;
                max-height: 100%;
                max-width: 100%;
            }

        </style>

        <script>
            $(document).ready(function () {
                if ($(this).width() < 751)
                    $('#adds').hide();

                else
                    $('#adds').show();
            });

            $(window).on('resize', function () {
                if ($(this).width() < 752)
                    $('#adds').hide();

                else
                    $('#adds').show();
            });
        </script>

    </head>
    <body>

        <!-- NavBar -->
        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/">SawalJawab</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">One more separated link</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>

                    </form>


                    <ul class="nav navbar-nav navbar-right" style="display: flex; list-style: none;">

                        <c:if test = "${empty user}">
                            <li><button class="btn btn-primary" data-toggle="modal" data-target="#LoginModal" style="margin: 8px 5px 0px 5px" >LOG IN</button></li>
                            <li><button class="btn btn-success" data-toggle="modal" data-target="#SignUpModal" style="margin: 8px 5px 5px 5px" >SIGN UP</button></li>
                            </c:if>                    

                        <c:if test="${not empty user}">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true" ></span><span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="/logout">logout</a></li>
                                </ul>
                            </li>
                        </c:if>

                    </ul>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <!-- ================================================================================================== -->

        <!-- Login Modal -->
        <div class="modal fade" id="LoginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="gridSystemModalLabel">SawalJawab</h4>
                    </div>
                    <div class="modal-body modal-guts" >
                        <div class="row">
                            <div class="col-xs-2"></div>
                            <div class="col-xs-10">
                                <form method="post" action="/login">
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Email address</label>
                                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">Password</label>
                                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox"> Remember Me
                                        </label>
                                    </div>
                                    <div>
                                        <label>
                                            New to SawalJawab ?<a data-toggle="modal" data-target="#SignUpModal" href="##" onclick="$('#LoginModal').modal('hide')">SignUp</a>
                                        </label>
                                    </div>
                                    <button type="submit" class="btn btn-primary" style="float: right; margin-right: 30px;">Login</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- ================================================================================================== -->

        <!-- SignUp Modal -->
        <div class="modal fade" id="SignUpModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="gridSystemModalLabel">SawalJawab</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-xs-2"></div>
                            <div class="col-xs-10">
                                <form>
                                    <div class="form-group">
                                        <label for="exampleInputName2">User Name</label>
                                        <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Email address</label>
                                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">Password</label>
                                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                    </div>
                                    <div>
                                        <label>
                                            Already Registered ?<a data-toggle="modal" data-target="#LoginModal" href="##" onclick="$('#SignUpModal').modal('hide')">Login</a>
                                        </label>
                                    </div>
                                    <button type="submit" class="btn btn-primary" style="float: right; margin-right: 30px;">SignUp</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- ================================================================================================== -->
