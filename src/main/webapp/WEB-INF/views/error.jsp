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
    <title><spring:message code="error"/></title>
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
        <div class="col-sm-4">
            <br/>
            <br/>
            <h1 align="center"><spring:message code="error.page"/> ${status} ${error}</h1>
            <br/>
            <br/>
            <br/>
        </div>
    </div>
    <div style="margin-right: auto; margin-left: auto;" align="center">
    <img src='<spring:url value="https://gifki.info/uploads/posts/2017-06/1498693660_2955-sho-opyat.gif"/>'
         width="384px"
         height="344px" class="rounded" alt="kek"></div>
</div>
</body>
</html>