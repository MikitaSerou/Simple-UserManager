<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
        <sec:authorize access="!isAuthenticated()">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/" style="font-size: 28px">
                <spring:message code="main.title"/>
            </a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                 class="bi bi-person-fill" viewBox="0 0 16 16">
                <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"></path>
            </svg>
            <h3>${currentUser.username}&nbsp&nbsp</h3>
        </sec:authorize>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span style="font-size: 24px">   <spring:message code="lang.now"/></span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="?lang=en">
                            <span style="font-size: 24px">  <spring:message code="lang.en"/></span>
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="?lang=ru">
                            <span style="font-size: 24px">    <spring:message code="lang.ru"/></span>
                        </a>
                    </div>
                </li>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">

                        <a class="nav-link" class="text-danger" href="${pageContext.request.contextPath}/logout">
                            <span style="color: red; font-size: 24px"> <spring:message code="logout.button"/></span></a>

                    </li>
                </sec:authorize>
            </ul>
        </div>
    </nav>
</div>
<br/>
<br/>