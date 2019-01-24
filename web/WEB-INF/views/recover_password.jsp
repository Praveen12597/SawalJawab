
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="WEB-INF/shared/header.jsp" />

<div class="container">
    <div class="row">
        <div class="col-md-2">
        </div>

        <div class="col-md-8">
            <h3 class="h3">Recover Password</h3>
            <form id="" class="" method="post" action="/user/recover-password">

                Password :<input id="password" name="password" class="input-group" type="password" required>
                Confirm Password :<input id="cpassword" class="input-group" name="cpassword" type="password" required>

                <input class="btn btn-danger" type="submit" value="submit">

            </form>

            <div class="">
                <form class="form-control" id="" method="post" action="">
                    <span>OTP</span>
                    <input class="input-group" type="text" id="otp" name="otp" type="text">
                    <input type="submit" value="submit">
                </form>

            </div>
        </div>

        <div class="col-md-2">
        </div>
    </div>
</div>


<jsp:include page="WEB-INF/shared/footer.jsp" />
