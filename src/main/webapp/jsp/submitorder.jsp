<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>

    <title>Car Rental - <fmt:message bundle="${loc}" key="local.submitpage"/></title>
    <meta charset="utf-8">
    <jsp:include page="parts/commonHeaderPart.jsp"/>
</head>
<body>
<jsp:include page="parts/header.jsp"/>
<div class="row">
    <div class="col-xs-12 col-xs-offset-3 " style="margin-top: 100px">
        <h1><fmt:message bundle="${loc}" key="local.submitorder.congrats"/></h1>
    </div>
</div>
<div class="row">
    <div class="col-xs-3 col-xs-offset-5">
        <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/main.jsp"><fmt:message bundle="${loc}" key="local.tomainpagebtn"/></a>
    </div>
</div>
</body>
</html>
