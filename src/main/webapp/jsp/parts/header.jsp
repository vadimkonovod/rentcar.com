<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button"/>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/jsp/main.jsp">Car Rental</a>
        </div>
        <div class="collapse navbar-collapse">

            <ul class="nav navbar-nav">
                <li><a href="#" class="change-local" data-path="${pageContext.request.contextPath}/serv?command=change_lang" data-local="en">${en_button}</a></li>
                <li><a href="#" class="change-local" data-path="${pageContext.request.contextPath}/serv?command=change_lang" data-local="ru">${ru_button}</a></li>
            </ul>

            <c:if test="${sessionScope.account.role == 'user'}">
                <div class="navbar-right">
                    <p class="navbar-text"><fmt:message bundle="${loc}" key="local.hello"/>, ${sessionScope.account.name}</p>
                    <a href="${pageContext.request.contextPath}/serv?command=myaccount" class="btn btn-success navbar-btn"><fmt:message bundle="${loc}" key="local.myaccountbtn"/></a>
                    <a href="${pageContext.request.contextPath}/serv?command=logout" class="btn btn-danger navbar-btn"><fmt:message bundle="${loc}" key="local.logoutbtn"/></a>
                </div>
            </c:if>

            <c:if test="${sessionScope.account.role == 'admin'}">
                <div class="navbar-right">
                    <p class="navbar-text"><fmt:message bundle="${loc}" key="local.hello"/>, ${sessionScope.account.name}</p>
                    <a href="${pageContext.request.contextPath}/serv?command=show_cars&index=1" class="btn btn-default navbar-btn"><fmt:message bundle="${loc}" key="local.allcarsbtn"/></a>
                    <a href="${pageContext.request.contextPath}/serv?command=show_orders&index=1" class="btn btn-default navbar-btn"><fmt:message bundle="${loc}" key="local.allordersbtn"/></a>
                    <a href="${pageContext.request.contextPath}/serv?command=show_accounts" class="btn btn-default"><fmt:message bundle="${loc}" key="local.allaccountsbtn"/></a>
                    <a href="${pageContext.request.contextPath}/serv?command=myaccount" class="btn btn-success"><fmt:message bundle="${loc}" key="local.myaccountbtn"/></a>
                    <a href="${pageContext.request.contextPath}/serv?command=logout" class="btn btn-danger navbar-btn"><fmt:message bundle="${loc}" key="local.logoutbtn"/></a>
                </div>
            </c:if>

        </div>
    </div>
</nav>

<script>
    $('.change-local').on('click', function() {
        var path = $(this).data('path');
        var local = $(this).data('local');
        $.get(path + '&' + 'local=' + local, function(res){
            window.location.reload();
        });
        return false;
    });
</script>