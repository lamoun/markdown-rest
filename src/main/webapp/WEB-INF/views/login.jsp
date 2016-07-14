<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="/WEB-INF/fragments/head.jspf" %>
<body>
<div class="container">
    <div class="col-lg-4 col-lg-push-4">
        <form class="form-signin" method="POST" action="<c:url value="/login"/>">
            <h2 class="form-signin-heading">Please sign in</h2>

            <div class="form-group">
                <label for="inputEmail" class="sr-only">Email address</label>
                <input type="text" name="username" id="inputEmail" class="form-control" placeholder="Email address"
                       required=""
                       autofocus="">
            </div>
            <div class="form-group">
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password"
                       required="">
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>
    </div>
</div>
</body>
</html>
