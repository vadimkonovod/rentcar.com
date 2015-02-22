<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>

    <title>Car Rental - <fmt:message bundle="${loc}" key="local.myinfopage"/></title>
    <meta charset="utf-8">
    <jsp:include page="parts/commonHeaderPart.jsp"/>
</head>

<body>
<jsp:include page="parts/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-6">
            <div class="row">
                <h3 class="col-xs-6"><fmt:message bundle="${loc}" key="local.myinfopage"/></h3>
            </div>


            <table class="table">
                <tr>
                    <td><div class="col-xs-2"><fmt:message bundle="${loc}" key="local.myinfo.name"/></div></td>
                    <td><div class="col-xs-2"><c:out value="${account.name}"/></div></td>
                    <td><div class="col-xs-2"></div></td>
                </tr>
                <tr>
                    <td><div class="col-xs-2"><fmt:message bundle="${loc}" key="local.myinfo.surname"/></div></td>
                    <td><div class="col-xs-2"><c:out value="${account.surname}"/></div></td>
                    <td><div class="col-xs-2"></div></td>
                </tr>
                <tr>
                    <td><div class="col-xs-2"><fmt:message bundle="${loc}" key="local.myinfo.age"/></div></td>
                    <td><div class="col-xs-2"><c:out value="${account.age}"/></div></td>
                    <td><div class="col-xs-2"></div></td>
                </tr>
                <tr>
                    <td><div class="col-xs-2"><fmt:message bundle="${loc}" key="local.myinfo.email"/></div></td>
                    <td><div class="col-xs-2"><c:out value="${account.email}"/></div></td>
                    <td><div class="col-xs-2"><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/jsp/changeemail.jsp"><fmt:message bundle="${loc}" key="local.myinfo.changeemailbtn"/></a></div></td>
                </tr>
                <tr>
                    <td><div class="col-xs-2"><fmt:message bundle="${loc}" key="local.myinfo.login"/></div></td>
                    <td><div class="col-xs-2"><c:out value="${account.login}"/></div></td>
                    <td><div class="col-xs-2"></div></td>
                </tr>
                <tr>
                    <td><div class="col-xs-2"><fmt:message bundle="${loc}" key="local.myinfo.password"/></div></td>
                    <td><div class="col-xs-2">********</div></td>
                    <td><div class="col-xs-2"><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/jsp/changepass.jsp"><fmt:message bundle="${loc}" key="local.myinfo.changepassbtn"/></a></div></td>
                </tr>
            </table>
            <c:if test="${not empty successEmailChangeMessage}">
                <div class="form-group">
                    <a style="color: green;">${successEmailChangeMessage}</a>
                </div>
            </c:if>
            <c:if test="${not empty successPassChangeMessage}">
                <div class="form-group">
                    <a style="color: green;">${successPassChangeMessage}</a>
                </div>
            </c:if>
            <div style="margin-left: 300px; margin-top: 20px">
                <a class="btn btn-success" href="${pageContext.request.contextPath}/serv?command=myaccount"><fmt:message bundle="${loc}" key="local.myinfo.myordersbtn"/></a>
                <a class="btn btn-success" href="${pageContext.request.contextPath}/jsp/main.jsp"><fmt:message bundle="${loc}" key="local.tomainpagebtn"/></a>
            </div>
        </div>
    </div>
</div>

</div>
</body>

</html>
