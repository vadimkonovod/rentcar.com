<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>

    <title>Car Rental - <fmt:message bundle="${loc}" key="local.errorpage"/></title>
    <meta charset="utf-8">
    <jsp:include page="jsp/parts/commonHeaderPart.jsp"/>
</head>
<body>
<div class="row">
    <div class="col-xs-4  col-xs-offset-5" style="margin-top: 100px">
        <h1><fmt:message bundle="${loc}" key="local.errorpage.error"/></h1>
    </div>
    <div class="col-xs-6  col-xs-offset-4">
        <h3><fmt:message bundle="${loc}" key="local.errorpage.message"/></h3>
    </div>
</div>
<div class="row">
    <div class="col-xs-3 col-xs-offset-5">
        <a href="${pageContext.request.contextPath}/serv?command=logout" class="btn btn-danger navbar-btn"><fmt:message
                bundle="${loc}" key="local.errorpage.btn"/></a>
    </div>
</div>
</body>
</html>
