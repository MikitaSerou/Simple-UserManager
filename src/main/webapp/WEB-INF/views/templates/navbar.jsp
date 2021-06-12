<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href='<spring:url value="/css/light.css"/>' rel="stylesheet"/>
    <script src="http://code.jquery.com/jquery-3.5.1.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            type="text/javascript"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/" style="font-size: 40px">
            <spring:message code="main.title"/></a>
        <div class="btn-group" role="group" aria-label="Basic example">
            <a href="?lang=en"><button type="button" class="btn btn-danger"><spring:message code="lang.en"/></button></a>
            <a href="?lang=ru"><button type="button" class="btn btn-danger"><spring:message code="lang.ru"/></button></a>
        </div>
        <div class="collapse navbar-collapse" id="navbarColor02">
            <div style="position:absolute; right: 15px;">
                <sec:authorize access="isAuthenticated()">
                    <div class="d-flex">
                        <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                             class="bi bi-person-fill" viewBox="0 0 16 16">
                            <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                        </svg>
              <h3 style=" display: inline;">${currentUser.username}&nbsp&nbsp</h3>
                <a href="${pageContext.request.contextPath}/logout">
                    <button class="btn btn-danger my-2 my-sm-0">
                        <spring:message code="logout.button"/></button>
                </a></div>
                </sec:authorize>
        </div>
    </div>
</nav>