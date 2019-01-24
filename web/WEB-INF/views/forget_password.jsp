
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="WEB-INF/shared/header.jsp" />

<div class="container">
    <div class="row">
        <div class="col-md-2">
        </div>

        <div class="col-md-8">
            <h3 class="h3">Recover Password</h3>
            <form id="" class="" method="get" action="/user/recover-password">
                Username :<input id="" name="username" type="text" > or <br/>
                Email :<input id="" name="email" type="text" > or <br/>
                <input class="btn btn-danger" type="submit" value="submit">
            </form>
        </div>

        <div class="col-md-2">
        </div>
    </div>
</div>


<jsp:include page="WEB-INF/shared/footer.jsp" />
