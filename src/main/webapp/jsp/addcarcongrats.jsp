<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>

    <title>Car Rental - <fmt:message bundle="${loc}" key="local.addcarcongratspage"/></title>
    <meta charset="utf-8">
    <jsp:include page="parts/commonHeaderPart.jsp"/>
</head>
<body>
<jsp:include page="parts/header.jsp"/>
<div class="row">
    <div class="col-xs-6  col-xs-offset-3" style="margin-top: 100px">
        <h1><fmt:message bundle="${loc}" key="local.addcar.congrats"/></h1>
    </div>
</div>
<div class="row">
    <div class="col-xs-3 col-xs-offset-5">
        <a href="${pageContext.request.contextPath}/serv?command=show_cars&index=1" class="btn btn-success"><fmt:message
                bundle="${loc}" key="local.allcarsbtn"/></a>
    </div>
</div>
</body>
</html>
