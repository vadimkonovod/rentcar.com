<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>

    <title>Car Rental - <fmt:message bundle="${loc}" key="local.changepasspage"/></title>
    <jsp:include page="parts/commonHeaderPart.jsp"/>

</head>
<body>
<jsp:include page="parts/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-4 col-xs-offset-4">

            <form id="changPassForm" name="changePassForm" action="${pageContext.request.contextPath}/serv?command=change_pass" method="post">
                <h3><fmt:message bundle="${loc}" key="local.changepass.title"/></h3>
                <div class="form-group">
                    <input type="password" name="oldpass" placeholder="<fmt:message bundle="${loc}" key="local.changepass.old"/>" class="form-control">
                </div>
                <c:if test="${not empty oldPassNotValidMessage}">
                    <div class="form-group">
                        <a style="color: red;">${oldPassNotValidMessage}</a>
                    </div>
                </c:if>
                <div class="form-group">
                    <input type="password" name="newpass" placeholder="<fmt:message bundle="${loc}" key="local.changepass.new"/>" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" name="newpasscon" placeholder="<fmt:message bundle="${loc}" key="local.changepass.confirm"/>" class="form-control">
                </div>
                <c:if test="${not empty passwordNotValidPassMessage}">
                    <div class="form-group">
                        <a style="color: red;">${passwordNotValidPassMessage}</a>
                    </div>
                </c:if>
                <button type="submit" class="btn-success btn"><fmt:message bundle="${loc}" key="local.changepass.chngbtn"/></button>
                <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/myinfo.jsp"><fmt:message bundle="${loc}" key="local.myaccount.myinfobtn"/></a>
            </form>

        </div>
    </div>
</div>
</body>
</html>