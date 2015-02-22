<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>

    <title>Car Rental - <fmt:message bundle="${loc}" key="local.preorderpage"/></title>
    <meta charset="utf-8">
    <jsp:include page="parts/commonHeaderPart.jsp"/>
</head>

<body>
<jsp:include page="parts/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <div class="row">
                <h3 class="col-xs-4"><fmt:message bundle="${loc}" key="local.preorder.user"/></h3>
            </div>
            <div class="row">
                <div class="col-xs-2"><fmt:message bundle="${loc}" key="local.preorder.name"/></div>
                <div class="col-xs-2"><c:out value="${account.name}"/></div>
            </div>
            <div class="row">
                <div class="col-xs-2"><fmt:message bundle="${loc}" key="local.preorder.surname"/></div>
                <div class="col-xs-2"><c:out value="${account.surname}"/></div>
            </div>

            <div class="row">
                <h3 class="col-xs-4"><fmt:message bundle="${loc}" key="local.preorder.car"/></h3>
            </div>
            <div class="row">
                <div class="col-xs-2"><fmt:message bundle="${loc}" key="local.preorder.brand"/></div>
                <div class="col-xs-2"><c:out value="${car.brand}"/></div>
            </div>
            <div class="row">
                <div class="col-xs-2"><fmt:message bundle="${loc}" key="local.preorder.model"/></div>
                <div class="col-xs-2"><c:out value="${car.model}"/></div>
            </div>
            <div class="row">
                <div class="col-xs-2"><fmt:message bundle="${loc}" key="local.preorder.year"/></div>
                <div class="col-xs-2"><c:out value="${car.year}"/></div>
            </div>
            <div class="row">
                <div class="col-xs-2"><fmt:message bundle="${loc}" key="local.preorder.city"/></div>
                <div class="col-xs-2"><c:out value="${car.city}"/></div>
            </div>

            <div class="row">
                <h3 class="col-xs-4"><fmt:message bundle="${loc}" key="local.preorder.dates"/></h3>
            </div>
            <div class="row">
                <div class="col-xs-2"><fmt:message bundle="${loc}" key="local.preorder.stdate"/></div>
                <div class="col-xs-2">${stDate}</div>
            </div>
            <div class="row">
                <div class="col-xs-2"><fmt:message bundle="${loc}" key="local.preorder.returndate"/></div>
                <div class="col-xs-2">${finDate}</div>
            </div>
            <div style="margin-left: 300px; margin-top: 20px">
                <a href="${pageContext.request.contextPath}/serv?command=submit_order" class="btn btn-success btn-sm"><fmt:message bundle="${loc}" key="local.paybtn"/></a>
            </div>
        </div>
    </div>
</div>

</div>
</body>

</html>
