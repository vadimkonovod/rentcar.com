<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>

    <title>Car Rental - <fmt:message bundle="${loc}" key="local.myaccountpage"/></title>
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
                    <th><fmt:message bundle="${loc}" key="local.display.city"/></th>
                    <th><fmt:message bundle="${loc}" key="local.preorder.stdate"/></th>
                    <th><fmt:message bundle="${loc}" key="local.preorder.returndate"/></th>
                    <th></th>
                </tr>
                <c:forEach items="${ordersCars}" var="current">
                    <tr>
                        <td><c:out value="${current.car.brand}"/></td>
                        <td><c:out value="${current.car.model}"/></td>
                        <td><c:out value="${current.car.city}"/></td>
                        <td><c:out value="${current.order.startDate}"/></td>
                        <td><c:out value="${current.order.finishDate}"/></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/serv?command=delete_order&orderID=${current.order.id}" class="btn btn-danger btn-sm"><fmt:message bundle="${loc}" key="local.myaccount.deletebtn"/></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/myinfo.jsp"><fmt:message bundle="${loc}" key="local.myaccount.myinfobtn"/></a>
            <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/main.jsp"><fmt:message bundle="${loc}" key="local.tomainpagebtn"/></a>
        </div>
    </div>
</div>
</body>
</html>