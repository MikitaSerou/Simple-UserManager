<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title><spring:message code="signIn"/></title>
    <link href='<spring:url value="/css/light.css"/>' rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.5.1.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            type="text/javascript"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<jsp:include page="templates/navbar.jsp"/>
<div class="container">
    <div class="row justify-content-center align-items-center">
        <div class="col-sm"></div>
        <div class="col-sm-6">
            <br/>
            <h1 align="center"><spring:message code="signIn.header"/></h1>
            <br/>
            <c:if test="${param.error != null}">
                <div class="alert alert-dismissible alert-danger">
                    <spring:message code="login.error"/>
                </div>
            </c:if>
            <form:form method="post" action="${pageContext.request.contextPath}/login"
                       modelAttribute="loginForm">
                <div class="form-group">
                    <label class="col-form-label col-form-label-lg mt-4" for="loginInput">
                        <spring:message code="login"/></label>
                    <form:input type="text" name="username" class="form-control form-control-lg" id="loginInput"
                                placeholder='JohnDoe' path="username"/>
                </div>
                <div class="form-group">
                    <label class="col-form-label col-form-label-lg mt-4" for="passwordInput">
                        <spring:message code="password"/></label>
                    <form:input type="password" path="password" name="password" class="form-control form-control-lg"
                                id="passwordInput"
                                placeholder='StrongPassword'/>
                </div>
                <br/>
                <br/>
                <div class="d-grid gap-2">
                    <button class="btn btn-lg btn-success" type="submit">
                        <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                             class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
                                  d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1
                                   .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0
                                    0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"></path>
                            <path fill-rule="evenodd"
                                  d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0
                                  0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"></path>
                        </svg>
                        <spring:message code="signIn"/></button>
                </div>
            </form:form>
            <br/>
            <div style="display: table; margin: 0 auto; text-align: center">
                <p class="lead" style="font-size: 14px;">
                    <spring:message code="or"/>
                </p>
                <a href="${pageContext.request.contextPath}/registration">
                    <button type="button" class="btn btn-primary">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-person-plus" viewBox="0 0 16 16">
                            <path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1
                            1-1 1H1s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C9.516 10.68
                            8.289 10 6 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"></path>
                            <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5
                            0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"></path>
                        </svg>
                        <spring:message code="signUp"/></button>
                </a>
            </div>
        </div>
        <div class="col-sm"></div>
    </div>
</div>
</body>
</html>