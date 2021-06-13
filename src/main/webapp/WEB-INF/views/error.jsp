<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title><spring:message code="user.table"/></title>
    <link href='<spring:url value="/css/light.css"/>' rel="stylesheet"/>
    <script src="http://code.jquery.com/jquery-3.5.1.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            type="text/javascript"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<jsp:include page="templates/navbar.jsp"/>
<div class="container">
    <div class="row justify-content-center align-items-center">
    </div>
    <div class="row justify-content-center align-items-center">
        <div class="col-sm"></div>
        <div class="col-sm-4">
            <br/>
            <br/>
            <h1 align="center"><spring:message code="error.page"/> ${status} ${error}</h1>
            <br/>
            <div style="display: table; margin: 0 auto; text-align: center">
            <div class="d-grid gap-2">
                <a href="${pageContext.request.contextPath}/">
                <button class="btn btn-lg btn-success" >
                    <spring:message code="to.main.page"/></button>
                </a>
            </div>
            </div>
        </div>
        <div class="col-sm"></div>
    </div>
</div>
<script src="<c:url value="/js/langChangeScript.js"/>"></script>
</body>
</html>