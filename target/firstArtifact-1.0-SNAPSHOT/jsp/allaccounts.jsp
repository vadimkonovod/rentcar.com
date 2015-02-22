<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>

    <title>Car Rental - <fmt:message bundle="${loc}" key="local.accountspage"/></title>
    <jsp:include page="parts/commonHeaderPart.jsp"/>
</head>
<body>
<jsp:include page="parts/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <table class="table">
                <tr>
                    <th><fmt:message bundle="${loc}" key="local.accounts.name"/></th>
                    <th><fmt:message bundle="${loc}" key="local.accounts.surname"/></th>
                    <th><fmt:message bundle="${loc}" key="local.accounts.age"/></th>
                    <th><fmt:message bundle="${loc}" key="local.accounts.email"/></th>
                    <th><fmt:message bundle="${loc}" key="local.accounts.login"/></th>
                    <th><fmt:message bundle="${loc}" key="local.accounts.pass"/></th>
                    <th><fmt:message bundle="${loc}" key="local.accounts.role"/></th>
                </tr>
                <c:forEach items="${accounts}" var="current">
                    <tr>
                        <td><c:out value="${current.name}"/></td>
                        <td><c:out value="${current.surname}"/></td>
                        <td><c:out value="${current.age}"/></td>
                        <td><c:out value="${current.email}"/></td>
                        <td><c:out value="${current.login}"/></td>
                        <td><c:out value="${current.password}"/></td>
                        <td><c:out value="${current.role}"/></td>
                    </tr>
                </c:forEach>
            </table>


            <div class="form-group pull-right">
                <a href="${pageContext.request.contextPath}/jsp/main.jsp" class="btn btn-success"><fmt:message bundle="${loc}" key="local.tomainpagebtn"/></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>