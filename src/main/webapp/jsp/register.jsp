<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>

    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <title>Car Rental - <fmt:message bundle="${loc}" key="local.registerpage"/></title>
    <meta charset="utf-8">
    <jsp:include page="parts/commonHeaderPart.jsp"/>
    <script type="text/javascript">
        function check(){
            var age = document.getElementsByName("age")[0].value;
            var email = document.getElementsByName("email")[0].value;
            var atpos = email.indexOf("@");
            var dotpos = email.lastIndexOf(".");
            if(!document.getElementsByName("name")[0].value){
                document.getElementsByName("name")[0].focus();
                alert("<fmt:message bundle="${loc}" key="local.registration.error.name"/>");
                return false;
            } else if (!document.getElementsByName("surname")[0].value) {
                document.getElementsByName("surname")[0].focus();
                alert("<fmt:message bundle="${loc}" key="local.registration.error.surname"/>");
                return false;
            } else if (!age || isNaN(age)) {
                document.getElementsByName("age")[0].focus();
                alert("<fmt:message bundle="${loc}" key="local.registration.error.age"/>");
                return false;
            } else if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=email.length) {
                document.getElementsByName("email")[0].focus();
                alert("<fmt:message bundle="${loc}" key="local.registration.error.email"/>");
                return false;
            } else if (!document.getElementsByName("login")[0].value) {
                document.getElementsByName("login")[0].focus();
                alert("<fmt:message bundle="${loc}" key="local.registration.error.username"/>");
                return false;
            } else if (!document.getElementsByName("password")[0].value) {
                document.getElementsByName("password")[0].focus();
                alert("<fmt:message bundle="${loc}" key="local.registration.error.password"/>");
                return false;
            } else if (!document.getElementsByName("verpassword")[0].value) {
                document.getElementsByName("verpassword")[0].focus();
                alert("<fmt:message bundle="${loc}" key="local.registration.error.passwordver"/>");
                return false;
            }
        }
    </script>
</head>
<body>
<jsp:include page="parts/header.jsp"/>
<div class="container">
    <div class="row">
        <form class="col-xs-4 col-xs-offset-4" onsubmit="return check()" action="${pageContext.request.contextPath}/serv?command=register_account" method="post" >
            <div class="form-group">
                <label class="pull-left"><fmt:message bundle="${loc}" key="local.registration.name"/></label>
                <input type="text" name="name" class="form-control">
            </div>
            <div class="form-group">
                <label class="pull-left"><fmt:message bundle="${loc}" key="local.registration.surname"/></label>
                <input type="text" name="surname" class="form-control">
            </div>
            <div class="form-group">
                <label class="pull-left"><fmt:message bundle="${loc}" key="local.registration.age"/></label>
                <input type="text" name="age" class="form-control">
            </div>
            <div class="form-group">
                <label class="pull-left"><fmt:message bundle="${loc}" key="local.registration.email"/></label>
                <input type="text" name="email" class="form-control">
            </div>
            <c:if test="${not empty emailNotValidPassMessage}">
                <div class="form-group">
                    <a style="color: red;">${emailNotValidPassMessage}</a>
                </div>
            </c:if>
            <div class="form-group">
                <label class="pull-left"><fmt:message bundle="${loc}" key="local.registration.username"/></label>
                <input type="text" name="login" class="form-control">
            </div>
            <div class="form-group">
                <label class="pull-left"><fmt:message bundle="${loc}" key="local.registration.password"/></label>
                <input type="password" name="password" class="form-control">
            </div>
            <div class="form-group">
                <label class="pull-left"><fmt:message bundle="${loc}" key="local.registration.confirmpass"/></label>
                <input type="password" name="verpassword" class="form-control">
            </div>
            <c:if test="${not empty passwordNotValidPassMessage}">
                <div class="form-group">
                    <a style="color: red;">${passwordNotValidPassMessage }</a>
                </div>
            </c:if>
            <c:if test="${not empty registerNotValidPassMessage}">
                <div class="form-group">
                    <a style="color: red;">${registerNotValidPassMessage}</a>
                </div>
            </c:if>
            <button type="submit" class="btn-success btn pull-right"><fmt:message bundle="${loc}" key="local.registration.join"/></button>
        </form>
    </div>
</div>
</body>
</html>
