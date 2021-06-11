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

    <link href='<spring:url value="/css/light.css"/>' rel="stylesheet"/>
    <script src="http://code.jquery.com/jquery-3.5.1.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            type="text/javascript"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>

</head>
<body>
<jsp:include page="templates/navbar.jsp"/>
<div class="container-md">
    <br/>
    <br/>
    <br/>
    <form id="deleteCityForm${city.id}" name="userManagementForm" enctype="text/plain">
        <div class="btn-group" role="group" aria-label="Basic mixed styles example" style="position: fixed; right: 0; ">

            <input id="deleteUrl" hidden name="deleteUrl" value="${pageContext.request.contextPath}/delete">
            <button id="deleteButton" type="submit" class="btn btn-danger">Delete</button>
            <button type="button" class="btn btn-warning">Middle</button>
            <button type="button" class="btn btn-success">Right</button>
        </div>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <td scope="col">
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" id="checkAll" name="checkAll">
                    <label class="form-check-label" for="checkAll"></label>
                </div>
            </td>
            <td scope="col"><h5><spring:message code="ID"/></h5></td>
            <td scope="col"><h5><spring:message code="username"/></h5></td>
            <td scope="col"><h5><spring:message code="eMail"/></h5></td>
            <td scope="col"><h5><spring:message code="registration.date"/></h5></td>
            <td scope="col"><h5><spring:message code="login.last"/></h5></td>
            <td scope="col"><h5><spring:message code="status"/></h5></td>
        </tr>
        </thead>

        <c:forEach var="user" items="${users}">
            <c:choose>
                <c:when test="${user.isLocked}">
                    <tr id="row${user.id}" class="table-danger">
                </c:when>
                <c:otherwise>
                   <tr id="row${user.id}">
                </c:otherwise>
            </c:choose>
                <td style="content-align: center">
                    <div class="form-check form-switch">
                        <input class="form-check-input" type="checkbox" id="chose" name="userId"
                               value="${user.id}">
                    </div>
                </td>
                <td>${user.id}</td>
            <td><h6>${user.username}
                <c:if test="${user.id == currentUser.id}">&nbsp
                    <span class="badge bg-success">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-person-check" viewBox="0 0 16 16">
                        <path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0
                         1-1 1-1 1H1s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C9.516
                         10.68 8.289 10 6 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"></path>
                        <path fill-rule="evenodd" d="M15.854 5.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708
                        0l-1.5-1.5a.5.5 0 0 1 .708-.708L12.5 7.793l2.646-2.647a.5.5 0 0 1 .708 0z"></path>
                    </svg>&nbsp
                    <spring:message code="you"/>
                    </span>
                </c:if></h6>
            </td>
                <td>${user.email}</td>
                <td>
                    <fmt:parseDate value="${user.registrationDate}" pattern="yyyy-MM-dd'T'HH:mm"
                                   var="parsedDateTime" type="both"/>
                    <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${parsedDateTime}"/></td>

                <td><fmt:parseDate value="${user.lastLoginDate}" pattern="yyyy-MM-dd'T'HH:mm"
                                   var="parsedDateTime" type="both"/>
                </td>
                <td id="statusCell${user.id}">
                    <c:if test="${user.isLocked}">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock-fill" viewBox="0 0 16 16">
                            <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"/>
                        </svg>
                        <spring:message code="status.blocked"/>
                    </c:if>
                    <c:if test="${!user.isLocked}">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-check2" viewBox="0 0 16 16">
                            <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1
                            .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"></path>
                        </svg>
                        <spring:message code="status.active"/>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
    </form>
</div>
<script type="text/javascript">
    $(function () {
        $('button#deleteButton[type=submit]').click(function (e) {
            console.log("Delete ajax");
            e.preventDefault();
            var form = document.forms['userManagementForm'];
            var formData = new FormData(form);
            var ajaxReq = $.ajax({
                url:document.getElementById('deleteUrl').value,
                type: 'DELETE',
                data: formData,
                cache: false,
                contentType: false,
                processData: false,
                xhr: function () {
                    var xhr = $.ajaxSettings.xhr();
                    return xhr;
                },
            });
            ajaxReq.done(function (msg) {
               formData.getAll('userId').forEach(element => {
                       jQuery('#row' + element).hide(700);
        /*           jQuery('#row' + element.toString()).addClass("table-danger");
                       jQuery('#statusCell' + element.toString()).html('<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock-fill" viewBox="0 0 16 16">' +
                           ' <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"/>' +
                           ' </svg><spring:message code="status.blocked"/>');*/
               }
               );
            });
            ajaxReq.fail(function (jqXHR) {
            console.log("Error when try to delete user vith id:" + element)
            });
        });
    });
</script>
<script type="text/javascript">
    $("#checkAll").change(function () {
        if ($(this).is(':checked'))
            $(".form-check-input").attr('checked', true);
        else
            $(".form-check-input").removeAttr('checked');
    });
</script>
</body>
</html>