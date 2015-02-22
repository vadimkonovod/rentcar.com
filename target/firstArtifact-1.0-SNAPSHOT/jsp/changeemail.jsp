<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>

    <title>Car Rental - <fmt:message bundle="${loc}" key="local.changeemailpage"/></title>
    <jsp:include page="parts/commonHeaderPart.jsp"/>

</head>
<body>
<jsp:include page="parts/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-4 col-xs-offset-4">

            <form id="changeEmailForm" name="changeEmailForm" action="${pageContext.request.contextPath}/serv?command=change_email" method="post">
                <h3><fmt:message bundle="${loc}" key="local.changeemail.title"/></h3>
                <div class="form-group">
                    <input type="text" name="newemail" placeholder="<fmt:message bundle="${loc}" key="local.changeemail.newemail"/>" class="form-control">
                </div>
                <c:if test="${not empty emailNotValidPassMessage}">
                    <div class="form-group">
                        <a style="color: red;">${emailNotValidPassMessage}</a>
                    </div>
                </c:if>
                <button type="submit" class="btn-success btn"><fmt:message bundle="${loc}" key="local.changeemail.chngbtn"/></button>
                <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/myinfo.jsp"><fmt:message bundle="${loc}" key="local.myaccount.myinfobtn"/></a>
            </form>

        </div>
    </div>
</div>
</body>
</html>