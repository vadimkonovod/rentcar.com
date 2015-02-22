<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page errorPage="error.jsp" %>

<html>
<head>
    <jsp:include page="jsp/parts/commonHeaderPart.jsp"/>
    
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>

    <title>Car Rental - <fmt:message bundle="${loc}" key="local.indexpage"/></title>

</head>
<body>
<jsp:include page="jsp/parts/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-4 col-xs-offset-4">

            <form id="loginForm" name="loginForm" action="${pageContext.request.contextPath}/serv?command=login" method="post">
                <h3><fmt:message bundle="${loc}" key="local.welcome"/></h3>
                <div class="form-group">
                    <input type="text" name="login" placeholder="<fmt:message bundle="${loc}" key="local.loginform.username"/>" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" name="password" placeholder="<fmt:message bundle="${loc}" key="local.loginform.password"/>" class="form-control">
                </div>
                <c:if test="${not empty errorLoginPassMessage}">
                    <div class="form-group">
                        <a style="color: red;">${errorLoginPassMessage}</a>
                    </div>
                </c:if>
                <button type="submit" class="btn-success btn"><fmt:message bundle="${loc}" key="local.loginbutton"/></button>
                <a class="pull-right" href="jsp/register.jsp"><fmt:message bundle="${loc}" key="local.registerbtn"/></a>
            </form>
        </div>
    </div>
</div>
</body>
</html>