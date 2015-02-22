<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>

    <title>Car Rental - <fmt:message bundle="${loc}" key="local.orderspage"/></title>
    <jsp:include page="parts/commonHeaderPart.jsp"/>
</head>
<body>
<jsp:include page="parts/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <table class="table">
                <tr>
                    <th><fmt:message bundle="${loc}" key="local.orders.name"/></th>
                    <th><fmt:message bundle="${loc}" key="local.orders.surname"/></th>
                    <th><fmt:message bundle="${loc}" key="local.orders.login"/></th>
                    <th><fmt:message bundle="${loc}" key="local.orders.stdate"/></th>
                    <th><fmt:message bundle="${loc}" key="local.orders.returndate"/></th>
                    <th><fmt:message bundle="${loc}" key="local.orders.brand"/></th>
                    <th><fmt:message bundle="${loc}" key="local.orders.model"/></th>
                    <th><fmt:message bundle="${loc}" key="local.orders.city"/></th>
                </tr>
                <c:forEach items="${orders}" var="current">
                    <tr>
                        <td><c:out value="${current.account.name}"/></td>
                        <td><c:out value="${current.account.surname}"/></td>
                        <td><c:out value="${current.account.login}"/></td>
                        <td><c:out value="${current.order.startDate}"/></td>
                        <td><c:out value="${current.order.finishDate}"/></td>
                        <td><c:out value="${current.car.brand}"/></td>
                        <td><c:out value="${current.car.model}"/></td>
                        <td><c:out value="${current.car.city}"/></td>
                    </tr>
                </c:forEach>
            </table>

            <div class="form-group">
                <div class="text-center">
                    <c:forEach var="count" begin="1" end="${(listSize / 10) + 1}">
                        <a class="btn btn-success btn-sm"
                           href="${pageContext.request.contextPath}/serv?command=show_orders&index=${count}"> ${count} </a>
                    </c:forEach>
                </div>
                <div class="pull-right">
                    <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/main.jsp"><fmt:message bundle="${loc}" key="local.tomainpagebtn"/></a>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>