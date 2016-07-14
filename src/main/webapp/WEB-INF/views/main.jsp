<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<%@ include file="/WEB-INF/fragments/head.jspf" %>

<body>

<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Markup REST Service Test Page</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-left">
                    <li><a href="<c:url value="/stats" />">JSON Stats</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="<c:url value="/logout" />">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div id="errorBox" class="alert alert-dismissible alert-danger" style="display: none">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <strong id="errorstrong">403</strong> <span id="errortext">Access denied!</span>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <form id="markup-form" class="form-horizontal">
                <fieldset>
                    <div class="form-group">
                        <label for="source" class="col-lg-2 control-label">Source</label>
                        <div class="col-lg-10">
                            <textarea class="form-control" rows="3" id="source"></textarea>
                            <span class="help-block">Insert source markup text into this area</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <button id="reset" type="reset" class="btn btn-default">Clear</button>
                            <button id="submit" type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="result" class="col-lg-2 control-label">Result HTML</label>
                        <div class="col-lg-10">
                            <textarea class="form-control" rows="3" id="result"></textarea>
                        </div>
                    </div>
                </fieldset>
            </form>

        </div>
    </div>


    <footer class="footer">
        <p>&copy; 2016 Leonid Minaiev</p>
    </footer>

</div> <!-- /container -->
</body>
</html>
