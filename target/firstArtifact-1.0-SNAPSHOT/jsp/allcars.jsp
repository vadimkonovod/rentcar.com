<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>

    <title>Car Rental - <fmt:message bundle="${loc}" key="local.carspage"/></title>
    <jsp:include page="parts/commonHeaderPart.jsp"/>
</head>
<body>
<jsp:include page="parts/header.jsp"/>
<div class="container">
    <div class="pull-right">
        <c:if test="${not empty deleteCarNotValidMessage}">
            <div class="form-group">
                <a style="color: red;">${deleteCarNotValidMessage}</a>
            </div>
        </c:if>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <table class="table">
                <tr>
                    <th><fmt:message bundle="${loc}" key="local.cars.brand"/></th>
                    <th><fmt:message bundle="${loc}" key="local.cars.model"/></th>
                    <th><fmt:message bundle="${loc}" key="local.cars.year"/></th>
                    <th><fmt:message bundle="${loc}" key="local.cars.city"/></th>
                    <th></th>
                </tr>
                <c:forEach items="${cars}" var="current">
                    <tr>
                        <td><c:out value="${current.brand}"/></td>
                        <td><c:out value="${current.model}"/></td>
                        <td><c:out value="${current.year}"/></td>
                        <td><c:out value="${current.city}"/></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/serv?command=delete_car&carID=${current.id}"
                               class="btn btn-danger btn-sm"><fmt:message bundle="${loc}" key="local.cars.deletecarbtn"/></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <div class="form-group">
                <div class="text-center">
                    <c:forEach var="count" begin="1" end="${(listSize / 10) + 1}">
                        <a class="btn btn-success btn-sm" href="${pageContext.request.contextPath}/serv?command=show_cars&index=${count}"> ${count} </a>
                    </c:forEach>
                </div>

                <div class="pull-right">
                    <a href="${pageContext.request.contextPath}/jsp/addcar.jsp" class="btn btn-success"><fmt:message bundle="${loc}" key="local.cars.addcarbtn"/></a>
                    <a href="${pageContext.request.contextPath}/jsp/main.jsp" class="btn btn-success"><fmt:message bundle="${loc}" key="local.tomainpagebtn"/></a>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>