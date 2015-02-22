<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>

    <title>Car Rental - <fmt:message bundle="${loc}" key="local.displaypage"/></title>
    <jsp:include page="parts/commonHeaderPart.jsp"/>
</head>
<body>
<jsp:include page="parts/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <table class="table">
                <tr>
                    <th><fmt:message bundle="${loc}" key="local.display.brand"/></th>
                    <th><fmt:message bundle="${loc}" key="local.display.model"/></th>
                    <th><fmt:message bundle="${loc}" key="local.display.year"/></th>
                    <th><fmt:message bundle="${loc}" key="local.display.city"/></th>
                    <th></th>
                </tr>
                <c:forEach items="${cars}" var="current">
                    <tr>
                        <td><c:out value="${current.brand}"/></td>
                        <td><c:out value="${current.model}"/></td>
                        <td><c:out value="${current.year}"/></td>
                        <td><c:out value="${current.city}"/></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/serv?command=pre_order&carID=${current.id}" class="btn btn-success btn-sm"><fmt:message bundle="${loc}" key="local.rentbtn"/></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/main.jsp"><fmt:message bundle="${loc}" key="local.tomainpagebtn"/></a>
        </div>
    </div>
</div>
</body>
</html>