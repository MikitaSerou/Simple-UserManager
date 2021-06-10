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
    <title><spring:message code="registration.title"/></title>
    <link href='<spring:url value="/css/light.css"/>' rel="stylesheet"/>
    <script src="http://code.jquery.com/jquery-3.5.1.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            type="text/javascript"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<jsp:include page="templates/navbar.jsp"/>
<div class="container" style="min-height: 80%">
    <div class="row justify-content-center align-items-center">
    </div>
    <div class="row justify-content-center align-items-center">
        <div class="col-sm"></div>
        <div class="col-sm-6" style="backdrop-filter: blur(7px); border-radius: 30px">
            <h1 align="center"><spring:message code="signUp.entrance.page"/></h1>
            <br/>
            <form:form action="${pageContext.request.contextPath}/registration/" method="post"
                       modelAttribute="registrationForm">
                <div class="form-group">
                    <label for="formGroupExampleInput1"><spring:message code="username"/></label>
                    <spring:message code="username" var="userName"/>
                    <form:input type="text" class="form-control" name="userName" id="formGroupExampleInput1"
                                placeholder='${userName}' path="username"/>
                    <form:errors path="username" cssClass="error"/>
             <%--       <span class="error"><spring:message code="${notUniqueError}"/></span>--%>
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2"><spring:message code="eMail"/></label>
                    <spring:message code="eMail" var="email"/>
                    <form:input type="text" class="form-control" name="email" id="formGroupExampleInput2"
                                placeholder='${email}' path="email"/>
                    <form:errors path="email" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput4"><spring:message code="password"/></label>
                    <spring:message code="password" var="password"/>
                    <form:input type="password" path="password" name="password" class="form-control"
                                id="formGroupExampleInput4"
                                placeholder='${password}'/>
                    <form:errors path="password" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput5"><spring:message code="passwordConfirm"/></label>
                    <spring:message code="passwordConfirm" var="passwordConfirm"/>
                    <form:input type="password" path="passwordConfirm" name="passwordConfirm" class="form-control"
                                id="formGroupExampleInput5"
                                placeholder='${passwordConfirm}'/>
                    <form:errors path="passwordConfirm" cssClass="error"/>
                   <%-- <span class="error"><spring:message code="${passwordsError}"/></span>--%>
                </div>
                <div class="row justify-content-md-center">
                    <br/>
                    <br/>
                    <button type="submit" class="btn btn-success">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-person-plus" viewBox="0 0 16 16">
                            <path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H1s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C9.516 10.68 8.289 10 6 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"></path>
                            <path fill-rule="evenodd"
                                  d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"></path>
                        </svg>
                        <spring:message code="registration.button"/>
                    </button>
                </div>
                <br/>
            </form:form>
        </div>
        <div class="col-sm"></div>
    </div>
</div>
</body>
</html>