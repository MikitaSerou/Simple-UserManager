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
    <link rel="shortcut icon" type="image/x-icon"
          href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
    <title><spring:message code="login.title"/></title>
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
            <%-- <h1 align="center"><spring:message code="login.title"/></h1>--%>
            <br/>
            <c:if test="${param.error != null}">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    <spring:message code="login.error"/>
                </div>
                <%--      <div class="alert alert-dismissible alert-danger">
                          <button type="button" class="close" data-dismiss="alert">&times;</button>
                          <strong><spring:message code="login.error"/></strong>
                      </div>--%>
            </c:if>
            <form:form name="f" method="post" action="${pageContext.request.contextPath}/login" class="field"
                       modelAttribute="loginForm">
                <div class="form-group">
                    <label class="form-label mt-4"><spring:message code="login.title"/></label>
                    <div class="form-floating mb-3">
                       <%-- <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">--%>
                           <label for="floatingInput"><spring:message code="username" var="username"/></label>
                           <form:input type="text" name="username" class="form-control" id="floatingInput"
                        placeholder='name@example.com' path="username"/>
                           <form:errors path="username" cssClass="error"/>
                    </div>
                    <div class="form-floating">
                        <label for="floatingPassword"><spring:message code="password" var="password"/></label>
                    <%--    <input type="password" class="form-control" id="floatingPassword" placeholder="Password">--%>
                        <form:input type="password" path="password" name="password" class="form-control"
                                    id="floatingPassword"
                                    placeholder='Password'/>
                        <form:errors path="password" cssClass="error"/>
                      <%--  <label for="floatingPassword">Password</label>--%>
                    </div>
                </div>

                <%--        <div class="form-group">
                            <label for="formGroupExampleInput"><spring:message code="username" var="username"/></label>
                            <form:input type="text" name="username" class="form-control" id="formGroupExampleInput"
                                        placeholder='${username}' path="username"/>
                            <form:errors path="username" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput2"><spring:message code="password" var="password"/></label>
                            <form:input type="password" path="password" name="password" class="form-control"
                                        id="formGroupExampleInput2"
                                        placeholder='${password}'/>
                            <form:errors path="password" cssClass="error"/>
                        </div>--%>
                <div class="row justify-content-md-center">
                    <br/>
                    <br/>
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <button type="submit" name="submit" value="submit" formmethod="post" class="btn btn-success">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                                <path fill-rule="evenodd"
                                      d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"></path>
                                <path fill-rule="evenodd"
                                      d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"></path>
                            </svg>
                            <spring:message code="login.button"/>
                        </button>
                        <button type="button" class="btn btn-info"><a
                                href="${pageContext.request.contextPath}/registration">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-person-plus" viewBox="0 0 16 16">
                                <path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H1s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C9.516 10.68 8.289 10 6 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"></path>
                                <path fill-rule="evenodd"
                                      d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"></path>
                            </svg>
                            <spring:message code="registration.button"/></a>
                        </button>
                    </div>
                </div>
                <br/>
                <br/>
            </form:form>
        </div>
        <div class="col-sm"></div>
    </div>
</div>
</body>
</html>